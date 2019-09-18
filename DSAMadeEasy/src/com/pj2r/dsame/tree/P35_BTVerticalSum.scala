package com.pj2r.dsame.tree

import scala.collection.mutable.Map

object P35_BTVerticalSum extends App {
  def findVerticalSum(root: BinaryTreeNode, vsum: Map[Int, Int], col: Int): Unit = {
    if (root == null) return
    if (root.left != null) findVerticalSum(root.left, vsum, col - 1)
    if (root.right != null) findVerticalSum(root.right, vsum, col + 1)
    vsum += (col -> (root.data + vsum.getOrElse(col, 0)))
  }

  // TEST
  val bt = BinaryTreeNode(1, 2, 4, 5, 3, 6, 7)
  val vsum = Map[Int, Int]()
  findVerticalSum(bt, vsum, 0)
  println(vsum)
}