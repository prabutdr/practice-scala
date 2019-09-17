package com.pj2r.dsame.tree

import scala.collection.mutable.ArrayBuffer

object P32_FindAncestors extends App {
  def findAncestors(root: BinaryTreeNode, data: Int, ans: ArrayBuffer[Int]): Boolean = {
    if (root == null)
      return false
    if (root.data == data || findAncestors(root.left, data, ans) || findAncestors(root.right, data, ans)) {
      ans += root.data
      return true
    }
    return false
  }

  // TEST
  val bt = BinaryTreeNode(1, 2, 4, 5, 3, 6, 7)
  var ans = ArrayBuffer[Int]()
  findAncestors(bt, 3, ans)
  println(ans)
}