package com.pj2r.dsame.stack

import org.scalatest.FunSuite
import org.scalatest.BeforeAndAfter
import org.junit.runner.RunWith
import org.scalatest.junit.JUnitRunner
import org.scalactic.source.Position.apply

@RunWith(classOf[JUnitRunner])
class P10_IsPalindromeTests extends FunSuite with BeforeAndAfter {
  //  test("Test") {
  //    assert(1 == 1)
  //  }
  //
  //  val input = List((1, 1), (4, 2), (9, 3))
  //
  //  input.foreach { i =>
  //    test(s"Test of math.sqrt(${i._1})") {
  //      assert(math.sqrt(i._1) === i._2)
  //    }
  //  }

  //  val validInputs = Table("aXa", "X", "abcXcba", "HelXllo")
  //  forAll(validInputs) { input =>
  //    assertResult(true)(P10_IsPalindrome.isPalindrome(input))
  //  }
  //
  val validInputs = List("aXa", "X", "abcXcba")
  validInputs.foreach { input =>
    test(s"$input is a palindrome") {
      assertResult(true)(P10_IsPalindrome.isPalindrome(input))
    }
  }

  val invalidInputs = List("HelXllo")
  invalidInputs.foreach { input =>
    test(s"$input is not a palindrome") {
      assertResult(false)(P10_IsPalindrome.isPalindrome(input))
    }
  }
}