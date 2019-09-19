package com.pj2r.dsame.tree

object P38_BTFromPreOrder extends App {
  var i: Int = 0
  def buildTree(preOrder: String): BinaryTreeNode = {
    if (i >= preOrder.length())
      return null

    val node = new BinaryTreeNode(preOrder(i), null, null)
    if (preOrder(i) == 'L')
      return node

    i += 1
    node.left = buildTree(preOrder)
    i += 1
    node.right = buildTree(preOrder)
    node
  }

  // TEST
  println(buildTree("IILLILL"))
}