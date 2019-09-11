package com.pj2r.dsame.queue

import scala.collection.mutable.Stack

object P09_StackPairwiseOrder extends App {
  def checkStackPairwiseOrder(stack: Stack[Int]): Boolean = {
    val ts = Stack[Int]()
    var count = 0
    while (!stack.isEmpty) {
      ts.push(stack.pop())
      count += 1
    }

    if (count % 2 == 1)
      stack.push(ts.pop())

    var isPairwiseOrdered = true
    while (!ts.isEmpty) {
      val (a, b) = (ts.pop(), ts.pop())
      stack.push(a).push(b)
      if (math.abs(a - b) != 1)
        isPairwiseOrdered = false
    }

    return isPairwiseOrdered
  }
}