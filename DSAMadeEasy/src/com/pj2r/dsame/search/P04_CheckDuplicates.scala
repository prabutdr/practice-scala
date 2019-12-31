package com.pj2r.dsame.search

object P04_CheckDuplicates extends App {
  def check(a: Array[Int]): Boolean = {
    for (i <- 0 until a.length) {
      if (a(a(i).abs - 1) < 0) {
        for (j <- 0 until a.length)
          a(j) = a(j).abs
        return true
      }
      a(a(i).abs - 1) *= -1
    }
    return false
  }

  // TEST
  val a = Array(3, 2, 1, 2, 2, 3)
  println(check(a))

}