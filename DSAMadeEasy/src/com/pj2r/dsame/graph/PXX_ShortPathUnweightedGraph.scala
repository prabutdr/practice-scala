package com.pj2r.dsame.graph

import scala.collection.mutable.Queue

object PXX_ShortPathUnweightedGraph extends App {
  def findShortestPath(dg: DirectedGraph, sv: Int): (Array[Int], Array[Int]) = {
    val distance = Array.fill(dg.size)(-1)
    val path = Array.fill(dg.size)(-1)
    val q = Queue[Int]()

    distance(sv) = 0
    q.enqueue(sv)

    while (!q.isEmpty) {
      val cv = q.dequeue()
      for (i <- 0 until dg.size if distance(i) == -1 && dg.isEdge(cv, i)) {
        distance(i) = distance(cv) + 1
        path(i) = cv
        q.enqueue(i)
      }
    }
    (distance, path)
  }

  // TEST
  val dg = DirectedGraph(7)
  dg.addEdge(0, 1).addEdge(0, 3).addEdge(1, 3).addEdge(1, 4)
  dg.addEdge(2, 0).addEdge(2, 5).addEdge(3, 5).addEdge(3, 6)
  dg.addEdge(4, 6).addEdge(6, 5)
  val (distance, path) = findShortestPath(dg, 2)
  println(dg)
  println(distance.mkString(", "))
  println(path.mkString(", "))
}