package com.pj2r.dsame.queue

import scala.collection.mutable.Queue
import scala.collection.mutable.Stack

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