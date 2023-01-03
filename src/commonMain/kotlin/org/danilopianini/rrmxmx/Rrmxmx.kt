package org.danilopianini.rrmxmx

import kotlin.jvm.JvmStatic

/**
 * A Kotlin implementation of the [rrmxmx hash function](https://archive.vn/DhXjB).
 */
@Suppress("TooManyFunctions")
object Rrmxmx {
    private val M: ULong = 0x4fb21c651e98df25L.toULong() + 0x5000000000000000L.toULong()
    private const val S = 28
    private const val R1 = 49
    private const val R2 = 24

    /**
     * Shuffles [v] using rrmxmx.
     */
    @JvmStatic
    fun rrmxmx(v: ULong): ULong {
        var a: ULong = v xor ((v ror R1) xor (v ror R2))
        a *= M
        a = a xor (a shr S)
        a *= M
        return a xor (a shr S)
    }

    /**
     * Shuffles [v] using rrmxmx.
     */
    @JvmStatic
    fun rrmxmx(v: UInt): ULong = rrmxmx(v.toULong())

    /**
     * Shuffles [v] using rrmxmx.
     */
    @JvmStatic
    fun rrmxmx(v: UShort): ULong = rrmxmx(v.toULong())

    /**
     * Shuffles [v] using rrmxmx.
     */
    @JvmStatic
    fun rrmxmx(v: UByte): ULong = rrmxmx(v.toULong())

    /**
     * Shuffles [v] using rrmxmx.
     */
    @JvmStatic
    fun rrmxmx(v: Double): ULong = rrmxmx(v.toRawBits())

    /**
     * Shuffles [v] using rrmxmx.
     */
    @JvmStatic
    fun rrmxmx(v: Float): ULong = rrmxmx(v.toRawBits())

    /**
     * Shuffles [v] using rrmxmx.
     */
    @JvmStatic
    fun rrmxmx(v: Long): ULong = rrmxmx(v.toULong())

    /**
     * Shuffles [v] using rrmxmx.
     */
    @JvmStatic
    fun rrmxmx(v: Int): ULong = rrmxmx(v.toULong())

    /**
     * Shuffles [v] using rrmxmx.
     */
    @JvmStatic
    fun rrmxmx(v: Short): ULong = rrmxmx(v.toULong())

    /**
     * Shuffles [v] using rrmxmx.
     */
    @JvmStatic
    fun rrmxmx(v: Byte): ULong = rrmxmx(v.toULong())

    /**
     * Shuffles [v] using rrmxmx. Returns a Long.
     */
    @JvmStatic
    fun hash(v: ULong): Long = rrmxmx(v).toLong()

    /**
     * Shuffles [v] using rrmxmx. Returns a Long.
     */
    @JvmStatic
    fun hash(v: UInt): Long = rrmxmx(v).toLong()

    /**
     * Shuffles [v] using rrmxmx. Returns a Long.
     */
    @JvmStatic
    fun hash(v: UShort): Long = rrmxmx(v).toLong()

    /**
     * Shuffles [v] using rrmxmx. Returns a Long.
     */
    @JvmStatic
    fun hash(v: UByte): Long = rrmxmx(v).toLong()

    /**
     * Shuffles [v] using rrmxmx. Returns a Long.
     */
    @JvmStatic
    fun hash(v: Double): Long = rrmxmx(v).toLong()

    /**
     * Shuffles [v] using rrmxmx. Returns a Long.
     */
    @JvmStatic
    fun hash(v: Float): Long = rrmxmx(v).toLong()

    /**
     * Shuffles [v] using rrmxmx. Returns a Long.
     */
    @JvmStatic
    fun hash(v: Long): Long = rrmxmx(v).toLong()

    /**
     * Shuffles [v] using rrmxmx. Returns a Long.
     */
    @JvmStatic
    fun hash(v: Int): Long = rrmxmx(v).toLong()

    /**
     * Shuffles [v] using rrmxmx. Returns a Long.
     */
    @JvmStatic
    fun hash(v: Short): Long = rrmxmx(v).toLong()

    /**
     * Shuffles [v] using rrmxmx. Returns a Long.
     */
    @JvmStatic
    fun hash(v: Byte): Long = rrmxmx(v).toLong()

    /**
     * Extension method for ULong implementing a bitwise right rotation of [shift].
     */
    @JvmStatic
    infix fun ULong.ror(shift: Int): ULong = (this shr shift) or (this shl (ULong.SIZE_BITS - shift))
}
