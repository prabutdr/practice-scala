package com.pj2r.dsame.heap

import scala.collection.mutable.ArrayBuffer

class MinHeap {
  var count: Int = 0
  val buffer = new ArrayBuffer[Int]

  def parent(i: Int): Int = if (i <= 0 || i >= count) -1 else (i - 1) / 2

  def left(i: Int): Int = {
    val left = 2 * i + 1
    if (left >= count) -1 else left
  }

  def right(i: Int): Int = {
    val right = 2 * i + 2
    if (right >= count) -1 else right
  }

  def isEmpty = count == 0

  def getMin: Int = {
    if (count == 0) throw new IllegalStateException("Heap is empty")
    buffer(0)
  }

  def perculateDown(i: Int): Unit = {
    val l = left(i)
    val r = right(i)
    var min = if (l != -1 && buffer(l) < buffer(i)) l else i
    min = if (r != -1 && buffer(r) < buffer(min)) r else min
    if (i != min) {
      val temp = buffer(i)
      buffer(i) = buffer(min)
      buffer(min) = temp
      perculateDown(min)
    }
  }

  def deleteMin(): Int = {
    if (count == 0)
      return -1
    val data = buffer(0)
    buffer(0) = buffer(count - 1)
    count -= 1
    perculateDown(0)
    data
  }

  def insert(data: Int): Unit = {
    buffer += data
    var i = count
    count += 1
    var p = parent(i)
    while (i >= 0 && p != -1 && data < buffer(p)) {
      buffer(i) = buffer(p)
      i = p
      p = parent(i)
    }
    buffer(i) = data
  }

  override def toString: String = "MinHeap[" + buffer.slice(0, count).toString() + "]";

  def apply(i: Int): Int = buffer(i)
}

object MinHeap {
  def apply(data: Int*): MinHeap = {
    apply(data.toArray)
  }

  def apply(a: Array[Int]): MinHeap = {
    val heap = new MinHeap
    heap.buffer ++= a
    heap.count = a.length

    for (i <- (heap.count - 1) / 2 to 0 by -1)
      heap.perculateDown(i)

    heap
  }

  // TEST
  def main(args: Array[String]): Unit = {
    val heap = MinHeap(1, 2, 3, 4, 5, 6, 7)
    println(heap)
    heap.insert(10)
    println(heap)
    heap.insert(0)
    println(heap)
    println(heap.getMin)
    heap.deleteMin()
    println(heap)
  }
}