package com.pj2r.dsame.search

import scala.collection.mutable.Map

object P11_FirstRepeatedNum extends App {
  def findFirstRepeat(a: Array[Int]): Int = {
    val map = Map[Int, Int]()
    for (i <- 0 until a.length) {
      if (map.contains(a(i))) {
        if (map(a(i)) > 0) map += (a(i) -> -map(a(i)))
      } else {
        map += (a(i) -> (i + 1))
      }
    }

    println(map)
    var mi = Integer.MIN_VALUE
    for (v <- map.values if v <= 0) {
      if (mi < v) mi = v
    }

    if (mi == Integer.MIN_VALUE) -1 else a(-mi - 1)
  }

  // TEST
  val a = Array(3, 2, 1, 2, 2, 3)
  println(findFirstRepeat(a))

}