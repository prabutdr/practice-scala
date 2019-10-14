package com.wintech.study.bp.basicio

import java.util.Scanner

object Divisible extends App {
  val in = new Scanner(System.in)
  val n = in.nextInt()
  val sb = new StringBuilder

  for (i <- 1 to n / 2) {
    val number = in.next()
    sb.append(number.head)
  }
  for (i <- 1 to n / 2) sb.append(in.nextInt() % 10)

  println(BigInt(sb.toString()))
  println(if (BigInt(sb.toString()) % 11 == 0) "OUI" else "NON")
}