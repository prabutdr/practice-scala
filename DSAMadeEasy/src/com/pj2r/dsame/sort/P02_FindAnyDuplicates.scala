package com.pj2r.dsame.sort

object P02_FindAnyDuplicates extends App {
  def isAnyDuplicates(a: Array[Int]): Boolean = {
    MergeSort.sort(a)

    for (i <- 1 until a.length)
      if (a(i) == a(i - 1))
        return true

    return false
  }
}