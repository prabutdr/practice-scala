package com.pj2r.dsame.tree

object P24_PathHasSum extends App {
  def hasPathSum(root: BinaryTreeNode, sum: Int): Boolean = {
    if (root == null)
      return false
    if (root.data == sum && root.left == null && root.right == null)
      return true
    hasPathSum(root.left, sum - root.data) || hasPathSum(root.right, sum - root.data)
  }

  // TEST
  val bt = BinaryTreeNode(1, 2, 4, 5, 3, 6, 7)
  // Paths ArrayBuffer(List(1, 2, 4), List(1, 2, 5), List(1, 3, 6), List(1, 3, 7))
  println(hasPathSum(bt, 7))
  println(hasPathSum(bt, 3))
}