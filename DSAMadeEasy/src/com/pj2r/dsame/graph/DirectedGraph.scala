package com.pj2r.dsame.graph

class DirectedGraph(val size: Int) {
  val matrix = Array.ofDim[Boolean](size, size)

  private def isValid(i: Int, j: Int) = (i >= 0 && i < size) && (j >= 0 && j < size)

  def addEdge(i: Int, j: Int): DirectedGraph = {
    if (isValid(i, j)) {
      matrix(i)(j) = true
    }
    this
  }

  def removeEdge(i: Int, j: Int): DirectedGraph = {
    if (isValid(i, j)) {
      matrix(i)(j) = false
    }
    this
  }

  def isEdge(i: Int, j: Int): Boolean = {
    if (isValid(i, j))
      matrix(i)(j)
    else
      false
  }

  def getIndegree(): Array[Int] = {
    val indegree = Array.ofDim[Int](matrix.size)
    for (i <- 0 until matrix.size) {
      for (j <- 0 until matrix.size) {
        indegree(i) += (if (matrix(j)(i)) 1 else 0)
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
      sb.append((i + 1) + " [" + matrix(i).map(if (_) 1 else 0).mkString(", ") + "]\n")
    }
    sb.toString()
  }
}

object DirectedGraph {
  def apply(size: Int): DirectedGraph = new DirectedGraph(size)

  // TEST
  def main(args: Array[String]): Unit = {
    val g = DirectedGraph(4)
    println(g)
    g.addEdge(0, 1).addEdge(0, 3).addEdge(1, 2).addEdge(2, 3)
    println(g)
    println(g.getIndegree().mkString("[", ", ", "]"))
  }
}