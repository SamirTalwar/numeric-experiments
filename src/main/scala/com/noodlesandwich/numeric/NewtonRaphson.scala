package com.noodlesandwich.numeric

class NewtonRaphson(f: Double => Double, fDerivative: Double => Double, epsilon: Double = 0.000000000000001) {
  def iterate(x: Double): Double =
    x - f(x) / fDerivative(x)

  def apply(x: Double): Double =
    Stream.iterate(x)(iterate)
      .sliding(2)
      .map { case Stream(a, b) => (a, b) }
      .dropWhile { case (a, b) => scala.math.abs(a - b) >= epsilon }
      .next
      ._2
}
