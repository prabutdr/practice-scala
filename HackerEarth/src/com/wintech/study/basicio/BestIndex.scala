package com.wintech.study.basicio

import java.util.Scanner

object BestIndex extends App {
  val in = new Scanner(System.in)
  val n = in.nextInt();
  val a = Array.ofDim[Long](n)
  //  val a = StdIn.readLine().split(" ").map(_.toInt)
  for (i <- 0 until n)
    a(i) = in.nextInt()

  var lws = Math.sqrt(2 * a.length).floor.toInt // Last window size
  var lastIdx = (lws * (lws + 1)) / 2

  if (lastIdx > a.length) {
    lws -= 1
    lastIdx = (lws * (lws + 1)) / 2
  }

  var cSum: Long = a.sum
  for (i <- lastIdx until a.length)
    cSum -= a(i)

  //  println(a.mkString(" "))
  //  println("0: " + 0 + " " + cSum + " " + lws + " " + lastIdx)
  var biSum: Long = cSum
  //  lastIdx += 1
  for (i <- 0 until a.length - 1) {
    cSum -= a(i)
    //    println(cSum)
    if (lastIdx >= a.length) {
      lastIdx -= lws
      lws -= 1

      lastIdx += 1
      for (i <- lastIdx until a.length)
        cSum -= a(i)
      //      println("1: " + i + " " + cSum + " " + lws + " " + lastIdx)
    } else {
      cSum += a(lastIdx)
      //      println("2: " + i + " " + cSum + " " + lws + " " + lastIdx)
      lastIdx += 1
    }

    //    println(i + " " + cSum)
    if (cSum > biSum)
      biSum = cSum
  }
  println(biSum)
}

/**
 * You are given an array  of  elements. Now you need to choose the best index of this array . An index of the array is called best if the special sum of this index is maximum across the special sum of all the other indices.
 *
 * To calculate the special sum for any index  , you pick the first element that is  and add it to your sum. Now you pick next two elements i.e.  and  and add both of them to your sum. Now you will pick the next  elements and this continues till the index for which it is possible to pick the elements. For example:
 *
 * If our array contains  elements and you choose index to be  then your special sum is denoted by -
 * , beyond this its not possible to add further elements as the index value will cross the value .
 *
 * Find the best index and in the output print its corresponding special sum. Note that there may be more than one best indices but you need to only print the maximum special sum.
 *
 * Input
 * First line contains an integer  as input. Next line contains  space separated integers denoting the elements of the array .
 * Output
 * In the output you have to print an integer that denotes the maximum special sum
 *
 * Constraints
 *
 * Sample Inputs
 *
 * Input	Output
 * 5
 * 1 3 1 2 5
 *
 * 8
 * 10
 * 2 1 3 9 2 4 -10 -9 1 3
 *
 * 9
 *
 *
 * SAMPLE INPUT
 * 6
 * -3 2 3 -4 3 1
 * SAMPLE OUTPUT
 * 3
 * Explanation
 * Let us calculate the special value for each index :
 *
 * For index 1:
 * For index 2:
 * For index 3:
 * For index 4:
 * For index 5:
 * For index 6:
 * So the maximum value among all the special values is 3 hence it is the output.
 *
 */
