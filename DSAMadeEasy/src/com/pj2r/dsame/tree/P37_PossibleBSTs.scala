package com.pj2r.dsame.tree

object P37_PossibleBSTs extends App {
  def generateTrees(n: Int): List[BinaryTreeNode] = {
    generateTrees(1, n)
  }

  private def generateTrees(start: Int, end: Int): List[BinaryTreeNode] = {
    var subtrees = List[BinaryTreeNode]()
    if (end < start) {
      subtrees = null :: subtrees
      return subtrees
    }
    for (
      i <- start to end;
      left <- generateTrees(start, i - 1);
      right <- generateTrees(i + 1, end)
    ) {
      subtrees = new BinaryTreeNode(i, left, right) :: subtrees
    }
    subtrees
  }

  // TEST
  println(generateTrees(3))
}