package com.pj2r.dsame.tree

import org.junit.runner.RunWith
import org.scalatest.BeforeAndAfter
import org.scalatest.FunSuite
import org.scalatest.junit.JUnitRunner

@RunWith(classOf[JUnitRunner])
class P01_TreeOperationsInBTTest extends FunSuite with BeforeAndAfter {
  val inputs = List(
    (BinaryTreeNode(1, 2, 4, 5, 3, 6, 7), 7),
    (BinaryTreeNode(-1, -2, -4, -5, -3, -6, -7), -1),
    (BinaryTreeNode(0), 0))
  inputs.foreach({
    case (input, output) => {
      test(s"Max value in tree ${input.levelOrderTravelI()} is $output") {
        assertResult(output)(P01_TreeOperationsInBT.findMaxInBT_R(input))
      }
    }
  })

  // Search positive cases
  val inForSearch = List(
    (BinaryTreeNode(1, 2, 4, 5, 3, 6, 7), 7),
    (BinaryTreeNode(1, 2, 4, 5, 3, 6, 7), 5),
    (BinaryTreeNode(-1, -2, -4, -5, -3, -6, -7), -1),
    (BinaryTreeNode(0), 0))
  inForSearch.foreach({
    case (tree, data) => {
      test(s"Tree ${tree.levelOrderTravelI()} contains item $data") {
        assertResult(true)(P01_TreeOperationsInBT.searchInBT_R(tree, data))
      }
    }
  })

  // Search negative cases
  val inForSearch_1 = List(
    (BinaryTreeNode(1, 2, 4, 5, 3, 6, 7), 109),
    (BinaryTreeNode(1, 2, 4, 5, 3, 6, 7), 0),
    (BinaryTreeNode(-1, -2, -4, -5, -3, -6, -7), 1),
    (BinaryTreeNode(0), -1))
  inForSearch_1.foreach({
    case (tree, data) => {
      test(s"Tree ${tree.levelOrderTravelI()} does not contains item $data") {
        assertResult(false)(P01_TreeOperationsInBT.searchInBT_R(tree, data))
      }
    }
  })

  // For finding size
  val inForSearch_2 = List(
    (BinaryTreeNode(1, 2, 4, 5, 3, 6, 7), 7),
    (BinaryTreeNode(1, 2, 4, 5, 3), 5),
    (BinaryTreeNode(-1, -2, -4, -5, -3, -6, -7), 7),
    (BinaryTreeNode(0), 1))
  inForSearch_2.foreach({
    case (tree, size) => {
      test(s"Size of tree ${tree.levelOrderTravelI()} is $size") {
        assertResult(size)(P01_TreeOperationsInBT.sizeOf(tree))
      }
    }
  })

  // For finding depth
  val inForSearch_3 = List(
    (BinaryTreeNode(1, 2, 4, 5, 3, 6, 7), 3),
    (BinaryTreeNode(1, 2, 4, 5, 3), 3),
    (BinaryTreeNode(1, 2), 2),
    (BinaryTreeNode(0), 1))
  inForSearch_3.foreach({
    case (tree, size) => {
      test(s"Depth of tree ${tree.levelOrderTravelI()} is $size") {
        assertResult(size)(P01_TreeOperationsInBT.depthOf(tree))
      }
    }
  })

  // For finding depth using levl order traversal
  val inForSearch_4 = List(
    (BinaryTreeNode(1, 2, 4, 5, 3, 6, 7), 3),
    (BinaryTreeNode(1, 2, 4, 5, 3), 3),
    (BinaryTreeNode(1, 2), 2),
    (BinaryTreeNode(0), 1))
  inForSearch_4.foreach({
    case (tree, size) => {
      test(s"Depth of tree ${tree.levelOrderTravelI()} is $size (using level order traversal)") {
        assertResult(size)(P01_TreeOperationsInBT.depthOf_LevelOrder(tree))
      }
    }
  })

  // For finding depth using post order traversal
  inForSearch_4.foreach({
    case (tree, size) => {
      test(s"Depth of tree ${tree.levelOrderTravelI()} is $size (using post order traversal)") {
        assertResult(size)(P01_TreeOperationsInBT.depthOf_PostOrder(tree))
      }
    }
  })

  // For finding minimum depth using recursion
  val inForSearch_5 = List(
    (BinaryTreeNode(1, 2, 4, 5, 3, 6, 7), 3),
    (BinaryTreeNode(1, 2, 4, 5, 3), 3),
    (BinaryTreeNode(1, 2), 2),
    (BinaryTreeNode(1, 2, 3), 2),
    (BinaryTreeNode(0), 1))
  inForSearch_5.foreach({
    case (tree, size) => {
      test(s"Min depth of tree ${tree.levelOrderTravelI()} is $size (using recursive)") {
        assertResult(size)(P01_TreeOperationsInBT.findMinDepth_R(tree))
      }
    }
  })

  // For removing an item
  val inForSearch_6 = List(
    (BinaryTreeNode(1, 2, 4, 5, 3, 6, 7), 4),
    (BinaryTreeNode(1, 2, 4, 5, 3), 3),
    (BinaryTreeNode(1, 2), 1))
  inForSearch_6.foreach({
    case (tree, data) => {
      test(s"Delete $data from tree ${tree.levelOrderTravelI()}}") {
        assertResult(true) {
          val result = P01_TreeOperationsInBT.deleteFromBT(tree, data)
          println(tree.levelOrderTravelI())
          result
        }
      }
    }
  })

  // For finding structure of two trees are equal (positive)
  val inForSearch_7 = List(
    (BinaryTreeNode(1, 2, 4, 5, 3, 6, 7), BinaryTreeNode(1, 2, 4, 5, 3, 6, 7)),
    (BinaryTreeNode(1, 2, 4, 5, 3), BinaryTreeNode(-1, -2, 0, 5, 7)),
    (BinaryTreeNode(1), BinaryTreeNode(-100)),
    (BinaryTreeNode(1, 2), BinaryTreeNode(100, 200)))
  inForSearch_7.foreach({
    case (tree1, tree2) => {
      test(s"Tree ${tree1.levelOrderTravelI()} and ${tree2.levelOrderTravelI()} are structurly equal") {
        assertResult(true) {
          P01_TreeOperationsInBT.isStructureEqual(tree1, tree2)
        }
      }
    }
  })

  // For finding structure of two trees are equal (negative)
  val inForSearch_8 = List(
    (BinaryTreeNode(1, 2, 4, 5, 3, 6, 7), BinaryTreeNode(1)),
    (BinaryTreeNode(1, 2, 4, 5, 3), BinaryTreeNode(-1, -2, 0, 5, 7, 9)),
    (BinaryTreeNode(1), BinaryTreeNode(-100, 2, 3, 4)),
    (BinaryTreeNode(1, 2), BinaryTreeNode(100)))
  inForSearch_8.foreach({
    case (tree1, tree2) => {
      test(s"Tree ${tree1.levelOrderTravelI()} and ${tree2.levelOrderTravelI()} are structurly not equal") {
        assertResult(false) {
          P01_TreeOperationsInBT.isStructureEqual(tree1, tree2)
        }
      }
    }
  })
}