package com.noodlesandwich.numeric

import sun.misc.Unsafe

// Not thread-safe.
object FastInverseSquareRoot {
  private val ThreeHalves = 1.5F
  private val SizeInBytes = 4L

  private val transientStorage = unsafe.allocateMemory(SizeInBytes)

  override def finalize(): Unit = unsafe.freeMemory(transientStorage)

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
    unsafe.putFloat(transientStorage, value)
    unsafe.getInt(transientStorage)
  }

  private def castToFloat(value: Int): Float = {
    unsafe.putInt(transientStorage, value)
    unsafe.getFloat(transientStorage)
  }

  private lazy val unsafe: Unsafe = {
    val field = classOf[Unsafe].getDeclaredField("theUnsafe")
    field.setAccessible(true)
    field.get(null).asInstanceOf[Unsafe]
  }
}
