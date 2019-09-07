package com.pj2r.dsame.stack

object P02_InfixToPostfix extends App {
  val opPriority = Map('(' -> 3, ')' -> 3, '*' -> 2, '/' -> 2, '%' -> 2, '+' -> 1, '-' -> 1)

  def toPostfix(infixExp: String): String = {
    var sb = new StringBuilder
    var stack = List[Char]()
    for (ch <- infixExp) {
      if (!opPriority.contains(ch)) {
        sb.append(ch)
      } else if (ch == ')') {
        while (stack.head != '(') {
          sb.append(stack.head)
          stack = stack.tail
        }
        stack = stack.tail
      } else {
        while (stack != Nil && stack.head != '(' && opPriority(stack.head) >= opPriority(ch)) {
          sb.append(stack.head)
          stack = stack.tail
        }
        stack = ch :: stack
      }
    }
    while (stack != Nil) {
      sb.append(stack.head)
      stack = stack.tail
    }
    sb.toString()
  }

  // TEST
  val exprs = List("(A+B)+(C-D)", "A*B-(C+D)+E")
  for (expr <- exprs) {
    println(s"$expr to postfix - ${toPostfix(expr)}")
  }
}