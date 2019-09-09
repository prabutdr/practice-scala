package com.pj2r.dsame.stack

/**
 * Given a string containing n S’s and n X’s where 5 indicates a push operation and
 * X indicates a pop operation, and with the stack initially empty, formulate a rule to check
 * whether a given string 5 of operations is admissible or not?
 */
object P20_StackPossibleOperation extends App {
  def isPossible(ops: String): Boolean = {
    var ss = 0
    for (op <- ops) {
      if (op == 'S')
        ss += 1
      else if (op == 'X' && ss > 0)
        ss -= 1
      else
        return false
    }
    return true
  }
}