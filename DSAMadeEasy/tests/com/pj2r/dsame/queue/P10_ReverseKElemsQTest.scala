package com.pj2r.dsame.queue

import scala.collection.mutable.Queue

import org.junit.runner.RunWith
import org.scalatest.BeforeAndAfter
import org.scalatest.FunSuite
import org.scalatest.junit.JUnitRunner

@RunWith(classOf[JUnitRunner])
class P10_ReverseKElemsQTest extends FunSuite with BeforeAndAfter {
  val inputs = List(
    (Queue(10, 20, 30, 40, 50, 60, 70, 80, 90), 4, Queue(40, 30, 20, 10, 50, 60, 70, 80, 90)),
    (Queue(1, 1), 1, Queue(1, 1)),
    (Queue(1, 2), 1, Queue(1, 2)),
    (Queue(1, 2), 2, Queue(2, 1)),
    (Queue(1, 2), 0, Queue(1, 2)),
    (Queue[Int](), 0, Queue[Int]()))
  inputs.foreach({
    case (q, k, output) => {
      test(s"Reverse $k elements in Q $q = $output") {
        assertResult(output)(P10_ReverseKElemsQ.reverseKElems(q, k))
      }
    }
  })

  val invalidInputs = List(
    (Queue(1), 2, Queue(1)),
    (Queue[Int](), 1, Queue[Int]()))
  invalidInputs.foreach({
    case (q, k, output) => {
      test(s"Reverse $k elements from Q $q is impossible") {
        assertThrows[IllegalArgumentException] {
          P10_ReverseKElemsQ.reverseKElems(q, k)
        }
      }
    }
  })
}