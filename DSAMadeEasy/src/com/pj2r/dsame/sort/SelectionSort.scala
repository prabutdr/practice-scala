package com.pj2r.dsame.sort

object SelectionSort extends App {
  def sort(a: Array[Int]): Array[Int] = {
    for (i <- 0 until a.length - 1) {
      var min = i
      for (j <- i + 1 until a.length) {
        if (a(min) > a(j))
          min = j
      }
      // swift if minimum value found for this position
      if (min != i) {
        val t = a(min)
        a(min) = a(i)
        a(i) = min
      }
    }
    a
  }
}