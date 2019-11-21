package com.pj2r.dsame.heap

object PXX_KLargest extends App {
  // With temp array
  def findKLargest1(a: Array[Int], k: Int): Array[Int] = {
    val res = Array.ofDim[Int](k)

    for (i <- 0 until k)
      res(i) = a(i)

    var mi = findMinIndex(res)
    for (i <- k until a.length) {
      if (res(mi) < a(i)) {
        res(mi) = a(i)
        mi = findMinIndex(res)
      }
    }

    res
  }

  private def findMinIndex(a: Array[Int]): Int = {
    var min = 0
    for (i <- 1 until a.length)
      if (a(min) > a(i)) min = i
    min
  }

  // Using max heap
  def findKLargest2(a: Array[Int], k: Int): Array[Int] = {
    val res = Array.ofDim[Int](k)

    val mh = MaxHeap(a)
    for (i <- 0 until k) res(i) = mh.deleteMax()
    res
  }
}