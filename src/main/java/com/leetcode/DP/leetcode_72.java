package com.leetcode.DP;

import java.util.Scanner;

/**
 * @author liubi
 * @date 2019-05-06 09:44
 * 不是非常理解https://blog.csdn.net/dickdick111/article/details/83754775
 **/
public class leetcode_72 {
    static int[][] dp;

    private static int dp(String word1, String word2) {
        for (int i = 0; i < word1.length() + 1; i++) {
            dp[i][0] = i;
        }
        for (int j = 0; j < word2.length() + 1; j++) {
            dp[0][j] = j;
        }
        for (int i = 1; i < word1.length() + 1; i++) {
            for (int j = 1; j < word2.length() + 1; j++) {
                dp[i][j] = Math.min(Math.min(dp[i - 1][j] + 1, dp[i][j - 1] + 1),
                        dp[i - 1][j - 1] + (word1.charAt(i - 1) == word2.charAt(j - 1) ? 0 : 1));
            }
        }
        return dp[word1.length()][word2.length()];
    }

    int[][] state;

    public int minDistance(String word1, String word2) {
        this.state = new int[word1.length() + 1][word2.length() + 1];
        // init dp
        for (int i = 0; i < state.length; i++) {
            state[i][0] = i;
        }
        for (int i = 0; i < state[0].length; i++) {
            state[0][i] = i;
        }
        // dp func
        for (int i = 1; i < state.length; i++) {
            for (int j = 1; j < state[0].length; j++) {
                if (word1.charAt(i - 1) == word2.charAt(j - 1)) {
                    state[i][j] = state[i - 1][j - 1];
                } else {
                    int replace = 1 + state[i - 1][j - 1];
                    int delete = 1 + state[i - 1][j];
                    int add = 1 + state[i][j - 1];
                    state[i][j] = Math.min(Math.min(replace, delete), add);
                }
            }
        }
        return state[word1.length()][word2.length()];
    }


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String word1 = sc.nextLine();
        String word2 = sc.nextLine();
        dp = new int[word1.length() + 1][word2.length() + 1];
        System.out.println(dp(word1, word2));
    }
}
