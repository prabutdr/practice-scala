package com.pj2r.dsame.heap

import org.junit.runner.RunWith
import org.scalatest.junit.JUnitRunner
import org.scalatest.FunSuite
import org.scalatest.BeforeAndAfter
import com.pj2r.dsame.sort.BubbleSort
import com.pj2r.dsame.sort.SelectionSort
import com.pj2r.dsame.sort.InsertionSort
import com.pj2r.dsame.sort.ShellSort
import com.pj2r.dsame.sort.MergeSort
import com.pj2r.dsame.sort.QuickSort
import com.pj2r.dsame.sort.RadixSort
import com.pj2r.dsame.sort.P39_AdjSmallLargeLikeWave

@RunWith(classOf[JUnitRunner])
class P39_AdjSmallLargeLikeWaveTest extends FunSuite with BeforeAndAfter {
  val inputs = List(
    (Array(1, 2, 3, 4, 5, 6, 7), Array(2, 1, 4, 3, 6, 5, 7)),
    (Array(2, 4, 9, 0, -1, 89), Array(0, -1, 4, 2, 89, 9)),
    (Array(0), Array(0)),
    (Array(64, 34, 12, 25, 12, 22, 11, 90), Array(12, 11, 22, 12, 34, 25, 90, 64)))

  inputs.foreach({
    case (input, output) => {
      test(s"Wave form of ${input.mkString("[", ", ", "]")} is = ${output.mkString("[", ", ", "]")}") {
        assertResult(output)(P39_AdjSmallLargeLikeWave.convertAsWave(input))
      }
    }
  })

  val inputs1 = List(
    (Array(1, 2, 3, 4, 5, 6, 7), Array(1, 3, 2, 5, 4, 7, 6)),
    (Array(2, 4, 9, 0, -1, 89), Array(2, 9, 0, 4, -1, 89)),
    (Array(0), Array(0)),
    (Array(64, 34, 12, 25, 12, 22, 11, 90), Array(34, 64, 12, 25, 12, 22, 11, 90)))

  inputs1.foreach({
    case (input, output) => {
      test(s"Wave form of ${input.mkString("[", ", ", "]")} is = ${output.mkString("[", ", ", "]")} - Improved") {
        assertResult(output)(P39_AdjSmallLargeLikeWave.convertAsWave1(input))
      }
    }
  })

}