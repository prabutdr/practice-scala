package com.pj2r.dsame.stack

import scala.collection.mutable.Stack

object P29_ReplaceNearGreatest extends App {
  def replaceWithNearGreatest(a: Array[Int]): Array[Int] = {
    if (a.length <= 1)
      return a
    var idxStack = 0 :: Nil
    for (i <- 1 until a.length) {
      while (idxStack != Nil && a(idxStack.head) < a(i)) {
        a(idxStack.head) = a(i)
        idxStack = idxStack.tail
      }
      idxStack = i :: idxStack
    }
    a
  }
}