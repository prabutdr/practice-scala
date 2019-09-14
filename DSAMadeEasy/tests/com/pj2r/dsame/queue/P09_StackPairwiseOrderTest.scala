package com.pj2r.dsame.queue

import scala.collection.mutable.Stack

import org.junit.runner.RunWith
import org.scalatest.BeforeAndAfter
import org.scalatest.FunSuite
import org.scalatest.junit.JUnitRunner

@RunWith(classOf[JUnitRunner])
class P09_StackPairwiseOrderTest extends FunSuite with BeforeAndAfter {
  val inputs = List(
    (Stack(4, 5, -2, -3, 11, 10, 5, 6, 20), true),
    (Stack(4), true),
    (Stack(4, 5), true),
    (Stack(1, 1), false),
    (Stack(20, 6, 5, 10, 11, -3, -2, 5, 4), false))
  inputs.foreach({
    case (input, output) => {
      test(s"Stack $input is pairwise ordered = $output") {
        assertResult(output)(P09_StackPairwiseOrder.checkStackPairwiseOrder(input))
      }
    }
  })

}