package com.pj2r.dsame.heap

import org.junit.runner.RunWith
import org.scalatest.junit.JUnitRunner
import org.scalatest.FunSuite
import org.scalatest.BeforeAndAfter

@RunWith(classOf[JUnitRunner])
class PXX_HeapSortTest extends FunSuite with BeforeAndAfter {
  val inputs = List(
    (Array(1, 2, 3, 4, 5, 6, 7), Array(1, 2, 3, 4, 5, 6, 7)),
    (Array(2, 4, 9, 0, -1, 89), Array(-1, 0, 2, 4, 9, 89)),
    (Array(0), Array(0)))
  inputs.foreach({
    case (input, output) => {
      test(s"${input.mkString(", ")} sorted by heap sort = ${output.mkString(", ")}") {
        assertResult(output)(PXX_HeapSort.heapSort(input))
      }
    }
  })

}