package com.leetcode;

        import java.util.Scanner;

/**
 * @author liubi
 * @date 2019-05-06 09:44
 * 不是非常理解https://blog.csdn.net/dickdick111/article/details/83754775
 **/
public class leetcode_72 {
    static int[][] dp ;
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


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String word1 = sc.nextLine();
        String word2 = sc.nextLine();
        dp = new int[word1.length() + 1][word2.length() + 1];
        System.out.println(dp(word1, word2));
    }
}
