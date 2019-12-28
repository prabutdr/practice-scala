package com.pj2r.dsame.sort

object CountingSort extends App {
  // numbers between 1 to 10
  def sort(a: Array[Int]): Array[Int] = {
    val c = Array.ofDim[Int](10)
    for (i <- 0 until a.length)
      c(a(i) - 1) += 1

    var ai = 0
    for (i <- 0 until a.length)
      while (c(i) > 0) {
        a(ai) = i + 1
        c(i) -= 1
        ai += 1
      }

    a
  }

  // numbers between 1 to 10
  def sort1(a: Array[Int]): Array[Int] = {
    val c = Array.ofDim[Int](11)
    val b = Array.ofDim[Int](a.length)

    for (i <- 0 until a.length)
      c(a(i)) += 1

    for (i <- 1 until c.length)
      c(i) += c(i - 1)

    //    println(c.mkString(", "))
    for (i <- 0 until a.length) {
      c(a(i)) -= 1
      b(c(a(i))) = a(i)
    }

    b
  }

  // TEST
  val a = Array(5, 5, 2, 4, 1, 3, 3, 6)
  println(sort(a).mkString(", "))
  val a1 = Array(5, 5, 2, 4, 1, 3, 3, 6)
  println(sort1(a1).mkString(", "))
}