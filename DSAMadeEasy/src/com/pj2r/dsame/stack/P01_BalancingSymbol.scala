package com.pj2r.dsame.stack

import scala.collection.immutable.Stack
import scala.collection.immutable.List

object P01_BalancingSymbol extends App {
  val symbolMap = Map(')' -> '(', ']' -> '[', '}' -> '{')
  val openSymbols = symbolMap.values.toSet

  def isSymbolBalance(expr: String): Boolean = {
    var stack = List[Char]()
    for (ch <- expr) {
      if (symbolMap.contains(ch)) {
        if (stack == Nil || stack.head != symbolMap(ch)) {
          // No matching open symbol available
          return false
        } else {
          // Remove matching symbol from the stack
          stack = stack.tail
        }
      } else if (openSymbols.contains(ch)) {
        // Add open symbols to stack
        stack = ch :: stack
      }
      // Just ignore other characters
    }

    return stack == Nil
  }

  // TEST
  val exprs = List("(A+B)+(C-D)", "((A+B)+(C-D)", "((A+B)+[C-D])", "((A+B)+(C-D)]}", "((A+B)+[C-D]}")
  for (expr <- exprs) {
    println(s"$expr is valid - ${isSymbolBalance(expr)}")
  }
}