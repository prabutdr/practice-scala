package com.pj2r.dsame.search

object P72_SortThree extends App {
  def sort(a: Array[Int]): Array[Int] = {
    def swap(i: Int, j: Int) = {
      val t = a(i)
      a(i) = a(j)
      a(j) = t
    }

    var low = 0
    var mid = 0
    var high = a.length - 1
    while (mid <= high) {
      a(mid) match {
        case 0 =>
          swap(low, mid)
          low += 1
          mid += 1
        case 1 =>
          mid += 1
        case 2 =>
          swap(mid, high)
          high -= 1
      }
    }
    a
  }
}