package com.pj2r.dsame.array

import java.util.Arrays
import scala.collection.mutable.Set

object PXX_FirstMissingPositive extends App {
  def find(data: Array[Int]): Int = {
    val a = Arrays.copyOf(data, data.length)
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

  def find1(data: Array[Int]): Int = {
    val a = Arrays.copyOf(data, data.length)
    for (i <- 0 until a.length) {
      var pval = a(i)
      while (pval > 0 && pval <= a.length && a(pval - 1) != pval) {
        val nval = a(pval - 1)
        a(pval - 1) = pval
        pval = nval
      }
      a(i) = pval

      //      println(a.mkString(", "))
    }

    for (i <- 0 until a.length) {
      if (a(i) != i + 1)
        return i + 1
    }
    return a.length + 1
  }

  def find2(data: Array[Int]): Int = {
    val a = Arrays.copyOf(data, data.length)
    val set = Set[Int]()
    var firstMissing = 1
    for (i <- 0 until a.length) {
      set += data(i)
      if (firstMissing == data(i))
        while (set.contains(firstMissing)) {
          set -= firstMissing
          firstMissing += 1
        }
    }
    firstMissing
  }

  // TEST
  println(find(Array(3, 4, -1, 1)))
  println(find1(Array(3, 4, -1, 1)))
}