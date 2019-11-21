package com.pj2r.dsame.array

object PXX_FirstMissingPositive extends App {
  def find(a: Array[Int]): Int = {
    // arrange positive & negative integer partitions
    var pi = -1
    for (i <- 0 until a.length) {
      if (a(i) > 0) {
        pi += 1
        val t = a(i)
        a(i) = a(pi)
        a(pi) = t
      }
    }

    for (i <- 0 to pi) {
      var absi = a(i).abs - 1
      if (absi <= pi && a(absi) > 0) a(absi) = -a(absi)
    }
    //    println(pi)
    //    println(a.mkString(", "))

    var firstMissing = 0
    while (firstMissing <= pi) {
      if (a(firstMissing) > 0) {
        return firstMissing + 1
      }
      firstMissing += 1
    }
    firstMissing + 1
  }

  // TEST
  println(find(Array(1, 2, 0)))
}