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
import com.pj2r.dsame.sort.P02_FindAnyDuplicates

@RunWith(classOf[JUnitRunner])
class P02_FindAnyDuplicatesTest extends FunSuite with BeforeAndAfter {
  val inputWithDuplicates = List(
    Array(1, 2, 3, 4, 5, 6, 7, 7),
    Array(2, 4, 9, 0, -1, 89, -1),
    Array(0, 0),
    Array(64, 34, 12, 25, 12, 22, 11, 90))

  inputWithDuplicates.foreach({
    case (input) => {
      test(s"Array ${input.mkString("[", ", ", "]")} has duplicates") {
        assert(P02_FindAnyDuplicates.isAnyDuplicates(input))
      }
    }
  })

  val inputWithNoDuplicates = List(
    Array(1, 2, 3, 4, 5, 6, 7),
    Array(2, 4, 9, 0, -1, 89),
    Array(0),
    Array[Int](),
    Array(64, 34, 25, 12, 22, 11, 90))

  inputWithNoDuplicates.foreach({
    case (input) => {
      test(s"Array ${input.mkString("[", ", ", "]")} has NO duplicates") {
        assert(!P02_FindAnyDuplicates.isAnyDuplicates(input))
      }
    }
  })

}