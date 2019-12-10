package com.pj2r.dsame.graph

import scala.collection.mutable.Queue

object PXX_TopologicalSort_BFS extends App {
  def topologicalSort(dg: DirectedGraph): (Boolean, Array[Int]) = {
    val result = Array.ofDim[Int](dg.matrix.size)
    var counter = 0
    val indegree = dg.getIndegree()
    val q = Queue[Int]()

    for (i <- 0 until dg.matrix.size)
      if (indegree(i) == 0)
        q.enqueue(i)

    while (!q.isEmpty) {
      val v = q.dequeue()
      result(counter) = v + 1
      counter += 1
      for (i <- 0 until dg.matrix.size) {
        if (dg.matrix(v)(i)) {
          indegree(i) -= 1
          if (indegree(i) == 0)
            q.enqueue(i)
        }
      }
    }

    if (counter != dg.matrix.size)
      (false, result)
    else
      (true, result)
  }

  //TEST
  val dg = DirectedGraph(8)
  dg.addEdge(0, 3).addEdge(0, 6).addEdge(0, 7)
  dg.addEdge(1, 6)
  dg.addEdge(2, 0).addEdge(2, 1) //.addEdge(2, 4).addEdge(0, 2) // Cycle
  dg.addEdge(4, 0)
  dg.addEdge(5, 1).addEdge(5, 7)
  println(dg)
  val ts = topologicalSort(dg)
  println(ts._1)
  println(ts._2.mkString(", "))

}