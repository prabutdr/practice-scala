package com.pj2r.techgig.algo

import scala.io.StdIn

object CountOf1s extends App {
  val n = StdIn.readInt()
  var count = 0
  while (count < n && StdIn.readInt() == 1) count += 1
  print(count)
}