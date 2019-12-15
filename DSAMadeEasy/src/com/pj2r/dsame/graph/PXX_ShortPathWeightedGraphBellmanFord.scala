package com.pj2r.dsame.graph

import scala.collection.mutable.Queue
import scala.collection.mutable.PriorityQueue

object PXX_ShortPathWeightedGraphBellmanFord extends App {
  def findShortestPath(dg: WeightedDirectedGraph, sv: Int): (Array[Integer], Array[Int]) = {
    val distance = Array.fill[Integer](dg.size)(null)
    val path = Array.fill(dg.size)(-1)
    val q = Queue[Int]()

    distance(sv) = 0
    q.enqueue(0)

    while (!q.isEmpty) {
      val cv = q.dequeue()
      for (i <- 0 until dg.size if dg.isEdge(cv, i)) {
        if (distance(i) == null || distance(i) > distance(cv) + dg.weight(cv, i)) {
          distance(i) = distance(cv) + dg.weight(cv, i)
          path(i) = cv
          if (!q.contains(i))
            q.enqueue(i)
        }
      }
    }
    (distance, path)
  }

  // TEST
  val wdg = WeightedDirectedGraph(5)
  //  wdg.addEdge(0, 1, 4).addEdge(0, 2, 1).addEdge(1, 4, 4).addEdge(2, 1, 2).addEdge(2, 3, 4)
  //  wdg.addEdge(3, 4, 4)
  wdg.addEdge(0, 1, -1).addEdge(0, 2, 4).addEdge(1, 2, 3).addEdge(1, 3, 2)
  wdg.addEdge(1, 4, 2).addEdge(3, 1, 1).addEdge(4, 3, -3).addEdge(3, 2, 5)
  val (distance, path) = findShortestPath(wdg, 0)
  println(wdg)
  println(distance.mkString(", "))
  println(path.mkString(", "))
  //0, 3, 1, 5, 7
  //-1, 2, 0, 2, 1
}