package com.pj2r.dsame.stack

import scala.collection.mutable.Stack

/**
 * For Problem-5 is it possible to improve the space complexity?
 * Yes, We still have the min stack, but
 * we only pop from it when the value we pop from the main stack is equal to the one on the min
 * stack. We only push to the min stack when the value being pushed onto the main stack is less than
 * or equal to the current min value. In this modified algorithm also, if we want to get the minimum
 * then we just need to return the top element from the min stack.
 */
object P06_StackMinimum extends App {
  val mainStack = Stack[Int]()
  val minStack = Stack[Int]()

  def push(a: Int) = {
    if (minStack == Nil || minStack.head >= a)
      minStack.push(a)
    mainStack.push(a)
  }

  def pop(): Int = {
    if (mainStack.head == minStack.head)
      minStack.pop()
    mainStack.pop()
  }

  def getMinimum(): Int = {
    minStack.head
  }

  // TEST
  push(2);
  push(6);
  push(4);
  push(1);
  push(5);
  push(1);
  while (mainStack != Nil) {
    println(s"$mainStack stack minimum is ${getMinimum()} ==> $minStack")
    pop()
  }
}