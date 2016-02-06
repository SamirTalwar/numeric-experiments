package com.noodlesandwich.numeric

import com.noodlesandwich.numeric.DoubleMatchers.beNaN
import org.junit.runner.RunWith
import org.scalatest.junit.JUnitRunner
import org.scalatest.{FunSpec, Matchers}

trait InverseSquareRootBehaviours extends Matchers { this: FunSpec =>
  def inverseSquareRoot(function: Double => Double, epsilon: Double = 0.0000001): Unit = {
    it("calculates the inverse square root of an inverse square number") {
      function(0.25) should be(2.0 +- epsilon)
    }

    it("calculates an irrational inverse square root") {
      function(0.15625) should be(2.52982212813 +- epsilon)
    }

    it("calculates the inverse square root of 0 as NaN") {
      function(0) should beNaN
    }

    it("calculates the inverse square root of a negative number as NaN") {
      function(-3) should beNaN
    }
  }
}
