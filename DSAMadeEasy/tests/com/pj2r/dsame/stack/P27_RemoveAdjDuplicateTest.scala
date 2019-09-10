package com.pj2r.dsame.stack

import scala.collection.mutable.Stack
import org.scalatest.FunSuite
import org.scalatest.BeforeAndAfter
import org.junit.runner.RunWith
import org.scalatest.junit.JUnitRunner

@RunWith(classOf[JUnitRunner])
class P25_RemoveAdjDuplicateTest extends FunSuite with BeforeAndAfter {
  val inputs = List(
    ("careermonk", "camonk"),
    ("mississippi", "m"),
    ("Hello", "Heo"),
    ("ss", ""),
    ("", ""))
  inputs.foreach({
    case (input, output) => {
      test(s"Adjacent duplicates removed version of text $input is $output") {
        assertResult(output)(P27_RemoveAdjDuplicates.removeAdjDuplicates(input))
      }
    }
  })

}