package com.wintech.study.basicio

import scala.io.StdIn

object CostOfBallons extends App {
  val tc = StdIn.readInt()

  for (t <- 1 to tc) {
    val Array(cost1, cost2) = StdIn.readLine().split(" ").map(_.toInt)
    val participants = StdIn.readInt()
    var q1Count = 0
    var q2Count = 0
    for (p <- 1 to participants) {
      val Array(q1, q2) = StdIn.readLine().split(" ").map(_.toInt)
      if (q1 == 1) q1Count = q1Count + 1
      if (q2 == 1) q2Count = q2Count + 1
    }

    println((cost1 min cost2) * (q1Count max q2Count) + (cost1 max cost2) * (q1Count min q2Count))
  }
}

/**
You are conducting a contest at your college. This contest consists of two problems and  participants. You know the problem that a candidate will solve during the contest.

You provide a balloon to a participant after he or she solves a problem. There are only green and purple-colored balloons available in a market. Each problem must have a balloon associated with it as a prize for solving that specific problem. You can distribute balloons to each participant by performing the following operation:

Use green-colored balloons for the first problem and purple-colored balloons for the second problem
Use purple-colored balloons for the first problem and green-colored balloons for the second problem
You are given the cost of each balloon and problems that each participant solve. Your task is to print the minimum price that you have to pay while purchasing balloons.

Input format

First line:  that denotes the number of test cases ()
For each test case: 
First line: Cost of green and purple-colored balloons 
Second line:  that denotes the number of participants ()
Next  lines: Contain the status of users. For example, if the value of the  integer in the  row is , then it depicts that the participant has not solved the  problem. Similarly, if the value of the  integer in the  row is , then it depicts that the participant has solved the  problem.
Output format
For each test case, print the minimum cost that you have to pay to purchase balloons.

SAMPLE INPUT 
2
9 6
10
1 1
1 1
0 1
0 0
0 1
0 0
0 1
0 1
1 1
0 0
1 9
10
0 1
0 0
0 0
0 1
1 0
0 1
0 1
0 0
0 1
0 0
SAMPLE OUTPUT 
69
14
*/