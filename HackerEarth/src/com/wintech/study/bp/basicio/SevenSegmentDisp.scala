

package com.wintech.study.bp.basicio

import scala.io.StdIn

object SevenSegmentDisp extends App {
  val stickMap = Map('0' -> 6, '1' -> 2, '2' -> 5, '3' -> 5, '4' -> 4, '5' -> 5, '6' -> 6, '7' -> 3, '8' -> 7, '9' -> 6)

  val tc = StdIn.readInt()
  for (t <- 1 to tc) {
    val sticks = StdIn.readLine().map(stickMap(_)).sum
    println((if (sticks % 2 != 0) "7" else "") + ("1" * ((sticks - (3 * (sticks % 2))) / 2)))
  }
}