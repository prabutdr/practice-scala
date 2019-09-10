package com.pj2r.dsame.stack

import scala.collection.mutable.Stack
import org.scalatest.FunSuite
import org.scalatest.BeforeAndAfter
import org.junit.runner.RunWith
import org.scalatest.junit.JUnitRunner

@RunWith(classOf[JUnitRunner])
class P25_SortingStackTest extends FunSuite with BeforeAndAfter {
  val inputs = List(
    (Stack(1, 2, 3, 4, 5), Stack(5, 4, 3, 2, 1)),
    (Stack(5, 4, 3, 2, 1), Stack(5, 4, 3, 2, 1)),
    (Stack[Int](), Stack[Int]()),
    (Stack(1), Stack(1)),
    (Stack(2, 4, 5, 3, 1), Stack(5, 4, 3, 2, 1)),
    (Stack(4, 5, -2, -3, 11, 10, 5, 6, 20), Stack(20, 11, 10, 6, 5, 5, 4, -2, -3)))
  inputs.foreach({
    case (input, output) => {
      test(s"Sorted version of stack $input is $output") {
        assertResult(output)(P25_SortingStack.sortStack(input))
      }
    }
  })

}