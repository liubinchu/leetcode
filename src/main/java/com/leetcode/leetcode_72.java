package com.leetcode;

/**
 * @author liubi
 * @date 2019-05-06 09:44
 * 不是非常理解https://blog.csdn.net/dickdick111/article/details/83754775
 **/
public class leetcode_72 {
    public int minDistance(String word1, String word2) {
        int length1 = word1.length();
        int length2 = word2.length();
        int[][] dp = new int[length1+1][length2+1];
        for(int i=0;i<length1+1;i++){
            dp[i][0] = i;
        }
        for(int j=0;j<length2+1;j++){
            dp[0][j] = j;
        }
        for(int i=1;i<length1+1;i++){
            for (int j=1;j<length2+1;j++){
                dp[i][j] = Math.min(Math.min(dp[i-1][j]+1,dp[i][j-1]+1),
                        dp[i-1][j-1]+(word1.charAt(i-1)==word2.charAt(j-1)?0:1));
            }
        }
        return dp[length1][length2];
    }
    public static void main(String[] args) {
        leetcode_72 solution = new leetcode_72();
        System.out.println(solution.minDistance("","a"));
    }
}
