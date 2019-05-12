package com.leetcode;

/**
 * @author liubi
 * @date 2019-05-12 14:17
 **/
public class leetcode_213 {
    private int[] nums;
    private int[] dp1;
    private int[] dp2;
    /**
     * @param start 0: with start; 1 : with end ;other: illegal para
     * @return
     */
    private int robNoLoop(int start) {
        int[] dp;
        int res = 0;
        if (start == 0) {
            dp = dp1;
        } else if (start == 1) {
            dp = dp2;
        } else {
            System.out.println("illegal para");
            return -1;
        }
        if (start == 0) {
            dp[0] = nums[0];
            res = Math.max(res, dp[0]);
        }
        dp[1] = Math.max(dp[0], nums[1]);
        for (int i = 2; i < start + dp.length - 1; i++) {
            dp[i] = Math.max(dp[i - 2] + nums[i], dp[i - 1]);
            res = Math.max(res, dp[i]);
        }
        return res;
    }
    public int rob(int[] nums) {
        this.nums = nums;
        if (nums == null || nums.length == 0) {
            return 0;
        } else if (nums.length == 1) {
            return nums[0];
        } else if (nums.length == 2) {
            return Math.max(nums[0], nums[1]);
        }
        this.dp1 = new int[nums.length]; // dp1中 最后一个元素空出，保持三个index一致
        this.dp2 = new int[nums.length]; // dp2中 第一一个元素空出，保持三个index一致
        int res1 = robNoLoop(0);
        int res2 = robNoLoop(1);
        return Math.max(res1, res2);
    }

    public static void main(String[] args) {
        leetcode_213 solution = new leetcode_213();
        int[] rob = {4,1,2};
        System.out.println(solution.rob(rob));
    }
}
