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
import com.pj2r.dsame.search.P72_SortThree
import com.pj2r.dsame.selection.P03_FindMinAndMax

@RunWith(classOf[JUnitRunner])
class P03_FindMinAndMaxTest extends FunSuite with BeforeAndAfter {
  val inputs = List(
    (Array(1, 2, 3, 4, 5, 6), (1, 6)),
    (Array(2, 4, 9, 0, -1, 89), (-1, 89)),
    (Array(0, 0), (0, 0)),
    (Array(1, 1, 0, 1), (0, 1)),
    (Array(64, 34, 12, 25, 12, 22, 11, 90), (11, 90)))

  inputs.foreach({
    case (input, output) => {
      test(s"Minimum and maximum values in array ${input.mkString("[", ", ", "]")} is = ${output}") {
        assertResult(output)(P03_FindMinAndMax.findPairwise(input))
      }
    }
  })

}