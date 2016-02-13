package com.noodlesandwich.numeric

// Not thread-safe.
object FastInverseSquareRoot {
  private val ThreeHalves = 1.5F

  def apply(n: Float): Float = {
    if (n <= 0)
      return Float.NaN

    val x2 = n / 2
    var y = n
    var i = ReinterpretCast.floatToInt(y)
    i = 0x5f3759df - (i >> 1) // what the fuck?
    y = ReinterpretCast.intToFloat(i)
    y = y * (ThreeHalves - (x2 * y * y)) // 1st iteration
//    y = y * (ThreeHalves - (x2 * y * y)) // 2nd iteration, this can be removed
    y
  }
}
