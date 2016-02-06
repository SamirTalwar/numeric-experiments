package com.noodlesandwich.numeric

import org.junit.runner.RunWith
import org.scalatest.junit.JUnitRunner
import org.scalatest.{FunSpec, Matchers}

@RunWith(classOf[JUnitRunner])
class FastInverseSquareRootSpec extends FunSpec with Matchers with InverseSquareRootBehaviours {
  val Epsilon = 0.01

  describe("the fast inverse square root function") {
    it should behave like inverseSquareRoot(n => FastInverseSquareRoot.apply(n.toFloat), Epsilon)
  }
}
