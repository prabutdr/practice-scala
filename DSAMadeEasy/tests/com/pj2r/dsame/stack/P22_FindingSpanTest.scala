package com.pj2r.dsame.stack

import scala.collection.mutable.Stack
import org.scalatest.FunSuite
import org.scalatest.BeforeAndAfter
import org.junit.runner.RunWith
import org.scalatest.junit.JUnitRunner

@RunWith(classOf[JUnitRunner])
class P22_FindingSpanTest extends FunSuite with BeforeAndAfter {
  val validInputs = List(
    (Array(6, 3, 4, 5, 2), Array(1, 1, 2, 3, 1)),
    (Array(100, 80, 60, 70, 60, 75, 85), Array(1, 1, 1, 2, 1, 4, 6)))
  validInputs.foreach({
    case (input, output) => {
      test(s"Span of [${input.mkString(", ")}] is [${output.mkString(", ")}]") {
        assertResult(output)(P22_FindingSpans.calculateSpan(input))
      }
    }
  })

}