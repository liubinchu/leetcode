package com.leetcode;

import java.util.ArrayList;

public class leetcode_70 {
    // 分析 ： 经过模拟和观察 发现当前问题的解 可以由之前问题（子问题）的解求的 动态规划问题
    // 设有n个台阶时 共有p(n)个方案 p(n) = P(n-1) +P(n-2) 且 P(1) = 1， P(2) =2
        public int climbStairs(int n) {
            ArrayList<Integer> result = new ArrayList<Integer>();
            result.add(1); // 只有一个台阶的方案数
            result.add(2); // 两个台阶的方案数
            for(int i=2 ; i< n ;i++){
                result.add(result.get(i-1)+result.get(i-2));
            }
            return result.get(n-1);
        }
    public static void main(String[] args) {
        leetcode_70 solution = new leetcode_70();
    }
}
