package com.wintech.study.bp.basicio

import scala.io.StdIn

object LiftQueries extends App {
  val tc = StdIn.readInt()
  
  var (a, b) = (0, 7)  // Lift a at ground floor, Lift b at top floor initially
  for (t <- 1 to tc) {
    val rf = StdIn.readInt()
    val aDist = (a - rf).abs
    val bDist = (b - rf).abs
    if (aDist <= bDist) {
      println("A")
      a = rf
    }
    else {
      println("B")
      b = rf
    }
  }
}