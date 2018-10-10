package com.leetcode;

import java.util.ArrayList;

public class leetcode_53 {
    // 动态规划：given nums;
    //前n个元素的最大子序和为r(n)，then r(n+1) = max(r(n), nums[0]+....nums[n+1],nums[1]+.....nums[n+1], ....., nums[n+1])
    public int maxSubArray(int[] nums) {
        ArrayList<Integer> result = new ArrayList<>();
        result.add(Integer.MIN_VALUE); // 数组长度为0的情况
        for(int i=1 ;i<nums.length+1;i++){
            int max = result.get(i-1);
            int sum = 0;
            for(int j =i-1 ; j>=0;j--){
                sum += nums[j];
                if(sum>max) max = sum;
            }
            result.add(max);
        }
        return result.get(nums.length);
    }

    public static void main(String[] args) {
        Math.log(10);
        leetcode_53 solution = new leetcode_53();
    }
}
