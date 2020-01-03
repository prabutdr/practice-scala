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

@RunWith(classOf[JUnitRunner])
class P72_SortThreeTest extends FunSuite with BeforeAndAfter {
  val inputs = List(
    (Array(1), Array(1)),
    (Array[Int](), Array[Int]()),
    (Array(0, 1), Array(0, 1)),
    (Array(2, 1, 0), Array(0, 1, 2)),
    (Array(0, 1, 1, 0, 1, 2, 1, 2, 0, 0, 0, 1), Array(0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 2, 2)),
    (Array(2, 0, 1), Array(0, 1, 2)))

  inputs.foreach({
    case (input, output) => {
      test(s"Soft of three distinct value array ${input.mkString("[", ", ", "]")} is = ${output.mkString("[", ", ", "]")}") {
        assertResult(output)(P72_SortThree.sort(input))
      }
    }
  })

}