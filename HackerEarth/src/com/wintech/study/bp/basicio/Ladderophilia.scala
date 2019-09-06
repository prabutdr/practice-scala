package com.wintech.study.bp.basicio

import scala.io.StdIn

object Ladderophilia extends App {
  val n = StdIn.readInt()

  for (i <- 1 to n) {
    println("*   *")
    println("*   *")
    println("*****")
  }
  println("*   *")
  println("*   *")
}

/*
Aditya is fond of ladders. Everyday he goes through pictures of ladders online but unfortunately today he ran out of ladder pictures online. Write a program to print “ladder with N steps”, which he can use to get his daily dose of ladder love.

INPUT:
Input contains integer N, the number of steps in the ladder

OUTPUT:

Print the ladder with the gap between two side rails being 3 spaces(“   “).

Check the sample output for format of printing the ladder.

CONSTRAINTS:

1<=N<=40

SAMPLE INPUT
4
SAMPLE OUTPUT
*   *
*   *
*****
*   *
*   *
*****
*   *
*   *
*****
*   *
*   *
*****
*   *
*   *

*/ 