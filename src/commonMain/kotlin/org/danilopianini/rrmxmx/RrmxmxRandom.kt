package org.danilopianini.rrmxmx

import kotlin.random.Random

/**
 * A Random using rrmxmx under the hood.
 *
 * The sequence is reproducible for a given [seed]
 */
class RrmxmxRandom(val seed: ULong = DEFAULT_SEED) : Random() {
    private val sequence = RrmxmxRandomSequence(seed).iterator()
    private var current = sequence.next()
    private var consumed = 0

    constructor(seed: Int) : this(seed.toULong())

    override fun nextBits(bitCount: Int): Int =
        when (bitCount) {
            0 -> 0
            in Int.MIN_VALUE..(-1), in (Int.SIZE_BITS + 1)..Int.MAX_VALUE ->
                error("An Int cannot carry $bitCount bits of information, bitCount must be in 0..32")
            in 1..(ULong.SIZE_BITS - consumed) ->
            /*
             * Strategy: shift-left to delete the bits that have been consumed,
             * then shift right until the remaining bits are those to be returned.
             */
                current.shl(consumed).shr(ULong.SIZE_BITS - bitCount).toInt()
                    .also { consumed += bitCount }
            else -> {
                // More bits than available. Generating a new random.
                val next = sequence.next()
                current.shl(consumed)
                    .or(next.shr(ULong.SIZE_BITS - consumed))
                    .shr(ULong.SIZE_BITS - bitCount)
                    .toInt()
                    .also {
                        current = next
                        consumed = bitCount + consumed - ULong.SIZE_BITS
                    }
            }
        }

    /**
     * Container of constants.
     */
    companion object {
        /**
         * Default value of the random generator seed.
         */
        const val DEFAULT_SEED = 0x40ead42ca1cd0131UL
    }
}
