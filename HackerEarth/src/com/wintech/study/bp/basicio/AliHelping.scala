package com.wintech.study.bp.basicio

import scala.io.StdIn

object AliHelping extends App {
  val pattern = """(\d)(\d)(.)(\d)(\d)(\d)\-(\d)(\d)""".r
  val pattern(d1, d2, ch, d3, d4, d5, d6, d7) = StdIn.readLine()
  val vowels = Set("A", "E", "I", "O", "U", "Y")

  if (!vowels.contains(ch) 
      && (d1.toInt + d2.toInt) % 2 == 0 
      && (d3.toInt + d4.toInt) % 2 == 0 
      && (d4.toInt + d5.toInt) % 2 == 0 
      && (d6.toInt + d7.toInt) % 2 == 0) {
    println("valid")
  } else {
    println("invalid")
  }
}