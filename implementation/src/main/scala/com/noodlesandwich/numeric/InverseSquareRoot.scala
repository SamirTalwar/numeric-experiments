package com.noodlesandwich.numeric

object InverseSquareRoot {
  def apply(n: Double): Double = {
    if (n <= 0)
      return Double.NaN

    new NewtonRaphson(x => 1 / (x * x) - n, x => -2 / (x * x * x)).apply(1)
  }
}
