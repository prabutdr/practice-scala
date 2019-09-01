package com.wintech.study.basicio

import scala.io.StdIn

object CharSum extends App {
  println(StdIn.readLine().map(_.toInt - 96).sum)
}