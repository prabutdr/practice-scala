package com.wintech.study.bp.spacecplx

import scala.io.StdIn

object VowelRecognition3 extends App {
  val t = StdIn.readLine().toInt

  for (i <- 1 to t) {
    val s = StdIn.readLine()

    var count: Long = 0
    for (idx <- 0 to s.length() - 1) {
      s(idx) match {
        case 'a' | 'e' | 'i' | 'o' | 'u' | 'A' | 'E' | 'I' | 'O' | 'U' => count = count + ((s.length() - idx).toLong * (idx + 1))
        case _ =>
      }
    }
    println(count)
  }
}