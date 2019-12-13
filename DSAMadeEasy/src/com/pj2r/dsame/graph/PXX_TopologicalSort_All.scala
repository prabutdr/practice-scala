package com.pj2r.dsame.graph

import scala.collection.mutable.Queue

object PXX_TopologicalSort_All extends App {
  def topologicalSort(dg: DirectedGraph): Unit = {
    val res = Array.fill[Int](dg.matrix.size)(-1)
    var counter = 0
    val indegree = dg.getIndegree()
    val visited = Array.ofDim[Boolean](dg.size)

    tSort()

    def tSort() {
      var allVisited = true
      for (i <- 0 until dg.matrix.size) {
        if (indegree(i) == 0 && visited(i) == false) {
          res(counter) = i
          counter += 1
          visited(i) = true
          for (j <- 0 until dg.matrix.size if dg.matrix(i)(j) == true)
            indegree(j) -= 1

          tSort()

          counter -= 1
          res(counter) = -1
          visited(i) = false
          for (j <- 0 until dg.matrix.size if dg.matrix(i)(j) == true)
            indegree(j) += 1

          allVisited = false
        }
      }
      if (allVisited)
        println(res.mkString("[", ", ", "]"))
    }
  }

  //TEST
  //  val dg = DirectedGraph(8)
  //  dg.addEdge(0, 3).addEdge(0, 6).addEdge(0, 7)
  //  dg.addEdge(1, 6)
  //  dg.addEdge(2, 0).addEdge(2, 1) //.addEdge(2, 4).addEdge(0, 2) // Cycle
  //  dg.addEdge(4, 0)
  //  dg.addEdge(5, 1).addEdge(5, 7)
  val dg = DirectedGraph(6)
  dg.addEdge(5, 2).addEdge(5, 0).addEdge(4, 0).addEdge(4, 1)
  dg.addEdge(2, 3).addEdge(3, 1)
  println(dg)
  topologicalSort(dg)

}