package com.pj2r.dsame.graph

import scala.collection.mutable.Queue
import scala.collection.mutable.PriorityQueue

object PXX_PrimsMST extends App {
  def findMST(dg: WeightedGraph, sv: Int): (Array[Int], Array[Int]) = {
    val weights = Array.fill(dg.size)(-1)
    val path = Array.fill(dg.size)(-1)
    val visited = Array.ofDim[Boolean](dg.size)

    def nextUnvisitedLowWeight(): Int = {
      var min = -1
      for (i <- 0 until dg.size if visited(i) == false && weights(i) != -1) {
        if (min == -1 || weights(min) > weights(i))
          min = i
      }
      min
    }

    weights(sv) = 0
    var cv = nextUnvisitedLowWeight()

    while (cv != -1) {
      visited(cv) = true
      for (i <- 0 until dg.size if dg.isEdge(cv, i) && visited(i) == false) {
        if (weights(i) == -1 || weights(i) > dg.weight(cv, i)) {
          weights(i) = dg.weight(cv, i)
          path(i) = cv
        }
      }
      cv = nextUnvisitedLowWeight()
    }
    (weights, path)
  }

  // TEST
  val wg = WeightedGraph(7)
  //  wg.addEdge(0, 1, 4).addEdge(0, 2, 1).addEdge(1, 4, 4).addEdge(2, 1, 2).addEdge(2, 3, 4)
  //  wg.addEdge(3, 4, 4)
  wg.addEdge(0, 2, 7).addEdge(0, 3, 5).addEdge(2, 1, 8).addEdge(2, 3, 9).addEdge(2, 4, 7)
  wg.addEdge(1, 4, 5).addEdge(3, 4, 15).addEdge(3, 5, 6).addEdge(4, 5, 8).addEdge(4, 6, 9).addEdge(5, 6, 11)
  val (distance, path) = findMST(wg, 0)
  println(wg)
  println(distance.mkString(", "))
  println(path.mkString(", "))
}