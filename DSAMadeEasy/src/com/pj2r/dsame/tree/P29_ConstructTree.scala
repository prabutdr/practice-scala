package com.pj2r.dsame.tree

import org.scalatest.enablers.Length

object P29_ConstructTree extends App {
  def fromInAndPreOrder(inOrder: Array[Int], preOrder: Array[Int]): BinaryTreeNode = {
    fromInAndPreOrder(inOrder, 0, inOrder.length - 1, preOrder, 0, preOrder.length)
  }

  private def fromInAndPreOrder(inOrder: Array[Int], iStart: Int, iEnd: Int,
                                preOrder: Array[Int], pStart: Int, pEnd: Int): BinaryTreeNode = {
    if (pStart > pEnd || iStart > iEnd)
      return null
    val data = preOrder(pStart)
    val node = new BinaryTreeNode(data, null, null)
    var offset = iStart
    while (offset <= iEnd && inOrder(offset) != data) {
      offset += 1
    }

    node.left = fromInAndPreOrder(inOrder, iStart, offset - 1, preOrder, pStart + 1, pStart + offset - iStart)
    node.right = fromInAndPreOrder(inOrder, offset + 1, iEnd, preOrder, pStart + offset - iStart + 1, pEnd)

    return node
  }

  // TEST
  val bt = fromInAndPreOrder(Array(4, 2, 5, 1, 6, 3), Array(1, 2, 4, 5, 3, 6))
  println(bt.inOrderTravelI())
  println(bt.preOrderTravelI())
  println(bt.postOrderTravelI())
}