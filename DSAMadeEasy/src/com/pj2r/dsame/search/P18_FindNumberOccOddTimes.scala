package com.pj2r.dsame.search

object P18_FindNumberOccOddTimes extends App {
  def find(a: Array[Int]): Int = {
    var x = a(0)
    for (i <- 1 until a.length) x ^= a(i)
    x
  }

  // TEST
  println(find(Array(1, 2, 3, 2, 3, 1, 3)))
}