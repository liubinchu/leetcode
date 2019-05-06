package com.leetcode;

/**
 * @author liubi
 * @date 2019-05-06 09:25
 **/
public class leetcode_64 {
    public int minPathSum(int[][] grid) {
        int[][] dp = new int[grid.length][grid[0].length];
        dp[0][0] = grid[0][0];
        for (int i = 1; i < dp.length; i++) {
            dp[i][0] = dp[i - 1][0] + grid[i][0];
        }
        for (int j = 1; j < dp[0].length; j++) {
            dp[0][j] = dp[0][j - 1] + grid[0][j];
        }
        for (int i = 1; i < dp.length; i++) {
            for (int j = 1; j < dp[0].length; j++) {
                dp[i][j] = Math.min(dp[i - 1][j], dp[i][j - 1]) + grid[i][j];
            }
        }
        return dp[grid.length - 1][grid[0].length - 1];
    }

    public static void main(String[] args) {
        leetcode_64 solution = new leetcode_64();
        int[][] grid = new int[3][3];
        grid[0][0] = 1;
        grid[0][1] = 3;
        grid[0][2] = 1;
        grid[1][0] = 1;
        grid[1][1] = 5;
        grid[1][2] = 1;
        grid[2][0] = 4;
        grid[2][1] = 2;
        grid[2][2] = 1;
        System.out.println(solution.minPathSum(grid));
    }
}
