package com.pj2r.dsame.sort

object BubbleSort extends App {
  def bubbleSort(a: Array[Int]): Array[Int] = {
    var swapFound = false
    do {
      swapFound = false
      for (i <- 1 until a.length)
        if (a(i) < a(i - 1)) {
          val t = a(i)
          a(i) = a(i - 1)
          a(i - 1) = t
          swapFound = true
        }
    } while (swapFound)
    a
  }

  // TEST
  val a = Array(64, 34, 12, 25, 12, 22, 11, 90)
  println(bubbleSort(a).mkString(", "))
}