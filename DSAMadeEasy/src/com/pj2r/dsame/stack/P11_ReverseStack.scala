package com.pj2r.dsame.stack

import scala.collection.mutable.Stack

/**
 * Given a stack, how to reverse the elements of the stack using only stack
 * operations (push & pop)?
 */
object P11_ReverseStack extends App {
  def reverse(stack: Stack[Int]): Unit = {
    if (stack.isEmpty)
      return
    val data = stack.pop()
    reverse(stack)
    insertAtBottom(stack, data)
  }

  def insertAtBottom(stack: Stack[Int], data: Int): Unit = {
    if (stack.isEmpty) {
      stack.push(data)
      return
    }
    val temp = stack.pop()
    insertAtBottom(stack, data);
    stack.push(temp)
  }
}