package com.pj2r.dsame.stack

object P03_PostfixEval extends App {

  def evaluate(postfixExpr: String): Int = {
    var stack = List[Int]()
    for (ch <- postfixExpr) {
      ch match {
        case '+' => stack = (stack.drop(1).head + stack.head) :: stack.drop(2)
        case '-' => stack = (stack.drop(1).head - stack.head) :: stack.drop(2)
        case '*' => stack = (stack.drop(1).head * stack.head) :: stack.drop(2)
        case '/' => stack = (stack.drop(1).head / stack.head) :: stack.drop(2)
        case _   => stack = (ch - 48) :: stack
      }
    }
    stack.head
  }

  // TEST
  val inputs = List("123*+5-", "232/-")
  for (input <- inputs) {
    println(s"$input = ${evaluate(input)}")
  }
}