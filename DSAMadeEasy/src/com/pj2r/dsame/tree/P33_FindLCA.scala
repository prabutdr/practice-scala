package com.pj2r.dsame.tree

import scala.collection.mutable.Stack

object P33_FindLCA extends App {
  def findLCA_R(root: BinaryTreeNode, a: Int, b: Int): BinaryTreeNode = {
    if (root == null) return null
    if (root.data == a || root.data == b) return root

    val leftLCA = findLCA_R(root.left, a, b)
    val rightLCA = findLCA_R(root.right, a, b)

    if (leftLCA != null && rightLCA != null) return root
    if (leftLCA != null) leftLCA else rightLCA
  }

  def findLCA_I(root: BinaryTreeNode, a: Int, b: Int): Int = {
    val aPath = Stack[Int]()
    val bPath = Stack[Int]()
    findPaths(root, a, aPath)
    findPaths(root, b, bPath)
    //    println(a + ": " + aPath)
    //    println(b + ": " + bPath)

    if (!aPath.isEmpty && !bPath.isEmpty) {
      var lca: Int = 0
      while (!aPath.isEmpty && !bPath.isEmpty && aPath.top == bPath.top) {
        lca = aPath.pop()
        bPath.pop()
      }
      return lca
    }

    return -1
  }

  private def findPaths(root: BinaryTreeNode, a: Int, path: Stack[Int]): Boolean = {
    if (root == null) return false
    if (root.data == a || findPaths(root.left, a, path) || findPaths(root.right, a, path)) {
      path.push(root.data)
      return true
    }
    return false
  }

  // TEST
  val bt = BinaryTreeNode(1, 2, 4, 5, 3, 6, 7)
  println(findLCA_R(bt, 2, 4).data)
  println(findLCA_R(bt, 6, 7).data)
  println(findLCA_R(bt, 4, 7).data)
  println(findLCA_I(bt, 2, 4))
  println(findLCA_I(bt, 6, 7))
  println(findLCA_I(bt, 4, 7))
}