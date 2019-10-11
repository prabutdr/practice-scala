//package com.pj2r.dsame.tree
//
//object P44_DepthOfTree extends App {
//  def findDepth(tree: Array[Int]): Int = {
//    val hash = Array.fill(tree.length)(-1)
//
//    return 0
//  }
//
//  def findDepth(tree: Array[Int], idx: Int, hash: Array[Int], depth: Int) = Int {
//    if (idx >= tree.length || tree[idx] == -1) return depth
//    if (hash(tree(idx)) != -1) return hash(tree(idx)) + depth
//    val d = findDepth(tree, tree(idx), hash, depth + 1)
//    hash(idx) = d
//  }
//}