package com.noodlesandwich.numeric

import org.junit.runner.RunWith
import org.scalatest.junit.JUnitRunner
import org.scalatest.{FunSpec, Matchers}

@RunWith(classOf[JUnitRunner])
class InverseSquareRootSpec extends FunSpec with Matchers with InverseSquareRootBehaviours {
  describe("the inverse square root function") {
    it should behave like inverseSquareRoot(InverseSquareRoot.apply)
  }
}
