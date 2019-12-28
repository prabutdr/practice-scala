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

@RunWith(classOf[JUnitRunner])
class SortTests extends FunSuite with BeforeAndAfter {
  val inputs = List(
    (Array(1, 2, 3, 4, 5, 6, 7), Array(1, 2, 3, 4, 5, 6, 7)),
    (Array(2, 4, 9, 0, -1, 89), Array(-1, 0, 2, 4, 9, 89)),
    (Array(0), Array(0)),
    (Array(64, 34, 12, 25, 12, 22, 11, 90), Array(11, 12, 12, 22, 25, 34, 64, 90)))

  inputs.foreach({
    case (input, output) => {
      test(s"Bubble sort of ${input.mkString("[", ", ", "]")} is = ${output.mkString("[", ", ", "]")}") {
        assertResult(output)(BubbleSort.bubbleSort(input))
      }
    }
  })

  inputs.foreach({
    case (input, output) => {
      test(s"Selection sort of ${input.mkString("[", ", ", "]")} is = ${output.mkString("[", ", ", "]")}") {
        assertResult(output)(SelectionSort.sort(input))
      }
    }
  })

  inputs.foreach({
    case (input, output) => {
      test(s"Insertion sort of ${input.mkString("[", ", ", "]")} is = ${output.mkString("[", ", ", "]")}") {
        assertResult(output)(InsertionSort.sort(input))
      }
    }
  })

  inputs.foreach({
    case (input, output) => {
      test(s"Shell sort of ${input.mkString("[", ", ", "]")} is = ${output.mkString("[", ", ", "]")}") {
        assertResult(output)(ShellSort.sort(input))
      }
    }
  })

  inputs.foreach({
    case (input, output) => {
      test(s"Merge sort of ${input.mkString("[", ", ", "]")} is = ${output.mkString("[", ", ", "]")}") {
        assertResult(output)(MergeSort.sort(input))
      }
    }
  })
}