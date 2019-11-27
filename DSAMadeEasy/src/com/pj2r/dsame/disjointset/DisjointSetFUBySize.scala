package com.pj2r.dsame.disjointset

// Fast union by size
class DisjointSetFUBySize(val size: Int) {
  val s = Array.ofDim[Int](size)

  for (i <- 0 until s.length)
    s(i) = -1

  def find(x: Int): Int = {
    if (x < 0 && x >= s.length)
      return 0
    if (s(x) == -1)
      return x
    return find(s(x))
  }

  def union(r1: Int, r2: Int): Unit = {
    if (find(r1) == find(r2) && s(r1) != -1)
      return
    if ((r1 < 0 && r1 >= s.length) || (r2 < 0 && r2 >= s.length))
      return
    if (s(r1) < s(r2)) {
      s(r2) = r1
      s(r1) += s(r2)
    } else {
      s(r1) = r2
      s(r2) += s(r1)
    }
  }

  override def toString = "DisjointSetFF[" + s.mkString(", ") + "]"
}

object DisjointSetFUBySize {
  def apply(size: Int) = new DisjointSetFUBySize(size)

  // TEST
  def main(args: Array[String]): Unit = {
    val ds = DisjointSetFUBySize(10)
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