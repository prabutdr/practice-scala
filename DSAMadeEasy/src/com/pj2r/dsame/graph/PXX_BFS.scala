package com.pj2r.dsame.graph

import scala.collection.mutable.Queue

object PXX_BFS extends App {
  def bfs(g: Graph): Unit = {
    val visited = Array.ofDim[Boolean](g.size)
    val q = Queue[Int]()

    println(0)
    visited(0) = true
    q.enqueue(0)

    while (!q.isEmpty) {
      val v = q.dequeue()
      var nuv = nextUnvisitedVertex(v)
      while (nuv != -1) {
        println(nuv)
        visited(nuv) = true
        q.enqueue(nuv)

        nuv = nextUnvisitedVertex(v)
      }
    }

    def nextUnvisitedVertex(i: Int): Int = {
      for (j <- 0 until g.size) {
        if (visited(j) == false && g.isEdge(i, j)) {
          return j
        }
      }
      return -1
    }
  }

  // TEST
  val g = Graph(8)
  g.addEdge(0, 1).addEdge(1, 2).addEdge(2, 3).addEdge(2, 4).addEdge(4, 5).addEdge(4, 6).addEdge(4, 7).addEdge(7, 1);
  println(g)
  bfs(g)
}