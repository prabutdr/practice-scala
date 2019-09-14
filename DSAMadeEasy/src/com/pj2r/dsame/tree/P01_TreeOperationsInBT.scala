package com.pj2r.dsame.tree

import scala.collection.mutable.Queue

object P01_TreeOperationsInBT extends App {
  // Recursive version
  def findMaxInBT_R(root: BinaryTreeNode): Int = {
    if (root == null) return Integer.MIN_VALUE
    var max = root.data
    max = root.data max findMaxInBT_R(root.left)
    max = root.data max findMaxInBT_R(root.right)
    max
  }

  def searchInBT_R(root: BinaryTreeNode, data: Int): Boolean = {
    if (root == null)
      return false
    if (root.data == data)
      return true
    return searchInBT_R(root.left, data) || searchInBT_R(root.right, data);
  }

  def insertInBT(root: BinaryTreeNode, data: Int): Unit = {
    val q = Queue[BinaryTreeNode]()
    q.enqueue(root)
    while (!q.isEmpty) {
      val node = q.dequeue()
      if (node.left == null) {
        node.left = BinaryTreeNode(data)
        println(s"Inserting left of ${node.data}")
        return
      } else {
        q.enqueue(node.left)
      }
      if (node.right == null) {
        node.right = BinaryTreeNode(data)
        println(s"Inserting right of ${node.data}")
        return
      } else {
        q.enqueue(node.right)
      }
    }
  }

  def sizeOf(root: BinaryTreeNode): Int = {
    if (root == null)
      return 0
    sizeOf(root.left) + 1 + sizeOf(root.right)
  }

  // TEST
  // Inserting to binary tree
  val bt = BinaryTreeNode(1, 2, 4, 5, 3, 6, 7)
  println("Binary tree - " + bt.levelOrderTravelI())
  insertInBT(bt, 10)
  insertInBT(bt, 12)
  insertInBT(bt, 13)
  insertInBT(bt, 14)
  println("Binary tree - " + bt.levelOrderTravelI())
}