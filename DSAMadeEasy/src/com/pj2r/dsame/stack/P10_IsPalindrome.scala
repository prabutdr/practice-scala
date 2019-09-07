package com.pj2r.dsame.stack

import scala.collection.mutable.Stack

/**
 * Using Stack
 *
 * Given an array of characters formed with a’s and b’s. The string is marked with
 * special character X which represents the middle of the list (for example:
 * ababa...ababXbabab baaa). Check whether the string is palindrome.
 */
object P10_IsPalindrome extends App {
  def isPalindrome(text: String): Boolean = {
    val stack = Stack[Char]()
    val xIdx = text.indexOf('X')
    for (ch <- text.substring(0, xIdx))
      stack.push(ch)
    for (ch <- text.substring(xIdx + 1)) {
      if (ch != stack.pop())
        return false
    }
    return true
  }

  // TEST
  val inputs = List("aXa", "X", "abcXcba", "HelXllo")
  for (input <- inputs) {
    println(s"$input is palindrome - ${isPalindrome(input)}")
  }
}