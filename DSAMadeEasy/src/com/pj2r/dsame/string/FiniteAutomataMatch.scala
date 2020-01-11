package com.pj2r.dsame.string

import java.util.Arrays

object FiniteAutomataMatch extends App {
  def find(text: String, pattern: String): Unit = {
    val tt = formTrasitionTable(pattern)
    var len = 0
    for (i <- 0 until text.length) {
      len = tt(len)(text(i))
      if (len == pattern.length) {
        println("Match found at - " + (i - pattern.length() + 1))
      }
    }
  }

  def formTrasitionTable(pattern: String): Array[Array[Int]] = {
    val m = pattern.length() + 1;
    val tt = Array.fill[Int](m, 256)(0)
    tt(0)(pattern(0)) = 1
    var track = 0

    for (i <- 1 until m - 1; val ch = pattern(i)) {
      for (j <- 0 until tt(track).length) {
        tt(i)(j) = tt(track)(j)
      }
      tt(i)(ch) = i + 1
      track = tt(track)(ch)
    }
    tt(pattern.length)(pattern(0)) = 1

    tt
  }

  // Reference - https://github.com/rafiulgits/Algorithm-Lab/wiki/String-pattern-matching-with-transition-table-(finite-automata)
  formTrasitionTable("ababaca").map(s => println(s.mkString("[", ", ", "]\\n")))
  find("ababacababaca", "ababac")
}