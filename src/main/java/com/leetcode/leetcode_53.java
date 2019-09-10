package com.leetcode;

import java.util.ArrayList;
import java.util.Scanner;

public class leetcode_53 {
    // 动态规划：given nums;
    //前n个元素的最大子序和为r(n)，then r(n+1) = max(r(n), nums[0]+....nums[n+1],nums[1]+.....nums[n+1], ....., nums[n+1])
    public static int maxSubArray0(int[] nums) {
        ArrayList<Integer> result = new ArrayList<>();
        result.add(Integer.MIN_VALUE); // 数组长度为0的情况
        for (int i = 1; i < nums.length + 1; i++) {
            int max = result.get(i - 1);
            int sum = 0;
            for (int j = i - 1; j >= 0; j--) {
                sum += nums[j];
                if (sum > max) max = sum;
            }
            result.add(max);
        }
        return result.get(nums.length);
    }

    public static int maxSubArray(int[] nums) {
        int[] dp = new int[nums.length]; // dp[i] 表示以i结尾的 和最大连续字串的值
        dp[0] = nums[0];
        int maxSum = dp[0];
        for (int i = 1; i < nums.length; i++) {
            dp[i] = nums[i] + (dp[i - 1] > 0 ? dp[i - 1] : 0);
            maxSum = Math.max(maxSum, dp[i]);
        }
        return maxSum;
    }

    public static int dp(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        } else if (nums.length == 1) {
            return nums[0];
        }
        int[] dp = new int[nums.length];
        dp[0] = nums[0];
        int max = dp[0];
        for (int i = 1; i < dp.length; i++) {
            dp[i] = dp[i - 1] > 0 ? nums[i] + dp[i - 1] : nums[i];
            max = Math.max(max, dp[i]);
        }
        return max;
    }


    public static void main(String[] args) {
      /*  Scanner sc = new Scanner(System.in);
        String tmp = sc.nextLine().replace("[","").replace("]","");
        */
        String tmp = "[2, 4, -2, 5, -6]".replace("[", "").replace("]", "");
        String[] tmp1 = tmp.split(", ");
        int[] nums = new int[tmp1.length];
        for (int i = 0; i < nums.length; i++) {
            nums[i] = Integer.parseInt(tmp1[i]);
        }
        System.out.println(maxSubArray(nums));

/*        Math.log(10);
        leetcode_53 solution = new leetcode_53();
        System.out.println(Runtime.getRuntime().maxMemory());*/
    }
}
