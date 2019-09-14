package com.pj2r.dsame.queue

import scala.collection.mutable.Queue

import org.junit.runner.RunWith
import org.scalatest.BeforeAndAfter
import org.scalatest.FunSuite
import org.scalatest.junit.JUnitRunner

@RunWith(classOf[JUnitRunner])
class P09_RearrangeQTest extends FunSuite with BeforeAndAfter {
  val inputs = List(
    (Queue(11, 12, 13, 14, 15, 16, 17, 18, 19, 20), Queue(11, 16, 12, 17, 13, 18, 14, 19, 15, 20)),
    (Queue(1, 1, 2, 2), Queue(1, 2, 1, 2)),
    (Queue[Int](), Queue[Int]()))
  inputs.foreach({
    case (input, output) => {
      test(s"$input rearranged Q = $output") {
        assertResult(output)(P09_RearrangeQ.rearrangeQ(input))
      }
    }
  })

  val invalidInputs = List(
    (Queue(1), Queue(1)),
    (Queue(1, 2, 1), Queue(1, 2, 1)))
  invalidInputs.foreach({
    case (input, output) => {
      test(s"$input Q can not be rearranged") {
        assertThrows[IllegalArgumentException] {
          P09_RearrangeQ.rearrangeQ(input)
        }
      }
    }
  })
}