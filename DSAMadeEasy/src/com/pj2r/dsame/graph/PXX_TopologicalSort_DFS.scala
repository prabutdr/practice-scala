package com.pj2r.dsame.graph

import scala.collection.mutable.Queue
import scala.collection.mutable.Stack

object PXX_TopologicalSort_DFS extends App {
  def topologicalSort(dg: DirectedGraph): (Boolean, Array[Int]) = {
    val result = Array.ofDim[Int](dg.matrix.size)
    var counter = 0
    val stack = Stack[Int]()
    val visited = Array.ofDim[Boolean](dg.size)

    for (i <- 0 until dg.size if visited(i) == false) {
      tSort(i)
    }

    def tSort(i: Int): Unit = {
      visited(i) = true
      for (j <- 0 until dg.size) {
        if (visited(j) == false && dg.isEdge(i, j)) {
          tSort(j)
        }
      }
      stack.push(i)
    }

    //    println(stack.top)
    if (stack.size != dg.matrix.size)
      (false, stack.toArray.map(_ + 1))
    else
      (true, stack.toArray.map(_ + 1))
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