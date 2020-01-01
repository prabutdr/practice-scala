package com.pj2r.dsame.search

import scala.collection.mutable.ArrayBuffer
import com.pj2r.dsame.sort.QuickSort

object P27_TwoSum extends App {
  def find2Sum(a: Array[Int], k: Int): Array[(Int, Int)] = {
    val res = ArrayBuffer[(Int, Int)]()
    QuickSort.sort(a)

    var (left, right) = (0, a.length - 1)
    while (left < right) {
      val sum = a(left) + a(right)
      if (sum == k) {
        res += ((a(left), a(right)))
        left += 1
      } else if (sum < k) {
        left += 1
      } else {
        right -= 1
      }
    }

    res.toArray
  }

  // TEST
  println(find2Sum(Array(2, 7, 11, 15), 9).mkString(", "))
  println(find2Sum(Array(4, 5, 3, 2, 1, 6, 7), 9).mkString(", "))
  println(find2Sum(Array(4, 5, 3, 2, 1, 6, 7), 12).mkString(", "))
}