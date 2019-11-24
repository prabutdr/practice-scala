package com.pj2r.dsame.heap

import java.util.Queue
import java.util.ArrayDeque

object P28_MaxInSlidingWindow extends App {
  def maxInSlidingWindow(a: Array[Int], k: Int): Array[Int] = {
    val res = Array.ofDim[Int](a.length - k + 1)
    val dq = new ArrayDeque[Int]()

    for (i <- 0 until a.length) {
      // Remove element which is not in sliding window
      while (!dq.isEmpty() && dq.getFirst <= i - k)
        dq.removeFirst()

      while (!dq.isEmpty() && a(dq.getLast) < a(i))
        dq.removeLast()

      dq.addLast(i)
      //      println(i + ": " + dq + ": " + dq.getFirst)
      if (i - k + 1 >= 0)
        res(i - k + 1) = a(dq.getFirst)
    }

    res
  }

  // TEST
  println(maxInSlidingWindow(Array(1, 3, -1, -3, 5, 3, 6, 7), 1).mkString(", "))
  println(maxInSlidingWindow(Array(1, 3, -1, -3, 5, 3, 6, 7), 2).mkString(", "))
  println(maxInSlidingWindow(Array(1, 3, -1, -3, 5, 3, 6, 7), 3).mkString(", "))
  println(maxInSlidingWindow(Array(1, 3, -1, -3, 5, 3, 6, 7), 4).mkString(", "))
  println(maxInSlidingWindow(Array(1, 3, -1, -3, 5, 3, 6, 7), 5).mkString(", "))
}