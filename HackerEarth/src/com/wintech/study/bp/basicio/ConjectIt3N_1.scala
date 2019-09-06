

package com.wintech.study.bp.basicio

import scala.io.StdIn

object ConjectIt3N_1 extends App {
  val tc = StdIn.readInt()
  //  val cache = scala.collection.mutable.Map[BigInt, Boolean]()

  for (t <- 1 to tc) {
    println("YES")
    //    var n = BigInt(StdIn.readLine())
    //
    //    while (n != 1 && n % 2 != 0 && !cache.contains(n)) {
    //      cache += n -> false
    //      n = (3 * n + 1)
    //    }
    //
    //    if (n == 1 || n % 2 == 0 || cache(n)) {
    //      println("YES")
    //
    //      // Mark paths are reachable
    //      for ((num, status) <- cache if status == false)
    //        cache += (num -> true)
    //    } else {
    //      println("NO")
    //    }
  }
}

/**
 * You are given a number N. You can perform the following operations on N any number of times:
 *
 * > If N is even, divide N by 2.
 *
 * > If N is odd, replace N with 3N+1.
 *
 *
 *
 * Your task is to find out, for a given N, if it is possible to reach the number 1 after performing the above two valid operations on N any number of times.
 *
 *
 *
 * INPUT:
 *
 * First-line contains T denoting the number of test cases.
 * Next T lines contain just one integer, N.
 *
 *
 * OUTPUT:
 *
 * Print "YES" (without the quotes) if it is possible to reach 1 for the given N. Else print "NO"(without quotes).
 *
 *
 *
 * Constraints:
 *
 * 1<= T <=100
 *
 * 2<= N <= 10^100,000
 *
 *
 *
 * SAMPLE INPUT
 * 1
 * 21
 * SAMPLE OUTPUT
 * YES
 * Explanation
 * The steps are:
 *
 * 21 --> 64 --> 32 --> 16 --> 8 --> 4 --> 2 --> 1.
 *
 */
