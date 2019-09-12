package com.pj2r.dsame.tree

import scala.collection.mutable.ArrayBuffer
import scala.collection.mutable.Stack

class BinaryTreeNode(var data: Int, var left: BinaryTreeNode, var right: BinaryTreeNode) {

  // R - Recursive versions
  def preOrderTravelR(): ArrayBuffer[Int] = {
    var result = ArrayBuffer[Int]()
    result += data
    if (left != null)
      result ++= left.preOrderTravelR()
    if (right != null)
      result ++= right.preOrderTravelR()
    result
  }

  def inOrderTravelR(): ArrayBuffer[Int] = {
    var result = ArrayBuffer[Int]()
    if (left != null)
      result ++= left.inOrderTravelR()
    result += data
    if (right != null)
      result ++= right.inOrderTravelR()
    result
  }

  def postOrderTravelR(): ArrayBuffer[Int] = {
    var result = ArrayBuffer[Int]()
    if (left != null)
      result ++= left.postOrderTravelR()
    if (right != null)
      result ++= right.postOrderTravelR()
    result += data
    result
  }

  // Iterative versions
  def preOrderTravelI(): ArrayBuffer[Int] = {
    var result = ArrayBuffer[Int]()
    val stack = Stack[BinaryTreeNode]()
    stack.push(this)
    while (!stack.isEmpty) {
      val node = stack.pop()
      result += node.data
      if (node.right != null)
        stack.push(node.right)
      if (node.left != null)
        stack.push(node.left)
    }
    result
  }

}

object BinaryTreeNode {
  def apply(values: Int*): BinaryTreeNode = {
    return createBinaryTree(values.toArray)
  }

  // Form binary tree from given values
  def createBinaryTree(values: Array[Int]): BinaryTreeNode = {
    if (values.isEmpty)
      return null

    val (leftData, rightData) = values.drop(1).splitAt((values.length - 1) / 2)
    return new BinaryTreeNode(values(0), createBinaryTree(leftData), createBinaryTree(rightData))
  }

}

object Test extends App {
  val bt = BinaryTreeNode(1, 2, 4, 5, 3, 6, 7)
  println("Pre order R: " + bt.preOrderTravelR())
  println("Pre order I: " + bt.preOrderTravelI())
  println("In order: " + bt.inOrderTravelR())
  println("Post order: " + bt.postOrderTravelR())
}