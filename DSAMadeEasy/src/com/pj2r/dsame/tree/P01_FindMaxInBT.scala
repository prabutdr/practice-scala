package com.pj2r.dsame.tree

object P01_FindMaxInBT extends App {
  // Recursive version
  def findMaxInBT_R(root: BinaryTreeNode): Int = {
    if (root == null) return Integer.MIN_VALUE
    var max = root.data
    max = root.data max findMaxInBT_R(root.left)
    max = root.data max findMaxInBT_R(root.right)
    max
  }
}