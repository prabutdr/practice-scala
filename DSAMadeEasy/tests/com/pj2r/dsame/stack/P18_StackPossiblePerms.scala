package com.pj2r.dsame.stack

import scala.collection.mutable.Stack
import org.scalatest.FunSuite
import org.scalatest.BeforeAndAfter
import org.junit.runner.RunWith
import org.scalatest.junit.JUnitRunner

@RunWith(classOf[JUnitRunner])
class P18_StackPossiblePermsTest extends FunSuite with BeforeAndAfter {
  val validInputs = List(
    ("123456", "325641", "SSSXXSSXSXXX"),
    ("123456", "321564", "SSSXXXSSXSXX"))
  validInputs.foreach({
    case (input, output, order) => {
      test(s"$input will form permutation $output with stack operations $order") {
        assertResult((true, order)) {
          P18_StackPossiblePerms.isPermPossible(input, output)
        }
      }
    }
  })

  val invalidInputs = List(
    ("123456", "154623"))
  invalidInputs.foreach({
    case (input, output) => {
      test(s"$input will not form permutation $output with stack operations") {
        assertResult((false, null)) {
          P18_StackPossiblePerms.isPermPossible(input, output)
        }
      }
    }
  })

}