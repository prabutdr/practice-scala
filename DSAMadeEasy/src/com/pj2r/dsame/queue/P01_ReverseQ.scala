package com.pj2r.dsame.queue

import scala.collection.mutable.Queue
import scala.collection.mutable.Stack

/**
 * Give an algorithm for reversing a queue Q. To access the queue, we are only
 * allowed to use the methods of queue ADT.
 */
object P01_ReverseQ extends App {
  def reverseQ(inQ: Queue[Int]): Queue[Int] = {
    val stack = Stack[Int]()
    while (!inQ.isEmpty) {
      stack.push(inQ.dequeue())
    }
    while (!stack.isEmpty) {
      inQ.enqueue(stack.pop())
    }
    inQ
  }
}