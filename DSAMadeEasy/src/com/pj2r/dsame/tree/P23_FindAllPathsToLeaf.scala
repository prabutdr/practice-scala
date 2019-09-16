package com.pj2r.dsame.tree

import scala.collection.mutable.ArrayBuffer

object P23_FindAllPathsToLeaf extends App {
  var paths = ArrayBuffer[List[Int]]()
  def findPathsToLeaf(root: BinaryTreeNode, buf: Array[Int], pathLen: Int): Unit = {
    if (root == null)
      return
    buf(pathLen) = root.data
    if (root.left == null && root.right == null) {
      // Leaf
      paths += buf.slice(0, pathLen + 1).toList
    } else {
      findPathsToLeaf(root.left, buf, pathLen + 1)
      findPathsToLeaf(root.right, buf, pathLen + 1)
    }
  }

  // TEST
  val bt = BinaryTreeNode(1, 2, 4, 5, 3, 6, 7)
  println(findPathsToLeaf(bt, Array.ofDim[Int](10), 0))
  println(paths)
}