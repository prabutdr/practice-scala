package com.pj2r.dsame.stack

/**
 * Finding Spans: Given an array A, the span S[i] of A[i] is the maximum number
 * of consecutive elements A[j] immediately preceding A[i] and such that A[j] < A[i]?
 * Other way of asking: Given an array A of integers, find the maximum of j – i subjected to
 * the constraint of A[i] < A[j].
 */
object P22_FindingSpans extends App {
  def calculateSpan(input: Array[Int]): Array[Int] = {
    var span = Array.ofDim[Int](input.size)
    var idxStack = 0 :: Nil
    span(0) = 1
    for (idx <- 1 until input.size) {
      while (idxStack != Nil && input(idxStack.head) <= input(idx))
        idxStack = idxStack.tail

      span(idx) = if (idxStack == Nil) idx + 1 else idx - idxStack.head
      idxStack = idx :: idxStack
    }

    span
  }
}