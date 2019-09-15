package com.pj2r.dsame.tree

import org.junit.runner.RunWith
import org.scalatest.BeforeAndAfter
import org.scalatest.FunSuite
import org.scalatest.junit.JUnitRunner

@RunWith(classOf[JUnitRunner])
class P20_DiameterOfBTTest extends FunSuite with BeforeAndAfter {
  val inputs = List(
    (BinaryTreeNode(1, 2, 4, 5, 3, 6, 7), 5),
    (BinaryTreeNode(-1, -2, -4, -5, -3, -6, -7), 5),
    (BinaryTreeNode(-1, -2), 2),
    (BinaryTreeNode(-1, -2, 3), 3),
    (BinaryTreeNode(-1, -2, 3, 4), 4),
    (BinaryTreeNode(-1, -2, 3, 4, 5), 5),
    (BinaryTreeNode(0), 1))
  inputs.foreach({
    case (input, output) => {
      test(s"Diameter of ${input.levelOrderTravelI()} is $output") {
        assertResult(output)(P20_DiameterOfBT.findDiameter(input))
      }
    }
  })

}