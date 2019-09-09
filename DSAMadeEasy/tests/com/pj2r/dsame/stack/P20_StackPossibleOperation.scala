package com.pj2r.dsame.stack

import scala.collection.mutable.Stack
import org.scalatest.FunSuite
import org.scalatest.BeforeAndAfter
import org.junit.runner.RunWith
import org.scalatest.junit.JUnitRunner

@RunWith(classOf[JUnitRunner])
class P18_StackPossibleOperationTest extends FunSuite with BeforeAndAfter {
  val validInputs = List("SSSXXSSXSXXX", "SSSXXXSSXSXX", "SX")
  validInputs.foreach(input => {
    test(s"$input is valid stack operations") {
      assertResult(true) {
        P20_StackPossibleOperation.isPossible(input)
      }
    }
  })

  val invalidInputs = List("SSSXXXSSXSXXX", "XSSSXXXSSXSXX", "XS", "SXX")
  invalidInputs.foreach(input => {
    test(s"$input is not valid stack operations") {
      assertResult(false) {
        P20_StackPossibleOperation.isPossible(input)
      }
    }
  })

}