package com.wintech.study.bp.spacecplx

import scala.io.StdIn

object VowelRecognition extends App {
  val t = StdIn.readLine().toInt

  for (i <- 1 to t) {
    val s = StdIn.readLine()
    var count = 0
    for (li <- 0 to s.length() - 1) {
      for (ri <- li to s.length() - 1) {
        for (idx <- li to ri) {
          s(idx) match {
            case 'a' | 'e' | 'i' | 'o' | 'u' | 'A' | 'E' | 'I' | 'O' | 'U' => count = count + 1
            case _ =>
          }
        }
      }
    }
    println(count)
  }
}