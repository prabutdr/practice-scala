package com.wintech.study.bp.basicio

import scala.io.StdIn

object FriendsRelationship extends App {
  val tc = StdIn.readInt()
  
  for (t <- 1 to tc) {
    val n = StdIn.readInt()
    
    for (i <- 1 to n) {
      println(("*" * i) + ("#" * (2 * (n - i))) + ("*" * i)) 
    }
    println
  }
}