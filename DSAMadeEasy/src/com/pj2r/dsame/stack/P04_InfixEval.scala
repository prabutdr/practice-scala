package com.pj2r.dsame.stack

object InfixEval extends App {
  val priorty = Map('(' -> 3, ')' -> 3, '*' -> 2, '/' -> 2, '+' -> 1, '-' -> 1)

  def evaluate(infixExpr: String): Int = {
    var operators = List[Char]()
    var operands = List[Int]()
    for (ch <- infixExpr) {
      if (!priorty.contains(ch)) {
        operands = (ch - 48) :: operands
      } else if (ch == ')') {
        while (operators.head != '(') {
          operands = eval(operators.head, operands.tail.head, operands.head) :: operands.drop(2)
          operators = operators.tail
        }
        operators = operators.tail
      } else {
        while (operators != Nil && operators.head != '(' && priorty(operators.head) >= priorty(ch)) {
          operands = eval(operators.head, operands.tail.head, operands.head) :: operands.drop(2)
          operators = operators.tail
        }
        operators = ch :: operators
      }
    }

    while (operators != Nil) {
      operands = eval(operators.head, operands.tail.head, operands.head) :: operands.drop(2)
      operators = operators.tail
    }

    operands.head
  }

  def eval(op: Char, a: Int, b: Int) = op match {
    case '+' => a + b
    case '-' => a - b
    case '*' => a * b
    case '/' => a / b
  }

  // TEST
  val inputs = List("1+2*3-5", "2-3/2", "1+2*(3-5)")
  for (input <- inputs) {
    println(s"$input = ${evaluate(input)}")
  }
}