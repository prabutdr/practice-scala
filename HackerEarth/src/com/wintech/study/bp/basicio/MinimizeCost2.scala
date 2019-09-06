package com.wintech.study.bp.basicio

import java.util.Scanner
import scala.util.control.Breaks.break
import scala.util.control.Breaks.breakable
import scala.io.StdIn
import scala.util.control.Breaks

object MinimizeCost2 extends App {
  val in = new Scanner(System.in)
  //  val Array(n, k) = StdIn.readLine().split(" ").map(_.toInt).toArray // in.nextInt()
  val n = in.nextInt()
  val k = in.nextInt()
  val a = Array.ofDim[Int](n)
  //  val a = StdIn.readLine().split(" ").map(_.toLong) //Array.ofDim[Long](n)

  for (i <- 0 until n) {
    a(i) = in.nextInt()
  }

  var (si, ei) = (0, 0)
  for (i <- 0 until n if a(i) < 0) {
    //    println(i + ": " + a.mkString(" "))
    si = max(max(0, i - k), si)
    ei = min(i + k, a.length - 1)

    while (si <= ei && a(i) < 0) {
      if (a(si) > 0) {
        val m = min(a(si), -a(i))
        a(i) += m
        a(si) -= m
      } else {
        si += 1
      }
    }
  }

  var sum: Long = 0
  for (aa <- a) {
    if (aa < 0) sum -= aa else sum += aa
  }
  println(sum)

  def min(a: Int, b: Int) = if (a > b) b else a
  def max(a: Int, b: Int) = if (a > b) a else b
}