package com.leetcode;

import java.util.ArrayList;
import java.util.TreeMap;

public class leetcode_198 {
    // using dp to solve this problem
    // O(n)
    public int rob(int[] nums) {
        ArrayList<Integer> result = new ArrayList<>();
        if (nums.length == 0) {
            return 0;
        }
        result.add(0); // when nums.length == 0
        result.add(nums[0]); //when nums.length == 1;
        for (int i = 1; i < nums.length; i++) {
            int value = Math.max(result.get(i - 1) + nums[i], result.get(i));
            result.add(value);
        }
        return result.get(nums.length);
    }

    public static void main(String[] args) {
        leetcode_198 solution = new leetcode_198();
        int[] nums = {1, 2, 3, 1};
        new TreeMap<>();
        solution.rob(nums);
    }
}
