package com.pj2r.dsame.heap

import org.junit.runner.RunWith
import org.scalatest.junit.JUnitRunner
import org.scalatest.FunSuite
import org.scalatest.BeforeAndAfter

@RunWith(classOf[JUnitRunner])
class P07_FindMinInMaxHeapTest extends FunSuite with BeforeAndAfter {
  val inputs = List(
    (MaxHeap(1, 2, 3, 4, 5, 6, 7), 1),
    (MaxHeap(2, 4, 9, 0, -1, 89), -1),
    (MaxHeap(0), 0))
  inputs.foreach({
    case (input, output) => {
      test(s"Minimum from $input is $output") {
        assertResult(output)(P07_FindMinInMaxHeap.findMin(input))
      }
    }
  })

  val invalidInputs = List(
    (MaxHeap()),
    (null))
  invalidInputs.foreach({
    case (input) => {
      test(s"Minimum from $input is not possible") {
        assertThrows[IllegalArgumentException] {
          P07_FindMinInMaxHeap.findMin(input)
        }
      }
    }
  })

}