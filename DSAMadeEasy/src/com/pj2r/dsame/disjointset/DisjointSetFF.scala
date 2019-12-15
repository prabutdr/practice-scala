package com.pj2r.dsame.disjointset

// Fast find
class DisjointSetFF(val size: Int) {
  val s = Array.ofDim[Int](size)

  for (i <- 0 until s.length)
    s(i) = i

  def find(x: Int): Int = {
    if (x < 0 && x >= s.length)
      return -1
    if (s(x) == x)
      return x
    return find(s(x))
  }

  def union(x: Int, y: Int): Unit = {
    if (find(x) == find(y))
      return
    if ((x < 0 && x >= s.length) || (y < 0 && y >= s.length))
      return
    s(x) = y
  }

  override def toString = "DisjointSetFF[" + s.map(find(_)).mkString(", ") + "][" + s.mkString(", ") + "]";
}

object DisjointSetFF {
  def apply(size: Int) = new DisjointSetFF(size)

  // TEST
  def main(args: Array[String]): Unit = {
    val ds = DisjointSetFF(10)
    println(ds)
    ds.union(5, 6)
    ds.union(1, 2)
    ds.union(0, 2)
    for (i <- 0 until ds.size) {
      println(s"find($i): ${ds.find(i)}")
    }
    println(ds)
  }
}