package com.pj2r.dsame.sort

object InsertionSort extends App {
  def sort(a: Array[Int]): Array[Int] = {
    for (i <- 1 until a.length) {
      val cur = a(i)
      var j = i - 1
      while (j >= 0 && a(j) > cur) {
        a(j + 1) = a(j)
        j -= 1
      }
      j += 1
      if (a(j) != cur)
        a(j) = cur
    }
    a
  }
}