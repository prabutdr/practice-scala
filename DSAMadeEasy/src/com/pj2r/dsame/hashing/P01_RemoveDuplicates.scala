package com.pj2r.dsame.hashing

object P01_RemoveDuplicates extends App {
  def removeDuplicates(text: String): String = {
    val hash = Array.ofDim[Int](256)
    val sb = new StringBuilder
    for (ch <- text) {
      if (hash(ch.toInt) == 0) {
        sb.append(ch)
        hash(ch.toInt) = 1
      }
    }
    sb.toString()
  }

  // TEST
  val text = "the context for this is bar is the response from a HTTP client over web sockets";
  println(text)
  println(removeDuplicates(text))
}