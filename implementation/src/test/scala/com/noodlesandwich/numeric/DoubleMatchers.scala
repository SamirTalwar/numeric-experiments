package com.noodlesandwich.numeric

import org.scalatest.matchers.{MatchResult, Matcher}

object DoubleMatchers {
  val beNaN: Matcher[Double] = new Matcher[Double] {
    override def apply(actual: Double): MatchResult = MatchResult(
      actual.isNaN,
      s"expected $actual to be NaN",
      s"expected $actual not to be NaN"
    )
  }
}
