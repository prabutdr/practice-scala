package com.pj2r.dsame.heap

import org.junit.runner.RunWith
import org.scalatest.junit.JUnitRunner
import org.scalatest.FunSuite
import org.scalatest.BeforeAndAfter

@RunWith(classOf[JUnitRunner])
class PXX_KLargestTest extends FunSuite with BeforeAndAfter {
  val inputs = List(
    (Array(1, 2, 3, 4, 5, 6, 7), 4, Array(5, 6, 7, 4)),
    (Array(2, 4, 9, 0, -1, 89), 1, Array(89)),
    (Array(2, 4, 9, 0, -1, 89), 2, Array(9, 89)),
    (Array(2, 4, 9, 0, -1, 89), 3, Array(4, 9, 89)),
    (Array(2, 4, 9, 0, -1, 89), 4, Array(2, 4, 9, 89)),
    (Array(2, 4, 9, 0, -1, 89), 5, Array(0, 2, 4, 9, 89)),
    (Array(2, 4, 9, 0, -1, 89), 6, Array(-1, 0, 2, 4, 9, 89)),
    (Array(0), 1, Array(0)))
  inputs.foreach({
    case (array, k, output) => {
      test(s"Largest $k elements from ${array.mkString(", ")} is = ${output.mkString(", ")}") {
        assertResult(output.sorted)(PXX_KLargest.findKLargest1(array, k).sorted)
      }
    }
  })

}