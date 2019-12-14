package com.pj2r.dsame.graph

class WeightedDirectedGraph(val size: Int) {
  val matrix = Array.ofDim[Integer](size, size)

  private def isValid(i: Int, j: Int) = (i >= 0 && i < size) && (j >= 0 && j < size)

  def addEdge(i: Int, j: Int, w: Int): WeightedDirectedGraph = {
    if (isValid(i, j)) {
      matrix(i)(j) = w
    }
    this
  }

  def removeEdge(i: Int, j: Int): WeightedDirectedGraph = {
    if (isValid(i, j)) {
      matrix(i)(j) = null
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

  def getIndegree(): Array[Int] = {
    val indegree = Array.ofDim[Int](matrix.size)
    for (i <- 0 until matrix.size) {
      for (j <- 0 until matrix.size) {
        indegree(i) += (if (matrix(j)(i) != null) 1 else 0)
      }
    }
    indegree
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

object WeightedDirectedGraph {
  def apply(size: Int): WeightedDirectedGraph = new WeightedDirectedGraph(size)

  // TEST
  def main(args: Array[String]): Unit = {
    val g = WeightedDirectedGraph(4)
    println(g)
    g.addEdge(0, 1, 1).addEdge(0, 3, 4).addEdge(1, 2, 7).addEdge(2, 3, 2)
    println(g)
    println(g.getIndegree().mkString("[", ", ", "]"))
  }
}