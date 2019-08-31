package com.wintech.study.basicio

import scala.io.StdIn
import scala.util.control.Breaks.breakable
import scala.util.control.Breaks.break

object BricksGame extends App {
  var bricks = StdIn.readInt()
  
  var i = 1
  while (bricks > 0) {
      bricks -= i
      if (bricks <= 0) {
        println("Patlu")
      } else if (bricks <= 2 * i) {
        println("Motu")
      }
      bricks -= 2 * i
      i += 1
  }
  
  /*breakable {
    for (i <- 1 to bricks) {
      if (bricks <= i) {
        println("Patlu")
        break
      }
      bricks -= i
      if (bricks <= 2 * i) {
        println("Motu")
        break
      }
      bricks -= 2 * i
    }
  }*/
}

/**
Patlu and Motu works in a building construction, they have to put some number of bricks N from one place to another, and started doing their work. They decided , they end up with a fun challenge who will put the last brick.

They to follow a simple rule, In the i'th round, Patlu puts i bricks whereas Motu puts ix2 bricks.

There are only N bricks, you need to help find the challenge result to find who put the last brick.

Input:

First line contains an integer N.

Output:

Output "Patlu" (without the quotes) if Patlu puts the last bricks ,"Motu"(without the quotes) otherwise.

Constraints:

1 ≤ N ≤ 10000

SAMPLE INPUT 
13
SAMPLE OUTPUT 
Motu
Explanation
Sample Explanation:

13 bricks are there :

Patlu Motu

1 2

2 4

3 1 ( Only 1 remains)

Hence, Motu puts the last one.

*/