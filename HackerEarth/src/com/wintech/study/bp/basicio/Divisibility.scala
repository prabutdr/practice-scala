package com.wintech.study.bp.basicio

import java.util.Scanner

object Divisibility extends App {
  val in = new Scanner(System.in)
  in.nextLine()

  if (in.nextLine().takeRight(1).equals("0"))
    println("Yes")
  else
    println("No")
}

/**
 * You are provided an array  of size  that contains non-negative integers. Your task is to determine whether the number that is formed by selecting the last digit of all the N numbers is divisible by .
 *
 * Note: View the sample explanation section for more clarification.
 *
 * Input format
 *
 * First line: A single integer  denoting the size of array
 * Second line:  space-separated integers.
 * Output format
 *
 * If the number is divisible by , then print . Otherwise, print .
 */
