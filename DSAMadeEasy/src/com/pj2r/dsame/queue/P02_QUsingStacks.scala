package com.pj2r.dsame.queue

import java.util.Stack

/**
 * How can you implement a queue using two stacks?
 */
object P02_QUsingStacks extends App {
  val st1 = new Stack[Int]
  val st2 = new Stack[Int]

  def enqueue(e: Int): Int = {
    st1.push(e);
  }

  def dequeue(): Int = {
    if (st2.isEmpty()) {
      while (!st1.isEmpty()) {
        st2.push(st1.pop())
      }
    }

    if (st2.isEmpty()) {
      throw new IllegalStateException
    } else {
      st2.pop()
    }
  }

  // TEST
  enqueue(1)
  enqueue(2)
  enqueue(3)
  println(dequeue())
  println(dequeue())
  println(dequeue())
  enqueue(5)
  println(dequeue())
  //  println(dequeue())

}