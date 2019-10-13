package com.pj2r.techgig.algo

import scala.io.StdIn

object PetrCalendar extends App {
  val days = Array(31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31)
  val m = StdIn.readInt()
  val d = StdIn.readInt()

  println(math.ceil((days(m - 1) - (7 - d + 1)) / 7.0).toInt + 1)

  //  println((days(m - 1) - d + 1) / 7)
  //  println((days(m - 1) - d + 1))
  //  println((days(m - 1) - d + 1))
  //  print(math.ceil((days(m - 1) + d - 1) / 7).toInt + 1)
}