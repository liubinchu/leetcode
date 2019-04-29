package com.leetcode;

/**
 * @author liubi
 * @date 2019-04-29 20:41
 **/
public class leetcode_10_3 {
    // dp 解法
    private boolean dp[][];
    public boolean isMatch(String s, String p) {
        this.dp = new boolean[s.length()+1][p.length()+1];
        this.dp[0][0] = true;
        for (int i = 0; i < p.length(); i++) {
            if (p.charAt(i) == '*' && this.dp[0][i - 1]) {
                this.dp[0][i + 1] = true;
            }
        }
        for (int i = 0; i < s.length(); i++) {
            for (int j = 0; j < p.length(); j++) {
                if (p.charAt(j) == '*') {
                    if (p.charAt(j - 1) == '.' || s.charAt(i) == p.charAt(j - 1)) {
                        this.dp[i + 1][j + 1] = this.dp[i + 1][j - 1] || this.dp[i][j - 1] || this.dp[i][j + 1];
                    }
                    else {
                        this.dp[i + 1][j + 1] = this.dp[i + 1][j - 1];
                    }
                }
                if (p.charAt(j) == '.' || s.charAt(i) == p.charAt(j)) {
                    this.dp[i + 1][j + 1] = this.dp[i][j];
                }
            }
        }
        return dp[s.length()][p.length()];
    }

    public static void main(String[] args) {
        leetcode_10_3 solution = new leetcode_10_3();
        System.out.println(solution.isMatch("mississippi","mis*is*p*."));
    }
}
