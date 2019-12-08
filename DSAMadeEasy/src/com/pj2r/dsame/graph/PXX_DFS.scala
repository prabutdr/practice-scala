package com.pj2r.dsame.graph

import scala.collection.mutable.Stack

object PXX_DFS extends App {
  def dfs(g: Graph): Unit = {
    val visited = Array.ofDim[Boolean](g.size)
    val stack = Stack[Int]()

    stack.push(0)
    println(stack.top)
    visited(0) = true

    while (!stack.isEmpty) {
      val nuv = nextUnvisitedVertex(stack.top)
      if (nuv == -1) {
        stack.pop()
      } else {
        println(nuv)
        stack.push(nuv)
        visited(nuv) = true
      }
    }

    def nextUnvisitedVertex(i: Int): Int = {
      for (j <- 0 until g.size) {
        //        println(s"Found($i, $j) = ${g.isEdge(i, j)}")
        if (g.isEdge(i, j) && visited(j) == false) {
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
  dfs(g)
}