package com.pj2r.dsame.stack

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