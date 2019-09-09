package com.pj2r.dsame.stack

import scala.collection.mutable.Stack
import org.scalatest.FunSuite
import org.scalatest.BeforeAndAfter
import org.junit.runner.RunWith
import org.scalatest.junit.JUnitRunner

@RunWith(classOf[JUnitRunner])
class P24_LargestRectHistogramTest extends FunSuite with BeforeAndAfter {
  val inputs = List(
    (Array(3, 2, 5, 6, 1, 4, 4), 10),
    (Array(1, 2, 4), 4), (Array(2, 1, 2, 3, 1), 5))
  inputs.foreach({
    case (input, output) => {
      test(s"Max rectangle are of histogram [${input.mkString(", ")}] is $output") {
        assertResult(output)(P24_LargestRectHistogram.findLargestRect(input))
      }
    }
  })

}