package com.leetcode;

/**
 * @author liubi
 * @date 2018-11-22 21:07
 **/
public class OfferSordJumpFloor {
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
    public static void main(String[] args) {
        OfferSordJumpFloor solution = new OfferSordJumpFloor();
    }
}
