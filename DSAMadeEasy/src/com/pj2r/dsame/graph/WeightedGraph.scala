package com.pj2r.dsame.graph

class WeightedGraph(val size: Int) {
  val matrix = Array.ofDim[Integer](size, size)

  private def isValid(i: Int, j: Int) = (i >= 0 && i < size) && (j >= 0 && j < size)

  def addEdge(i: Int, j: Int, w: Int): WeightedGraph = {
    if (isValid(i, j)) {
      matrix(i)(j) = w
      matrix(j)(i) = w
    }
    this
  }

  def removeEdge(i: Int, j: Int): WeightedGraph = {
    if (isValid(i, j)) {
      matrix(i)(j) = null
      matrix(j)(i) = null
    }
    this
  }

  def isEdge(i: Int, j: Int): Boolean = {
    if (isValid(i, j))
      matrix(i)(j) != null
    else
      false
  }

  def weight(i: Int, j: Int): Integer = {
    if (isValid(i, j))
      matrix(i)(j)
    else
      null
  }

  override def toString = {
    val sb = new StringBuilder
    sb.append("   ")
    for (i <- 0 until size - 1) {
      sb.append((i + 1) + "  ")
    }
    sb.append(size + "\n")
    for (i <- 0 until size) {
      sb.append((i + 1) + " [" + matrix(i).map(x => if (x == null) "N" else x).mkString(", ") + "]\n")
    }
    sb.toString()
  }
}

object WeightedGraph {
  def apply(size: Int): WeightedGraph = new WeightedGraph(size)

  // TEST
  def main(args: Array[String]): Unit = {
    val g = WeightedGraph(4)
    println(g)
    g.addEdge(0, 1, 1).addEdge(0, 3, 4).addEdge(1, 2, 7).addEdge(2, 3, 2)
    println(g)
  }
}