

package com.wintech.study.bp.basicio

import scala.io.StdIn

object SevenSegmentDisp2 extends App {
  val stickMap = Array(6, 2, 5, 5, 4, 5, 6, 3, 7, 6)

  val tc = StdIn.readInt()
  for (t <- 1 to tc) {
    val sticks = StdIn.readLine().map(_.toInt - 48).map(stickMap(_)).sum
    println((if (sticks % 2 != 0) "7" else "") + ("1" * ((sticks - (3 * (sticks % 2))) / 2)))
  }
}

/**
 * You all must have seen a seven segment display.If not here it is:
 *
 *
 *
 * Alice got a number written in seven segment format where each segment was creatted used a matchstick.
 *
 * Example: If Alice gets a number 123 so basically Alice used 12 matchsticks for this number.
 *
 * Alice is wondering what is the numerically largest value that she can generate by using at most the matchsticks that she currently possess.Help Alice out by telling her that number.
 *
 *
 *
 * Input Format:
 *
 * First line contains T (test cases).
 *
 * Next T lines contain a Number N.
 *
 * Output Format:
 *
 * Print the largest possible number numerically that can be generated using at max that many number of matchsticks which was used to generate N.
 *
 * Constraints:
 *
 *
 *
 * SAMPLE INPUT
 * 2
 * 1
 * 0
 * SAMPLE OUTPUT
 * 1
 * 111
 * Explanation
 * If you have 1 as your number that means you have 2 match sticks.You can generate 1 using this.
 *
 * If you have 0 as your number that means you have 6 match sticks.You can generate 111 using this.
 */
