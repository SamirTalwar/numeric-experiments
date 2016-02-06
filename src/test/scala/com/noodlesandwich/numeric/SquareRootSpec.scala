package com.noodlesandwich.numeric

import com.noodlesandwich.numeric.DoubleMatchers.beNaN
import org.junit.runner.RunWith
import org.scalatest.junit.JUnitRunner
import org.scalatest.{FunSpec, Matchers}

@RunWith(classOf[JUnitRunner])
class SquareRootSpec extends FunSpec with Matchers {
  describe("the square root function") {
    it("calculates the square root of a square number") {
      SquareRoot(9.0) should be(3.0)
    }

    it("calculates an irrational square root") {
      SquareRoot(2.0) should be(1.41421356237 +- 0.0000001)
    }

    it("calculates the square root of a number less than 1") {
      SquareRoot(0.25) should be(0.5)
    }

    it("calculates the square root of 0 as NaN") {
      SquareRoot(0) should beNaN
    }

    it("calculates the square root of a negative number as NaN") {
      SquareRoot(-3) should beNaN
    }
  }
}
