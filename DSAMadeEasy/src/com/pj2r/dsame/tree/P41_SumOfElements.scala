package com.pj2r.dsame.tree

import scala.collection.mutable.Queue

object P41_SumOfElements extends App {
  def sumOfElements_R(root: TreeNode): Int = {
    if (root == null) return 0
    root.data + sumOfElements_R(root.firstChild) + sumOfElements_R(root.nextSibling)
  }

  def sumOfElements_I(root: TreeNode): Int = {
    var sum = 0
    val queue = Queue[TreeNode]()
    queue.enqueue(root)
    while (!queue.isEmpty) {
      val cNode = queue.dequeue()
      sum += cNode.data
      if (cNode.firstChild != null) queue.enqueue(cNode.firstChild)
      if (cNode.nextSibling != null) queue.enqueue(cNode.nextSibling)
    }
    sum
  }

  // TEST
  val root = TreeNode(1, TreeNode(2, TreeNode(3, null, null), TreeNode(4, TreeNode(5, null, null), null)), null)
  println(root)
  println(sumOfElements_R(root))
  println(sumOfElements_I(root))
}