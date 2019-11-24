package com.pj2r.dsame.heap

import scala.collection.mutable.ArrayBuffer

class MedianHeap {
  var count: Int = 0
  val minh = MinHeap()
  val maxh = MaxHeap()

  def getMedian: Double = {
    if (count == 0) throw new IllegalStateException("Heap is empty")
    if (count % 2 == 0) (minh.getMin + maxh.getMax) / 2.0 else maxh.getMax
  }

  def insert(data: Int): Unit = {
    var i = count
    count += 1

    if (minh.isEmpty || minh.getMin <= data) minh.insert(data)
    else if (maxh.isEmpty || maxh.getMax >= data) maxh.insert(data)

    if (maxh.count < minh.count) {
      maxh.insert(minh.deleteMin())
    }
  }

  override def toString: String = "MedianHeap[" + maxh + minh + "]";
}

object MedianHeap {
  def apply(data: Int*): MedianHeap = {
    apply(data.toArray)
  }

  def apply(a: Array[Int]): MedianHeap = {
    val heap = new MedianHeap

    for (i <- a) {
      heap.insert(i);
    }

    heap
  }

  // TEST
  def main(args: Array[String]): Unit = {
    val heap = MedianHeap(1, 2, 3, 4, 5, 6, 7)
    println(heap)
    println(heap.getMedian)
    heap.insert(10)
    println(heap)
    println(heap.getMedian)
    heap.insert(0)
    println(heap)
    println(heap.getMedian)
  }
}