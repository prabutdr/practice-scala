package com.pj2r.dsame.graph

import scala.collection.mutable.Queue
import scala.collection.mutable.PriorityQueue

object PXX_ShortPathWeightedGraphDijkstra extends App {
  def findShortestPath(dg: WeightedDirectedGraph, sv: Int): (Array[Int], Array[Int]) = {
    val distance = Array.fill(dg.size)(-1)
    val path = Array.fill(dg.size)(-1)
    val visited = Array.ofDim[Boolean](dg.size)

    def nextUnvisitedLowWeight(): Int = {
      var min = -1
      for (i <- 0 until dg.size if visited(i) == false && distance(i) != -1) {
        if (min == -1 || distance(min) > distance(i))
          min = i
      }
      min
    }

    distance(sv) = 0
    var cv = nextUnvisitedLowWeight()

    while (cv != -1) {
      visited(cv) = true
      for (i <- 0 until dg.size if dg.isEdge(cv, i)) {
        if (distance(i) == -1 || distance(i) > distance(cv) + dg.weight(cv, i)) {
          distance(i) = distance(cv) + dg.weight(cv, i)
          path(i) = cv
        }
      }
      cv = nextUnvisitedLowWeight()
    }
    (distance, path)
  }

  // TEST
  val wdg = WeightedDirectedGraph(5)
  wdg.addEdge(0, 1, 4).addEdge(0, 2, 1).addEdge(1, 4, 4).addEdge(2, 1, 2).addEdge(2, 3, 4)
  wdg.addEdge(3, 4, 4)
  val (distance, path) = findShortestPath(wdg, 0)
  println(wdg)
  println(distance.mkString(", "))
  println(path.mkString(", "))

}