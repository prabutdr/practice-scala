package com.pj2r.dsame.string

import java.util.Arrays
import scala.collection.mutable.MutableList
import scala.collection.mutable.Map

object BoyceMooreMatch extends App {
  def find(text: String, pattern: String): Unit = {
    val mt = formMatchTable(pattern)
    val pl = pattern.length()
    //      var j = pl - 1;
    var i = pl - 1

    while (i < text.length) {
      var j = pl - 1;
      var k = i;
      while (j >= 0 && text(k) == text(j)) {
        j -= 1
        k -= 1
      }
      if (j == -1) {
        println("Match found at - " + (i - pl + 1))
        i += 1
      }

      val moveLength = mt.getOrElse(text(i), pl)
      i += moveLength
    }
  }

  def formMatchTable(pattern: String): Map[Char, Int] = {
    val mt = Map[Char, Int]()
    val pl = pattern.length()

    for (i <- 0 until pl) {
      mt += (pattern(i) -> (pl - i - 1))
      //      println(i + ": " + mt)
    }
    mt += (pattern(pl - 1) -> pl)

    mt
  }

  // TEST
  println(formMatchTable("TEAMMAST"))
  find("ababacababaca", "ababac")
}