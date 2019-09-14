package com.pj2r.dsame.tree

import scala.collection.mutable.ArrayBuffer
import scala.collection.mutable.Stack
import scala.collection.mutable.Queue

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
      if (node.right != null) stack.push(node.right)
      if (node.left != null) stack.push(node.left)
    }
    result
  }

  def inOrderTravelI(): ArrayBuffer[Int] = {
    var result = ArrayBuffer[Int]()
    val stack = Stack[BinaryTreeNode]()
    var cNode = this
    var done = false
    while (done == false) {
      if (cNode != null) {
        stack.push(cNode)
        cNode = cNode.left
      } else {
        if (stack.isEmpty)
          done = true
        else {
          cNode = stack.pop()
          result += cNode.data
          cNode = cNode.right
        }
      }
    }
    result
  }

  def postOrderTravelI(): ArrayBuffer[Int] = {
    var result = ArrayBuffer[Int]()
    val stack = Stack[BinaryTreeNode]()
    var cNode = this
    var pNode: BinaryTreeNode = null
    stack.push(this)
    while (!stack.isEmpty) {
      cNode = stack.top
      if (pNode == null || pNode.left == cNode || pNode.right == cNode) {
        if (cNode.left != null)
          stack.push(cNode.left)
        else if (cNode.right != null)
          stack.push(cNode.right)
      } else if (cNode.left == pNode) {
        if (cNode.right != null)
          stack.push(cNode.right)
      } else {
        result += cNode.data
        stack.pop()
      }
      pNode = cNode
    }
    result
  }

  def postOrderTravelI_With2Stack(): ArrayBuffer[Int] = {
    val s1 = Stack[BinaryTreeNode]()
    val s2 = Stack[BinaryTreeNode]()
    s1.push(this)
    while (!s1.isEmpty) {
      val node = s1.pop()
      s2.push(node)
      if (node.left != null)
        s1.push(node.left)
      if (node.right != null)
        s1.push(node.right)
    }
    val result = ArrayBuffer[Int]()
    while (!s2.isEmpty) {
      result += s2.pop().data
    }
    result
  }

  def levelOrderTravelI(): ArrayBuffer[Int] = {
    val q = Queue[BinaryTreeNode]()
    q.enqueue(this)
    val result = ArrayBuffer[Int]()
    while (!q.isEmpty) {
      val node = q.dequeue()
      result += node.data
      if (node.left != null) q.enqueue(node.left)
      if (node.right != null) q.enqueue(node.right)
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
  println("In order R: " + bt.inOrderTravelR())
  println("In order I: " + bt.inOrderTravelI())
  println("Post order R: " + bt.postOrderTravelR())
  println("Post order I: " + bt.postOrderTravelI())
  println("Post order I (with two stack): " + bt.postOrderTravelI_With2Stack())
  println("Level order I: " + bt.levelOrderTravelI())
}