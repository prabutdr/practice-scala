package com.wintech.study.bp.spacecplx

import scala.io.StdIn
import java.util.Scanner
import scala.math.BigInt

object APlusB extends App {
  val in = new Scanner(System.in)
  while (in.hasNext()) {
    println(BigInt(in.next()) + BigInt(in.next()))
  }
}

/**
 * Problem Description
 *
 * Given a series of integer pairs  and , output the sum of  and .
 *
 * Input Format
 *
 * Each line contains two integers,  and . One input file may contain several pairs  where .
 *
 * Output Format
 *
 * Output a single integer per line - The sum of  and .
 *
 * Constraints
 *
 * SAMPLE INPUT
 * 1 2
 * 2 5
 * 10 14
 * SAMPLE OUTPUT
 * 3
 * 7
 * 24
 *
 */
