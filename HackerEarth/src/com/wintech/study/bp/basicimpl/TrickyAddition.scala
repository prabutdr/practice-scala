package com.wintech.study.bp.basicimpl

import scala.io.StdIn

object TrickyAddition extends App {
  val t = StdIn.readLine().toInt

  for (i <- 1 to t) {
    val s1 = StdIn.readLine()
    val s2 = StdIn.readLine()
    var carry = -1
    val sb = new StringBuilder

    def splitAndCarry(sum: Int) {
      if (sum >= 10) {
        sb.append(sum / 10)
        carry = sum % 10
      } else {
        sb.append(sum)
        carry = -1
      }
    }

    val minLength = Math.min(s1.length(), s2.length())
    for (i <- 0 to minLength - 1) {
      val sum = (s1(i) - 48) + (s2(i) - 48) + (if (carry == -1) 0 else carry)
      splitAndCarry(sum)
    }
    val bs = if (s1.length() > s2.length()) s1 else s2

    for (i <- minLength to bs.length() - 1) {
      val sum = (bs(i) - 48) + (if (carry == -1) 0 else carry)
      splitAndCarry(sum)
    }

    if (carry != -1) sb.append(carry)
    println(sb.toString())
  }
}