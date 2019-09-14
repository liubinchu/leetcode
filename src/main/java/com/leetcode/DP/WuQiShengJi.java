package com.leetcode.DP;

/**
 * @author liubi
 * @date 2019-09-14 22:14
 **/
public class WuQiShengJi {
    // 题目 以及 解析
    //https://blog.csdn.net/kingjinzi_2008/article/details/7723512
    public static float fun(int n, int m, float success) {
        //在n次内，升到m级的概率 m>2
        float[][] dp = new float[n][m];
        // init
        dp[0][0] = 1 - success;
        dp[0][1] = success;
        // dp
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (j == 0) {
                    // 一级武器 由 一级武器 二级武器升级失败得到
                    dp[i][j] = (dp[i - 1][j] + dp[i - 1][j + 1]) * (1 - success);
                } else if (j >= m - 2) {
                    // 最后一级武器 由 倒数第二级升级而来
                    // 最后一级 升级成功后 不会再次升级，也即 倒数第二级 不会由最后一级失败而得到
                    dp[i][j] = dp[i - 1][j - 1] * success;
                } else {
                    dp[i][j] = dp[i - 1][j - 1] * success + dp[i - 1][j + 1] * (1 - success);
                }
            }
        }

        float res = 0;
        for(int i=0;i<n;i++){
            res+=dp[i][m-1];
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(fun(1000,9,0.3f));
    }
}
