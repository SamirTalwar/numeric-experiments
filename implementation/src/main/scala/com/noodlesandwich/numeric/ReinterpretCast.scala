package com.noodlesandwich.numeric

import sun.misc.Unsafe

// Not thread-safe.
object ReinterpretCast {
  private val SizeInBytes = 4L

  private lazy val unsafe: Unsafe = {
    val field = classOf[Unsafe].getDeclaredField("theUnsafe")
    field.setAccessible(true)
    field.get(null).asInstanceOf[Unsafe]
  }

  private val transientStorage = unsafe.allocateMemory(SizeInBytes)

  override protected def finalize(): Unit = unsafe.freeMemory(transientStorage)

  def floatToInt(value: Float): Int = {
    unsafe.putFloat(transientStorage, value)
    unsafe.getInt(transientStorage)
  }

  def intToFloat(value: Int): Float = {
    unsafe.putInt(transientStorage, value)
    unsafe.getFloat(transientStorage)
  }
}
