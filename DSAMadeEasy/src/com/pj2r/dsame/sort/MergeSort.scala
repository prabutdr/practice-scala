package com.pj2r.dsame.sort

object MergeSort extends App {
  def sort(a: Array[Int]): Array[Int] = {
    mergeSort(a, 0, a.length - 1)
    a
  }

  private def mergeSort(a: Array[Int], left: Int, right: Int): Unit = {
    if (left < right) {
      val mid = (left + right) / 2
      mergeSort(a, left, mid)
      mergeSort(a, mid + 1, right)
      merge(a, left, mid + 1, right)
    }
  }

  private def merge(a: Array[Int], left: Int, mid: Int, right: Int) {
    val t = Array.ofDim[Int](right - left + 1)
    var li = left
    var ri = mid
    var ti = 0
    while (li < mid && ri <= right) {
      if (a(li) > a(ri)) {
        t(ti) = a(ri)
        ti += 1
        ri += 1
      } else {
        t(ti) = a(li)
        ti += 1
        li += 1
      }
    }
    while (li < mid) {
      t(ti) = a(li)
      ti += 1
      li += 1
    }
    while (ri <= right) {
      t(ti) = a(ri)
      ti += 1
      ri += 1
    }
    li = left
    for (i <- 0 until t.length) {
      a(li) = t(i)
      li += 1
    }
  }

  // TEST
  val a = Array(64, 34, 12, 25, 12, 22, 11, 90)
  println(sort(a).mkString(", "))
}