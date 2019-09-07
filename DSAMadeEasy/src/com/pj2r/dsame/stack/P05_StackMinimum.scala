package com.pj2r.dsame.stack

import scala.collection.mutable.Stack

/**
 * How to design a stack such that GetMinimum( ) should be O(1)?
 *
 * Solution: Take an auxiliary stack that maintains the minimum of all values in the stack. Also,
 * assume that each element of the stack is less than its below elements. For simplicity let us call the
 * auxiliary stack min stack.
 */
object P05_StackMinimum extends App {
  val mainStack = Stack[Int]()
  val minStack = Stack[Int]()

  def push(a: Int) = {
    if (minStack == Nil || minStack.head >= a)
      minStack.push(a)
    else
      minStack.push(minStack.top)
    mainStack.push(a)
  }

  def pop(): Int = {
    minStack.pop()
    mainStack.pop()
  }

  def getMinimum(): Int = {
    minStack.head
  }

  // TEST
  push(2);
  push(6);
  push(6);
  push(1);
  push(5);
  while (mainStack != Nil) {
    println(s"$mainStack stack minimum is ${getMinimum()} ==> $minStack")
    pop()
  }
}