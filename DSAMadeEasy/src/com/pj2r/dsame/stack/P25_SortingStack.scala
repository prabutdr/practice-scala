package com.pj2r.dsame.stack

import scala.collection.mutable.Stack

object P25_SortingStack extends App {
  def sortStack(st: Stack[Int]): Stack[Int] = {
    var ss = Stack[Int]()

    while (!st.isEmpty) {
      val top = st.pop()
      while (!ss.isEmpty && ss.top > top) {
        st.push(ss.pop())
      }
      ss.push(top)
    }

    ss
  }
}