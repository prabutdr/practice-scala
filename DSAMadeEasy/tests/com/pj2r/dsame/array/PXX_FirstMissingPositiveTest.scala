package com.pj2r.dsame.array

import org.junit.runner.RunWith
import org.scalatest.junit.JUnitRunner
import org.scalatest.FunSuite
import org.scalatest.BeforeAndAfter

@RunWith(classOf[JUnitRunner])
class PXX_FirstMissingPositiveTest extends FunSuite with BeforeAndAfter {
  val inputs = List(
    (Array(1, 2, 0), 3),
    (Array(3, 4, -1, 1), 2),
    (Array(1, 2, 3, 4, 5, 6, 7), 8),
    (Array(2, 4, 9, 0, -1, 89), 1),
    (Array(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 12, 89), 11),
    (Array(0), 1))

  inputs.foreach({
    case (array, output) => {
      test(s"First missing positive integer from ${array.mkString(", ")} is = ${output}") {
        assertResult(output)(PXX_FirstMissingPositive.find(array))
      }
    }
  })

}