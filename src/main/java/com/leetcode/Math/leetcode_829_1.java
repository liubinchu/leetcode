package com.leetcode.Math;

/**
 * @author liubi
 * @date 2019-09-11 10:58
 **/
public class leetcode_829_1 {
    public int consecutiveNumbersSum(int N) {
        int res = 1;// 定有一个连续整数 N
        for (int a = 1; a < N / 2 + 1; a++) {
            int b_b1 = 2 * N + a * a - a; // b*(b+1)
            int sqrt = (int) Math.sqrt(b_b1);
            if (sqrt * (sqrt + 1) == b_b1) {
                res++;
            }
        }
        return res;
    }
    int consecutiveNumbersSum1(int N) {
        int ans = 0;
        for (int m = 1; ; m++) {
            int mx = N - m * (m-1) / 2;
            if (mx <= 0) {
                break;
            }
            if (mx % m == 0) {
                ans++;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(new leetcode_829_1().consecutiveNumbersSum(5));
    }
}
