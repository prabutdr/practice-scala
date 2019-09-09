package com.pj2r.dsame.stack

/**
 * Consider an empty stack of integers. Let the numbers 1,2,3,4,5,6 be pushed on to
 * this stack in the order they appear from left to right. Let 5 indicate a push and X indicate a
 * pop operation. Can they be permuted in to the order 325641(output) and order 154623?
 */
object P18_StackPossiblePerms extends App {
  def isPermPossible(values: String, text: String): (Boolean, String) = {
    var stack = List[Char]()
    val sb = new StringBuilder
    var idx = 0
    for (ch <- values) {
      if (stack == Nil || stack.head != text(idx)) {
        stack = ch :: stack
        sb.append('S')
      }

      while (stack != Nil && stack.head == text(idx)) {
        stack = stack.tail
        sb.append('X')
        idx += 1
      }
      //      println(ch + ": " + stack + ": " + sb.toString())
    }
    if (stack == Nil)
      (true, sb.toString())
    else
      (false, null)
  }
}