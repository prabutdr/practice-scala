package com.pj2r.dsame.tree

import scala.collection.mutable.Queue
import scala.collection.mutable.ArrayBuffer
import scala.collection.mutable.Stack
import scala.collection.mutable.Buffer

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

  def depthOf(root: BinaryTreeNode): Int = {
    if (root == null) return 0
    return (1 + depthOf(root.left)) max (1 + depthOf(root.right))
  }

  // *** In order will not work for identify depth, should go for post order / level order
  //  def depthOf_InOrder(root: BinaryTreeNode): Int = {
  //    var depth = 0
  //    var cNode = root
  //    val stack = Stack[BinaryTreeNode]()
  //    //    stack.push(root)
  //    while (cNode != null || !stack.isEmpty) {
  //      if (cNode == null) {
  //        cNode = stack.pop()
  //        cNode = cNode.right
  //      } else {
  //        stack.push(cNode)
  //        cNode = cNode.left
  //        println(stack)
  //        depth = depth max stack.size
  //      }
  //    }
  //    depth
  //  }

  def depthOf_LevelOrder(root: BinaryTreeNode): Int = {
    val q = Queue[BinaryTreeNode]()
    var depth = 0
    q.enqueue(root)
    q.enqueue(null)
    while (!q.isEmpty) {
      val node = q.dequeue()
      if (node == null) {
        depth += 1
        if (!q.isEmpty) q.enqueue(null)
      } else {
        if (node.left != null) q.enqueue(node.left)
        if (node.right != null) q.enqueue(node.right)
      }
    }
    depth
  }

  def levelOrderReverse(root: BinaryTreeNode): Buffer[Int] = {
    val result = ArrayBuffer[Int]()
    val stack = Stack[Int]()
    val q = Queue[BinaryTreeNode]()
    q.enqueue(root)
    while (!q.isEmpty) {
      val node = q.dequeue()
      stack.push(node.data)
      if (node.right != null) q.enqueue(node.right)
      if (node.left != null) q.enqueue(node.left)
    }
    stack.toBuffer
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
  println("Level order reverse - " + levelOrderReverse(bt))
  println(BinaryTreeNode(1, 2, 4, 5, 3))
}