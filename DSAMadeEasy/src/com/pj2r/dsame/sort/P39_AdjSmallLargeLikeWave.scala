package com.pj2r.dsame.sort

object P39_AdjSmallLargeLikeWave extends App {
  // O(n*logn)
  def convertAsWave(a: Array[Int]): Array[Int] = {
    QuickSort.sort(a)

    for (i <- 1 until a.length by 2) {
      val t = a(i)
      a(i) = a(i - 1)
      a(i - 1) = t
    }

    a
  }

  // O(n)
  def convertAsWave1(a: Array[Int]): Array[Int] = {
    def swap(i: Int, j: Int) {
      val t = a(i)
      a(i) = a(j)
      a(j) = t
    }

    for (i <- 1 until a.length by 2) {
      if (a(i) < a(i - 1))
        swap(i, i - 1)
      if (i + 1 < a.length && a(i) < a(i + 1))
        swap(i, i + 1)
    }

    a
  }
}