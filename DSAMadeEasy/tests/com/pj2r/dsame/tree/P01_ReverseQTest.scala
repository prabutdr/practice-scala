package com.pj2r.dsame.tree

import scala.collection.mutable.Stack
import org.scalatest.FunSuite
import org.scalatest.BeforeAndAfter
import org.junit.runner.RunWith
import org.scalatest.junit.JUnitRunner
import scala.collection.mutable.Queue
import com.pj2r.dsame.queue.P01_ReverseQ

@RunWith(classOf[JUnitRunner])
class P01_FindMaxInBTTest extends FunSuite with BeforeAndAfter {
  val inputs = List(
    (BinaryTreeNode(1, 2, 4, 5, 3, 6, 7), 7),
    (BinaryTreeNode(-1, -2, -4, -5, -3, -6, -7), -1),
    (BinaryTreeNode(0), 0))
  inputs.foreach({
    case (input, output) => {
      test(s"Max value in tree ${input.levelOrderTravelI()} is $output") {
        assertResult(output)(P01_FindMaxInBT.findMaxInBT_R(input))
      }
    }
  })

}