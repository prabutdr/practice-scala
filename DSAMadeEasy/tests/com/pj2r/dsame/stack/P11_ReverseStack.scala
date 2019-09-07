package com.pj2r.dsame.stack

import scala.collection.mutable.Stack
import org.scalatest.FunSuite
import org.scalatest.BeforeAndAfter
import org.junit.runner.RunWith
import org.scalatest.junit.JUnitRunner

@RunWith(classOf[JUnitRunner])
class P11_ReverseStackTest extends FunSuite with BeforeAndAfter {
  val stacks: List[Stack[Int]] = List(Stack(1, 2, 3, 4), Stack(1, 1, 2, 2), Stack(1), Stack())
  stacks.foreach(stack => {
    test(s"$stack reverse") {
      assertResult(stack.reverse) {
        P11_ReverseStack.reverse(stack)
        stack
      }
    }
  })
}