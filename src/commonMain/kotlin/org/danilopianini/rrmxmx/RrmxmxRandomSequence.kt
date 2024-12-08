package org.danilopianini.rrmxmx

import org.danilopianini.rrmxmx.Rrmxmx.rrmxmx

/**
 * Generates a random sequence of ULong from a specified seed using rrmxmx.
 * @param seed the seed to use
 */
class RrmxmxRandomSequence(
    seed: ULong,
) : Sequence<ULong> by generateSequence(
        rrmxmx(seed + GAMMA),
        { rrmxmx(it + GAMMA) },
    ) {
    private companion object {
        private const val GAMMA = 0x40ead42ca1cd0131UL
    }
}
