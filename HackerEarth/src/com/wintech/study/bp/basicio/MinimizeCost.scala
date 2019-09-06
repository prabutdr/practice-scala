package com.wintech.study.bp.basicio

import java.util.Scanner
import scala.util.control.Breaks.break
import scala.util.control.Breaks.breakable
import scala.io.StdIn

object MinimizeCost extends App {
  //  val in = new Scanner(System.in)
  val Array(n, k) = StdIn.readLine().split(" ").map(_.toInt).toArray // in.nextInt()
  //  val k = in.nextInt()
  val a = StdIn.readLine().split(" ").map(_.toLong) //Array.ofDim[Long](n)

  //  for (i <- 0 until n) {
  //    a(i) = in.nextInt()
  //  }

  for (i <- 0 until n if a(i) < 0) {
    var j = 1
    println(i + ": " + a.mkString(" "))
    breakable {
      for (
        j <- k to 1 by -1;
        m = i - j if m >= 0 && a(m) > 0
      ) {
        adjust(a, i, m);
        println("R1 " + j + ": " + a.mkString(" "))
      }

      for (
        j <- k to 1 by -1;
        m = i + j if m < a.length && a(m) > 0
      ) {
        adjust(a, i, m);
        println("R2 " + j + ": " + a.mkString(" "))
      }
      println("R3 : " + a.mkString(" "))
    }
  }

  def adjust(a: Array[Long], i: Int, m: Int) {
    if (a(m) >= -a(i)) {
      a(m) = a(m) + a(i)
      a(i) = 0
      break
    } else {
      a(i) = a(m) + a(i)
      a(m) = 0
    }
  }

  println(a.map(_.abs).sum)
}