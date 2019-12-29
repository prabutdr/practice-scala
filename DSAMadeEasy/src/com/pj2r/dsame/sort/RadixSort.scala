package com.pj2r.dsame.sort

object RadixSort extends App {
  def sort(a: Array[Int]): Array[Int] = {
    var e = 1
    val max = a.max
    while (max / e > 0) {
      countSort(a, e)
      e *= 10
    }
    a
  }

  def countSort(a: Array[Int], e: Int): Array[Int] = {
    val c = Array.ofDim[Int](10)
    val b = Array.ofDim[Int](a.length)

    for (i <- 0 until a.length)
      c((a(i) / e) % 10) += 1

    for (i <- 1 until c.length)
      c(i) += c(i - 1)

    for (i <- a.length - 1 to 0 by -1) {
      c((a(i) / e) % 10) -= 1
      b(c((a(i) / e) % 10)) = a(i)
    }

    //    println(b.mkString(","))
    for (i <- 0 until a.length)
      a(i) = b(i)

    a
  }

  // TEST
  val a = Array(64, 34, 12, 25, 12, 22, 11, 90)
  println(sort(a).mkString(", "))
}