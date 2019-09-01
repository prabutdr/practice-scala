package com.wintech.study.basicio

import scala.io.StdIn

object BookISBN extends App {
  val isbn = StdIn.readLine();

  if (isbn.length != 10) {
    println("Illegal ISBN")
  } else {
    var sum = 0
    for ((ch, idx) <- isbn zip (1 to isbn.length)) {
      sum += ((ch - 48).toInt * idx)
    }

    if (sum % 11 == 0)
      println("Legal ISBN")
    else
      println("Illegal ISBN")
  }
}

/**
 * Harry wants to find Voldemort's potion making book but he is confused about how to get it.
 *
 * The book has a special ISBN(International Standard Book Number) which is  unique numeric book identifier only for Voldemort's book printed on it. The ISBN is based upon a 10-digit code. The ISBN is valid if:
 * 1xdigit1 + 2xdigit2 + 3xdigit3 + 4xdigit4 + 5xdigit5 + 6xdigit6 + 7xdigit7 + 8xdigit8 + 9xdigit9 + 10xdigit10 is divisible by 11.
 * Help Harry to find the book!
 * Input:
 * Input the ISBN code as a 10-digit integer.
 *
 * Output:
 * If the ISBN is not a 10-digit integer, output the message “Illegal ISBN” and terminate the program.
 * If the number is 10-digit, extract the digits of the number and compute the sum as explained in the explanation.
 * If the sum is divisible by 11, output the message, “Legal ISBN”. If the sum is not divisible by 11, output the message, “Illegal ISBN”.
 *
 * SAMPLE INPUT
 * 1401601499
 * SAMPLE OUTPUT
 * Legal ISBN
 * Explanation
 * For an ISBN 1401601499
 * Sum=1×1 + 2×4 + 3×0 + 4×1 + 5×6 + 6×0 + 7×1 + 8×4 + 9×9 + 10×9 = 253 which is divisible by 11.
 *
 */
