package com.pj2r.dsame.sort

object ShellSort extends App {
  def sort(a: Array[Int]): Array[Int] = {
    var h = a.length / 2
    while (h > 0) {
      for (i <- 1 until a.length) {
        val cur = a(i)
        var j = i - h
        while (j >= 0 && a(j) > cur) {
          a(j + h) = a(j)
          j -= h
        }
        j += h
        if (a(j) != cur)
          a(j) = cur
      }
      h /= 2
      //      println(a.mkString(", "))
    }
    a
  }

  // TEST
  val a = Array(64, 34, 12, 25, 12, 22, 11, 90)
  println(sort(a).mkString(", "))
}