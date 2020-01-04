package com.pj2r.dsame.selection

object P04_FindSecondLargest extends App {
  def find(a: Array[Int]): Int = {
    var first = Integer.MIN_VALUE
    var second = Integer.MIN_VALUE
    for (i <- 0 until a.length) {
      if (a(i) > first) {
        second = first
        first = a(i)
      } else if (a(i) > second) {
        second = a(i)
      }
    }
    second
  }
}