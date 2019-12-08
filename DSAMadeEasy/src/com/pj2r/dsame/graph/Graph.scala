package com.pj2r.dsame.graph

class Graph(val size: Int) {
  val am = Array.ofDim[Boolean](size, size)

  private def isValid(i: Int, j: Int) = (i >= 0 && i < size) && (j >= 0 && j < size)

  def addEdge(i: Int, j: Int): Graph = {
    if (isValid(i, j)) {
      am(i)(j) = true
      am(j)(i) = true
    }
    this
  }

  def removeEdge(i: Int, j: Int): Graph = {
    if (isValid(i, j)) {
      am(i)(j) = false
      am(j)(i) = false
    }
    this
  }

  def isEdge(i: Int, j: Int) = {
    if (isValid(i, j))
      am(i)(j)
    false
  }

  override def toString = {
    val sb = new StringBuilder
    for (i <- 0 until size) {
      sb.append("[" + am(i).map(if (_) 1 else 0).mkString(", ") + "]\n")
    }
    sb.toString()
  }
}

object Graph {
  def apply(size: Int): Graph = new Graph(size)

  // TEST
  def main(args: Array[String]): Unit = {
    val g = Graph(4)
    println(g)
    g.addEdge(0, 1).addEdge(0, 3).addEdge(1, 2)
    println(g)
  }
}