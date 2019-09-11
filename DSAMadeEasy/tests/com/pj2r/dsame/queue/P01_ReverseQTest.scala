package com.pj2r.dsame.stack

import scala.collection.mutable.Stack
import org.scalatest.FunSuite
import org.scalatest.BeforeAndAfter
import org.junit.runner.RunWith
import org.scalatest.junit.JUnitRunner
import scala.collection.mutable.Queue
import com.pj2r.dsame.queue.P01_ReverseQ

@RunWith(classOf[JUnitRunner])
class P01_ReverseQTest extends FunSuite with BeforeAndAfter {
  val inputs = List(
    (Queue(3, 2, 5, 6, 1, 4, 4), Queue(4, 4, 1, 6, 5, 2, 3)),
    (Queue(1, 2, 4), Queue(4, 2, 1)),
    (Queue(2, 1, 2, 3, 1), Queue(1, 3, 2, 1, 2)),
    (Queue(1, 1, 1), Queue(1, 1, 1)))
  inputs.foreach({
    case (input, output) => {
      test(s"$input reverse = $output") {
        assertResult(output)(P01_ReverseQ.reverseQ(input))
      }
    }
  })

}