package com.leetcode;

import java.util.ArrayList;

public class leetcode_198 {
    // using dp to solve this problem
    // O(n)
    public int rob(int[] nums) {
        ArrayList<Integer> result = new ArrayList<>();
        if(nums.length == 0) return 0;
        result.add(0); // when nums.length == 0
        result.add(nums[0]); //when nums.length == 1;
        for(int i=2 ; i<nums.length+1; i++){
            int value = Math.max(result.get(i-2)+nums[i-1],result.get(i-1));
            result.add(value);
        }
        return result.get(nums.length);
    }
    public static void main(String[] args) {
        leetcode_198 solution = new leetcode_198();
        int[] nums = {1,2,3,1};
        solution.rob(nums);
    }
}
