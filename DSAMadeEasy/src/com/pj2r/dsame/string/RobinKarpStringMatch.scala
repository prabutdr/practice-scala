package com.pj2r.dsame.string

object RobinKarpStringMatch extends App {
  def findMatch(text: String, pattern: String): Long = {
    val prime: Long = 3
    val m = pattern.length
    def hash(s: String, si: Int, ei: Int): Long = {
      var h: Long = 0
      var p: Long = 1
      for (i <- si to ei) {
        h = h + (s(i) * p)
        //        println(s(i) + " = " + (+s(i)) + " * " + p)
        p *= prime
      }
      h
    }

    def rehash(s: String, oi: Int, ni: Int, oldHash: Long): Long = {
      //      println(s(oi) + " = " + (+s(oi)))
      //      println(s(ni) + " = " + (+s(ni)))
      //      println(Math.pow(prime, m - 1).toLong)
      var h = oldHash - s(oi)
      h = h / prime
      h = h + (s(ni) * Math.pow(prime, m - 1).toLong)
      //      println("re hash - " + s.substring(oi + 1, oi + 1 + m) + ", " + h)
      h
    }

    def matchExistAtIndex(si: Int): Boolean = {
      for (i <- si until (si + m)) {
        if (text(i) != pattern(i - si)) return false
      }
      return true
    }

    val pHash = hash(pattern, 0, m - 1)
    //    println("P hash - " + pHash)
    var tHash = hash(text, 0, m - 1)
    //    println("t hash - " + tHash)
    for (i <- 0 to text.length() - m) {
      if (pHash == tHash && matchExistAtIndex(i)) {
        return i
      } else if (i < text.length() - m) {
        tHash = rehash(text, i, i + m, tHash)
      }
    }

    -1
  }

  // TEST
  println(findMatch("GeekForGeeks", "Geek"))
  println(findMatch("GeekForGeeks", "For"))
  println(findMatch("GeekForGeeks", "Geeks"))
  println(findMatch("GeekForGeeks", "rG"))
  println(findMatch("GeekForGeeks", "TEST"))

}