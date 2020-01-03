package com.pj2r.dsame.selection

object P03_FindMinAndMax extends App {
  // should be even number of elements
  def findPairwise(a: Array[Int]): (Int, Int) = {
    var (min, max) = (Integer.MAX_VALUE, Integer.MIN_VALUE)
    for (i <- 0 until a.length by 2) {
      if (a(i) < a(i + 1)) {
        if (a(i) < min) min = a(i)
        if (a(i + 1) > max) max = a(i + 1)
      } else {
        if (a(i + 1) < min) min = a(i + 1)
        if (a(i) > max) max = a(i)
      }
    }
    (min, max)
  }

  // TEST
  println(findPairwise(Array(1, 2, 3, 4, 5, 6)))
}