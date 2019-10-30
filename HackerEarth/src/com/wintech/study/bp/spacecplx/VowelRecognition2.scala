package com.wintech.study.bp.spacecplx

import scala.io.StdIn

object VowelRecognition2 extends App {
  val t = StdIn.readLine().toInt

  for (i <- 1 to t) {
    val s = StdIn.readLine()
    val chCounts = Array.ofDim[Long](s.length())
    //    println(s.length())

    chCounts(0) = s.length
    for (idx <- 1 to s.length() - 1) {
      chCounts(idx) = (s.length() - idx) + chCounts(idx - 1) - idx
    }

    var count: Long = 0
    for (idx <- 0 to s.length() - 1) {
      s(idx) match {
        case 'a' | 'e' | 'i' | 'o' | 'u' | 'A' | 'E' | 'I' | 'O' | 'U' => count = count + chCounts(idx)
        case _ =>
      }
    }
    println(count)
  }
}