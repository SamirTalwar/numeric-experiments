package com.noodlesandwich.numeric

import sun.misc.Unsafe

object FastInverseSquareRoot {
  private val ThreeHalves = 1.5F
  private val SizeInBytes = 4L

  def apply(n: Float): Float = {
    if (n <= 0)
      return Float.NaN

    val x2 = n / 2
    var y = n
    var i = castToInt(y)
    i = 0x5f3759df - (i >> 1) // what the fuck?
    y = castToFloat(i)
    y = y * (ThreeHalves - (x2 * y * y)) // 1st iteration
//    y = y * (ThreeHalves - (x2 * y * y)) // 2nd iteration, this can be removed
    y
  }

  private def castToInt(value: Float): Int = {
    val reference = unsafe.allocateMemory(SizeInBytes)
    unsafe.putFloat(reference, value)
    val result = unsafe.getInt(reference)
    unsafe.freeMemory(reference)
    result
  }

  private def castToFloat(value: Int): Float = {
    val reference = unsafe.allocateMemory(SizeInBytes)
    unsafe.putInt(reference, value)
    val result = unsafe.getFloat(reference)
    unsafe.freeMemory(reference)
    result
  }

  private lazy val unsafe: Unsafe = {
    val field = classOf[Unsafe].getDeclaredField("theUnsafe")
    field.setAccessible(true)
    field.get(null).asInstanceOf[Unsafe]
  }
}
