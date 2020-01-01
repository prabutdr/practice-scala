package com.pj2r.dsame.search

object FindTwoRepeatingNums extends App {
  def find(a: Array[Int]): (Int, Int) = {
    val n = a.length - 2 // excluding two repeated elements
    var xy = a(0)
    for (i <- 1 until a.length) xy ^= a(i)
    for (i <- 1 to n) xy ^= i
    val rmsb = xy & ~(xy - 1) // right most set bit

    var (x, y) = (0, 0)
    for (i <- 0 until a.length) if ((a(i) & rmsb) == 0) x ^= a(i) else y ^= a(i)
    for (i <- 1 to n) if ((i & rmsb) == 0) x ^= i else y ^= i

    (x, y)
  }

  // TEST
  println(find(Array(4, 2, 4, 5, 2, 3, 1)))
}