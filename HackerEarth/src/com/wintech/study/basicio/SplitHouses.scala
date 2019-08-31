package com.wintech.study.basicio

import scala.io.StdIn
import scala.util.control.Breaks.break
import scala.util.control.Breaks.breakable

object SplitHouses extends App {
  val size = StdIn.readInt()
  val grid = StdIn.readLine()
  var isPossible = true

  breakable {
    for (i <- 1 until size) {
      if (grid(i) == grid(i - 1) && grid(i) == 'H') {
        isPossible = false
        break
      }
    }
  }
  
  if (isPossible) {
    println("YES")
    grid.foreach(x => print(if (x == '.') 'B' else 'H'))
    println
  } else {
    println("NO")
  }
}