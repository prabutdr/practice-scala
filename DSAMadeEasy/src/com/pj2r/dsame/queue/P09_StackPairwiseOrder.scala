package com.pj2r.dsame.queue

import scala.collection.mutable.Stack

/**
 * Given a stack of integers, how do you check whether each successive pair of
 * numbers in the stack is consecutive or not. The pairs can be increasing or decreasing, and
 * if the stack has an odd number of elements, the element at the top is left out of a pair. For
 * example, if the stack of elements are [4, 5, -2, -3, 11, 10, 5, 6, 20], then the output should
 * be true because each of the pairs (4, 5), (-2, -3), (11, 10), and (5, 6) consists of
 * consecutive numbers.
 */
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