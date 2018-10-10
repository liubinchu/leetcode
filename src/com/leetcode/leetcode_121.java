package com.leetcode;

import java.util.ArrayList;

public class leetcode_121 {
    // 简单的动态规划问题：股票第i天价格为 v(i)
    //设第n天的最大收益为p(n) 那么p(n+1) = max{p(n),V(n+1)-V(1),V(n+1)-V(2),.....,V(n+1)-V(n)}
    // 也就是说 第n+1 天的最大收益可以是 第n天的最大收益，或者是 第n+1 天卖出，之前任意一天买入的收益
    public int maxProfit(int[] prices) {
        if(prices.length == 0) return 0;
        ArrayList<Integer> result = new ArrayList<>();
        result.add(0);// 只有一天，当天买入当天卖出 收益为0
        for(int i=1;i<prices.length;i++){
            int max = result.get(i-1);
            for(int j = 0;j<i;j++){
                int value =-prices[j]+prices[i];
                if(value > max) max = value;
            }
            result.add(max);
        }
        return result.get(prices.length-1);
    }

    public static void main(String[] args) {
        leetcode_121 solution = new leetcode_121();
        int[] nums = {};
        solution.maxProfit(nums);
    }
}
