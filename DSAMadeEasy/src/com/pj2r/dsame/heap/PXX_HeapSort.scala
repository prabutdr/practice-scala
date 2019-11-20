package com.pj2r.dsame.heap

object PXX_HeapSort extends App {
  def heapSort(a: Array[Int]): Array[Int] = {
    for (i <- a.length / 2 - 1 to 0 by -1)
      heapify(a, i, a.length)

    for (i <- a.length - 1 to 0 by -1) {
      val t = a(i)
      a(i) = a(0)
      a(0) = t

      heapify(a, 0, i)
    }
    a
  }

  private def heapify(a: Array[Int], i: Int, size: Int): Unit = {
    val l = 2 * i + 1
    val r = 2 * i + 2

    var max = if (l < size && a(l) > a(i)) l else i
    max = if (r < size && a(r) > a(max)) r else max

    if (max != i) {
      val t = a(i)
      a(i) = a(max)
      a(max) = t
      heapify(a, max, size)
    }
  }
}