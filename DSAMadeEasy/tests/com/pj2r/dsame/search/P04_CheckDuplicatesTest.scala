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
import com.pj2r.dsame.search.P04_CheckDuplicates

@RunWith(classOf[JUnitRunner])
class P04_CheckDuplicatesTest extends FunSuite with BeforeAndAfter {
  val inputs = List(
    (Array(1, 1), true),
    (Array(1), false),
    (Array(3, 2, 1, 2, 2, 3), true))

  inputs.foreach({
    case (input, output) => {
      test(s"Wave form of ${input.mkString("[", ", ", "]")} is = ${output}") {
        assertResult(output)(P04_CheckDuplicates.check(input))
      }
    }
  })

}