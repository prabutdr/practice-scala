package com.pj2r.dsame.stack

import scala.collection.mutable.Stack

object P27_RemoveAdjDuplicates extends App {
  def removeAdjDuplicates(text: String): String = {
    val stack = Stack[Char]()
    for (ch <- text) {
      var isDuplicate = false
      while (!stack.isEmpty && ch == stack.top) {
        stack.pop()
        isDuplicate = true
      }
      if (!isDuplicate) stack.push(ch)
    }
    stack.reverse.mkString
  }
}