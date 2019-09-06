package com.wintech.study.bp.basicio

import scala.io.StdIn

object CharSum extends App {
  println(StdIn.readLine().map(_.toInt - 96).sum)
}