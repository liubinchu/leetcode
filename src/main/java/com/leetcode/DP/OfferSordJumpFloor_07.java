package com.leetcode.DP;

/**
 * @author liubi
 * @date 2018-11-22 21:07
 **/
public class OfferSordJumpFloor_07 {
    public int JumpFloor(int target) {
        /**
         * 算法分析;
         * 简单地动态规划 分析后 发现就是求斐波那契数列
         */
        int n = target;
        if(n==1)
        {
            return 1;
        }
        else if(n==2) {
            return 2;
        }
        int num1 = 1;
        int num2 = 2;
        int res = 0;
        n -= 2;
        while(n-->0){
            res = num1 +num2;
            num1 = num2;
            num2 = res;
        }
        return res;
    }
/*    int[] dp ;
    public int Fibonacci(int n) {
        this.dp = new int[n+1>2?n+1:2];
        dp[0] = 0;
        dp[1] = 1;
        if (n >= 2) {
            for (int i = 2; i < this.dp.length; i++) {
                this.dp[i] = this.dp[i - 1] + this.dp[i - 2];
            }
        }
        return this.dp[n];
    }*/

    public int Fibonacci(int n) {
        if(n==0||n==1){
            return n;
        }else {
            int n1 = 0;
            int n2 = 1;
            int n3 = n1 + n2 ;
            for(int i=2;i<n+1;i++){
                n3 = n1 + n2;
                n1 = n2;
                n2 = n3;
            }
            return n3;
        }
    }
    public static void main(String[] args) {
        OfferSordJumpFloor_07 solution = new OfferSordJumpFloor_07();
    }
}
