package com.pj2r.dsame.graph

class DirectedGraph(val size: Int) {
  val am = Array.ofDim[Boolean](size, size)

  private def isValid(i: Int, j: Int) = (i >= 0 && i < size) && (j >= 0 && j < size)

  def addEdge(i: Int, j: Int): DirectedGraph = {
    if (isValid(i, j)) {
      am(i)(j) = true
    }
    this
  }

  def removeEdge(i: Int, j: Int): DirectedGraph = {
    if (isValid(i, j)) {
      am(i)(j) = false
    }
    this
  }

  def isEdge(i: Int, j: Int): Boolean = {
    if (isValid(i, j))
      am(i)(j)
    else
      false
  }

  override def toString = {
    val sb = new StringBuilder
    sb.append("   ")
    for (i <- 0 until size - 1) {
      sb.append(('A' + i).toChar + "  ")
    }
    sb.append(('A' + size - 1).toChar + "\n")
    for (i <- 0 until size) {
      sb.append(('A' + i).toChar + " [" + am(i).map(if (_) 1 else 0).mkString(", ") + "]\n")
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
    g.addEdge(0, 1).addEdge(0, 3).addEdge(1, 2)
    println(g)
  }
}