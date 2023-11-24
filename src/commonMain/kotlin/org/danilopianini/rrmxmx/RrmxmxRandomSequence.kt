package org.danilopianini.rrmxmx

import org.danilopianini.rrmxmx.Rrmxmx.rrmxmx

/**
 * Generates a random sequence of ULong from a specified seed using rrmxmx.
 * @param seed the seed to use
 */
class RrmxmxRandomSequence(seed: ULong) : Sequence<ULong> by generateSequence(
    rrmxmx(seed + gamma),
    { rrmxmx(it + gamma) },
) {
    companion object {
        private const val gamma = 0x40ead42ca1cd0131UL
    }
}
