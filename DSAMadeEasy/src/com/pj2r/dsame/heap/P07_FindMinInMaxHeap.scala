package com.pj2r.dsame.heap

object P07_FindMinInMaxHeap extends App {
  def findMin(mh: MaxHeap): Int = {
    if (mh == null || mh.count < 1) throw new IllegalArgumentException
    if (mh.count == 1) return mh(0)

    var min = Integer.MAX_VALUE
    for (i <- (mh.count + 1) / 2 to mh.count - 1) {
      if (min > mh(i))
        min = mh(i)
    }
    return min
  }

  // TEST
  val mh = MaxHeap(1, 2, 3, 4, 5, 6, 7)

}