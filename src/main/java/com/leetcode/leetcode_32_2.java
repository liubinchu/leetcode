package com.leetcode;

/**
 * @author liubi
 * @date 2019-04-30 14:10
 **/
public class leetcode_32_2 {
    /**
     * 没弄懂 时间复杂度 和 空间复杂度 同 使用栈相同
     * @param s
     * @return
     */
    public int longestValidParentheses(String s) {
        int sz = s.length();
        if (sz < 2) {
            return 0;
        }
        int maxLen = 0;
        int[] dp = new int[sz + 1];
        for (int i = 1; i < sz + 1; i++) {
            int j = i - 2 - dp[i - 1];
            if (s.charAt(i - 1) == '(' || j < 0 || s.charAt(j) == ')') {
                dp[i] = 0;
            } else {
                dp[i] = dp[i - 1] + 2 + dp[j];
                maxLen = Math.max(maxLen, dp[i]);
            }
        }
        return maxLen;
    }

    public static void main(String[] args) {
        leetcode_32_2 solution = new leetcode_32_2();
        System.out.println(solution.longestValidParentheses(")()())"));
    }
}
