package com.pj2r.dsame.sort

object QuickSort extends App {
  def sort(a: Array[Int]): Array[Int] = {
    quickSort(a, 0, a.length - 1)
    a
  }

  private def quickSort(a: Array[Int], left: Int, right: Int): Unit = {
    if (left < right) {
      val pivot = partition(a, left, right)
      quickSort(a, left, pivot - 1)
      quickSort(a, pivot + 1, right)
    }
  }

  private def partition(a: Array[Int], left: Int, right: Int): Int = {
    val pi = a(right)
    var li = left
    var ri = right

    while (li < ri) {
      while (li < ri && a(li) < pi)
        li += 1
      while (li < ri && a(ri) >= pi)
        ri -= 1
      if (li < ri) {
        val t = a(li)
        a(li) = a(ri)
        a(ri) = t
      }
    }
    a(right) = a(ri)
    a(ri) = pi
    ri
  }

  // TEST
  val a = Array(64, 34, 12, 25, 12, 22, 11, 90)
  println(sort(a).mkString(", "))
}