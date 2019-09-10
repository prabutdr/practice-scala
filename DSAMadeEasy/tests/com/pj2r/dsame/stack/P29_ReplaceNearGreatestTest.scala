package com.pj2r.dsame.stack

import scala.collection.mutable.Stack
import org.scalatest.FunSuite
import org.scalatest.BeforeAndAfter
import org.junit.runner.RunWith
import org.scalatest.junit.JUnitRunner

@RunWith(classOf[JUnitRunner])
class P29_ReplaceNearGreatestTest extends FunSuite with BeforeAndAfter {
  val inputs = List(
    (Array(3, 2, 5, 6, 1, 4, 4), Array(5, 5, 6, 6, 4, 4, 4)),
    (Array(1, 2, 4), Array(2, 4, 4)),
    (Array(2, 1, 2, 3, 1), Array(3, 2, 3, 3, 1)),
    (Array(1, 1, 1), Array(1, 1, 1)))
  inputs.foreach({
    case (input, output) => {
      test(s"Near greatest replacement version of array [${input.mkString(",")}] is [${output.mkString(",")}]") {
        assertResult(output)(P29_ReplaceNearGreatest.replaceWithNearGreatest(input))
      }
    }
  })

}