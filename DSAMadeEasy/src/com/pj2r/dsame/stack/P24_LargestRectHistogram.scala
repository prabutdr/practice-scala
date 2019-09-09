package com.pj2r.dsame.stack

object P24_LargestRectHistogram extends App {
  def findLargestRect(histogram: Array[Int]): Int = {
    var maxArea = -1
    var stack = List[Int]()
    var i = 0
    while (i < histogram.length) {
      if (stack == Nil || histogram(stack.head) <= histogram(i)) {
        // maintain higher indexes in the stack
        stack = i :: stack
        i += 1
      } else {
        // Finish of the lower boundaries
        val top = stack.head
        stack = stack.tail
        maxArea = maxArea max (histogram(top) * (if (stack == Nil) i else i - stack.head - 1))
      }
    }

    while (stack != Nil) {
      val top = stack.head
      stack = stack.tail
      maxArea = maxArea max (histogram(top) * (if (stack == Nil) i else i - stack.head - 1))
    }
    maxArea
  }
}