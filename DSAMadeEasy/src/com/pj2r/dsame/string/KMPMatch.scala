package com.pj2r.dsame.string

import java.util.Arrays

object KMPMatch extends App {
  def find(text: String, pattern: String): Unit = {
    val pt = formPrefixTable(pattern)
    var i = 0
    var j = 0

    while (i < text.length) {
      if (text(i) == pattern(j)) {
        if (j == pattern.length - 1) {
          println("Match found at - " + (i - pattern.length + 1))
          j = pt(j - 1)
        } else {
          i += 1
          j += 1
        }
      } else if (j > 0) {
        j = pt(j - 1)
      } else {
        i += 1
      }
    }
  }

  def formPrefixTable(pattern: String): Array[Int] = {
    val pt = Array.ofDim[Int](pattern.length);
    pt(0) = 0
    var i = 1;
    var j = 0;
    while (i < pattern.length) {
      if (pattern(i) == pattern(j)) {
        j += 1
        pt(i) = j
        i += 1
      } else if (j > 0) {
        j = pt(j - 1)
      } else {
        pt(i) = 0
        i += 1
      }
    }

    pt
  }

  // Reference - https://github.com/rafiulgits/Algorithm-Lab/wiki/String-pattern-matching-with-transition-table-(finite-automata)
  formPrefixTable("ababaca").map(s => println(s + " "))
  find("ababacababaca", "ababac")
}