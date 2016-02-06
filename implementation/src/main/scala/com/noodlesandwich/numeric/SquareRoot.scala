package com.noodlesandwich.numeric

object SquareRoot {
  def apply(n: Double): Double = {
    if (n <= 0)
      return Double.NaN

    new NewtonRaphson(x => x * x - n, x => 2 * x).apply(n)
  }
}
