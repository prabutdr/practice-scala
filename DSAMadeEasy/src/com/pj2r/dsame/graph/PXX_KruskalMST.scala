package com.pj2r.dsame.graph

import scala.collection.mutable.Queue
import scala.collection.mutable.PriorityQueue
import com.pj2r.dsame.disjointset.DisjointSetFF
import scala.collection.mutable.ArrayBuffer

object PXX_KruskalMST extends App {
  def findMST(dg: WeightedGraph): ArrayBuffer[(Int, Int, Int)] = {
    val ds = DisjointSetFF(dg.size)
    val es = ArrayBuffer[(Int, Int, Int)]()

    for ((w, i, j) <- dg.edges()) {
      val ri = ds.find(i)
      val rj = ds.find(j)
      if (ri != rj) {
        //        println(ds.find(i) + ", " + ds.find(j))
        ds.union(ri, rj)
        es += ((w, i, j))
        println(i + ", " + j + ", " + w + ", " + ds)
      }
    }
    es
  }

  // TEST
  val wg = WeightedGraph(7)
  wg.addEdge(0, 2, 7).addEdge(0, 3, 5).addEdge(2, 1, 8).addEdge(2, 3, 9).addEdge(2, 4, 7)
  wg.addEdge(1, 4, 5).addEdge(3, 4, 15).addEdge(3, 5, 6).addEdge(4, 5, 8).addEdge(4, 6, 9).addEdge(5, 6, 11)
  val res = findMST(wg)
  println(wg)
  println(wg.edges())
  println(res)
  //0, 5, 7, 5, 7, 6, 9
  //-1, 4, 0, 0, 2, 3, 4
}