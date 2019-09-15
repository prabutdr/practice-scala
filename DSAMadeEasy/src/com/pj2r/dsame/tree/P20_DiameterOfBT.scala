package com.pj2r.dsame.tree

/**
 * Give an algorithm for finding the diameter of the binary tree. The diameter of a
 * tree (sometimes called the width) is the number of nodes on the longest path between two
 * leaves in the tree.
 */
object P20_DiameterOfBT extends App {
  def findDiameter(root: BinaryTreeNode): Int = {
    if (root == null)
      return 0

    val lHeight = heightOfBT(root.left)
    val rHeight = heightOfBT(root.right)
    val lDiameter = findDiameter(root.left)
    val rDiameter = findDiameter(root.right)

    (lHeight + rHeight + 1) max ((lDiameter max rDiameter))
  }

  def heightOfBT(root: BinaryTreeNode): Int = {
    if (root == null)
      return 0
    1 + (heightOfBT(root.left) max heightOfBT(root.right))
  }

  //  def findDiameterOptimized(root: BinaryTreeNode, height: Int): (Int, Int) = {
  //    if (root == null)
  //      return (0, 0)
  //
  //    //    val lHeight = heightOfBT(root.left)
  //    //    val rHeight = heightOfBT(root.right)
  //    val (lDiameter, lHeight: Int) = findDiameterOptimized(root.left, height)
  //    val (rDiameter, rHeight: Int) = findDiameterOptimized(root.right, height)
  //
  //    val height = 1 + (lHeight max rHeight)
  //    val diameter = (lHeight + rHeight + 1) max ((lDiameter max rDiameter))
  //
  //    (diameter, height)
  //  }

}