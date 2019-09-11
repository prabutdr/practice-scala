package com.pj2r.dsame.queue

import scala.collection.mutable.Queue

/**
 * how you can efficiently implement one stack using two queues
 */
object P03_StackUsingQs extends App {
  val q1 = Queue[Int]()
  val q2 = Queue[Int]()

  def push(e: Int): Unit = {
    if (q1.isEmpty)
      q2.enqueue(e)
    else
      q1.enqueue(e)
  }

  def pop(): Int = {
    if (q1.isEmpty && q2.isEmpty)
      throw new IllegalStateException

    if (q1.isEmpty)
      transferExceptLast(q2, q1)
    else
      transferExceptLast(q1, q2)
  }

  def transferExceptLast(sq: Queue[Int], tq: Queue[Int]): Int = {
    for (i <- 1 until sq.size) {
      tq.enqueue(sq.dequeue())
    }
    sq.dequeue()
  }

  // TEST
  push(1)
  push(2)
  push(3)
  println(pop())
  println(pop())
  println(pop())
  push(1)
  println(pop())
  //  println(pop())  // Exception

}