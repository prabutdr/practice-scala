package com.pj2r.dsame.search

object P16_FindMissing1ToN extends App {
  def find(a: Array[Int]): Int = {
    var aSum = 0
    for (i <- 0 until a.length) aSum += a(i)
    val n = a.length + 1
    val nSum = (n * (n + 1)) / 2

    nSum - aSum
  }

  // Test
  val a = Array(1, 2, 4, 6, 3, 7, 8)
  println(find(a))
}