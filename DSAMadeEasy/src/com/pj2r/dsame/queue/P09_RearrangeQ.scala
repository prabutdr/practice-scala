package com.pj2r.dsame.queue

import scala.collection.mutable.Queue

object P09_RearrangeQ extends App {
  def rearrangeQ(q: Queue[Int]): Queue[Int] = {
    if (q.size % 2 == 1) throw new IllegalArgumentException

    val tq = Queue[Int]()
    val d = q.size / 2

    for (i <- 1 to d)
      tq.enqueue(q.dequeue())

    for (i <- 1 to d) {
      q.enqueue(tq.dequeue())
      q.enqueue(q.dequeue())
    }

    q
  }
}