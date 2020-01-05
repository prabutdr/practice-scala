package com.pj2r.dsame.selection

object P10_FindKthLargest extends App {
  def partition(a: Array[Int], start: Int, end: Int): Int = {
    //    println("partition: " + a.mkString(", ") + ": " + start + ": " + end)
    if (start == end)
      return start
    def swap(i: Int, j: Int) = {
      val t = a(i)
      a(i) = a(j)
      a(j) = t
    }

    var left = start
    var right = end - 1
    var pivot = end

    while (left < right) {
      while (left < right && a(left) < a(pivot))
        left += 1
      while (left < right && a(right) >= a(pivot))
        right -= 1

      //      println(left + ": " + right)
      if (left < right)
        swap(left, right)
    }

    if (a(right) > a(pivot))
      swap(right, pivot)
    //    println("Right: " + right + ":" + a.mkString(", "))
    right
  }

  def find(a: Array[Int], k: Int): Int = {
    var start = 0
    var end = a.length - 1
    var p = partition(a, start, end)
    while (p != k - 1) {
      //      println(p + ": " + k + ": " + start + ": " + end)
      if (p < k - 1) {
        start = p + 1
      } else {
        end = p - 1
      }
      p = partition(a, start, end)
    }
    a(p)
  }

  // TEST
  println(find(Array(34, 2, 7, 8, 9, 1), 1))
  println(find(Array(34, 2, 7, 8, 9, 1), 2))
  println(find(Array(34, 2, 7, 8, 9, 1), 3))
  println(find(Array(34, 2, 7, 8, 9, 1), 4))
  println(find(Array(34, 2, 7, 8, 9, 1), 5))
  println(find(Array(34, 2, 7, 8, 9, 1), 6))
}