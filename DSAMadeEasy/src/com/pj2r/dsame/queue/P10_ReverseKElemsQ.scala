package com.pj2r.dsame.queue

import scala.collection.mutable.Queue
import scala.collection.mutable.Stack

/**
 * Given an integer k and a queue of integers, how do you reverse the order of the
 * first k elements of the queue, leaving the other elements in the same relative order? For
 * example, if k=4 and queue has the elements [10, 20, 30, 40, 50, 60, 70, 80, 90]; the output
 * should be [40, 30, 20, 10, 50, 60, 70, 80, 90].
 */
object P10_ReverseKElemsQ extends App {
  def reverseKElems(q: Queue[Int], k: Int): Queue[Int] = {
    if (q.size < k) throw new IllegalArgumentException

    val ts = Stack[Int]()
    for (i <- 1 to k) {
      ts.push(q.dequeue())
    }
    while (!ts.isEmpty) {
      q.enqueue(ts.pop())
    }
    for (i <- 1 to (q.size - k)) {
      q.enqueue(q.dequeue())
    }
    q
  }
}