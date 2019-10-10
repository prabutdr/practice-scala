package com.pj2r.dsame.tree

class TreeNode(var data: Int, var firstChild: TreeNode, var nextSibling: TreeNode) {

  override def toString: String = {
    "[" + data + (if (firstChild != null) ", " + firstChild.toString else "") + (if (nextSibling != null) ", {" + nextSibling.toString() + "}" else "") + "]"
  }
}

object TreeNode {
  def apply(data: Int, firstChild: TreeNode, nextSibling: TreeNode): TreeNode = {
    return new TreeNode(data, firstChild, nextSibling)
  }
}

object TestTreeNode extends App {
  val root = TreeNode(1, TreeNode(2, TreeNode(3, null, null), TreeNode(4, TreeNode(5, null, null), null)), null)
  println(root)
}