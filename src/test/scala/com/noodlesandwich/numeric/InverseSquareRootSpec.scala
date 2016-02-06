package com.noodlesandwich.numeric

import com.noodlesandwich.numeric.DoubleMatchers.beNaN
import org.junit.runner.RunWith
import org.scalatest.junit.JUnitRunner
import org.scalatest.{FunSpec, Matchers}

@RunWith(classOf[JUnitRunner])
class InverseSquareRootSpec extends FunSpec with Matchers {
  describe("the inverse square root function") {
    it("calculates the inverse square root of an inverse square number") {
      InverseSquareRoot(0.25) should be(2.0)
    }

    it("calculates an irrational inverse square root") {
      InverseSquareRoot(0.15625) should be(2.52982212813 +- 0.0000001)
    }

    it("calculates the inverse square root of 0 as NaN") {
      InverseSquareRoot(0) should beNaN
    }

    it("calculates the inverse square root of a negative number as NaN") {
      InverseSquareRoot(-3) should beNaN
    }
  }
}
