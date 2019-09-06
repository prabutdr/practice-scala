package com.wintech.study.bp.basicio

import scala.io.StdIn

object Duration extends App {
  val tc = StdIn.readInt()
  
  for (t <- 1 to tc) {
    val Array(sh, sm, eh, em) = StdIn.readLine().split("\\s+").map(_.toInt)
    var dh = eh - sh - 1
    var dm = 0
    if (dh >= 0) {
      dm = 60 - sm + em
      if (dm >= 60) {
        dh += 1
        dm %= 60
      }
    }
    else { 
      dh = 0
      dm = em - sm
    }
    println(s"$dh $dm")
  }
}