package com.pj2r.dsame.search

object P40_FindPosOfZeroStart extends App {
  def find(a: Array[Int]): Int = {
    var i = 0
    var si = 0
    var n = 0
    while (i < a.length) {
      //      println(n + " " + si + " " + i)
      if (a(i) == 0) {
        if (i == si)
          return i
        else {
          si = (i - Math.pow(2, n).toInt) + 1
          n = 0
        }
      } else {
        n += 1
        i = si + Math.pow(2, n).toInt
      }
    }
    return -1
  }

  // TEST - Not complete
  println(find(Array(1, 1, 1, 1, 0, 0, 0)))
  println(find(Array(1, 1, 1, 0, 0, 0)))
  println(find(Array(1, 1, 0, 0, 0)))
  println(find(Array(1, 0, 0, 0)))
  println(find(Array(0, 0, 0)))
}