package com.leetcode;

import java.util.Scanner;

/**
 * @author liubi
 * @date 2019-03-11 15:30
 **/
public class tengxunMar09_01 {
    /**
     * @param n 货币最大面额
     * @param m 商品的价格
     * @return 最少使用纸币 张数
     */
    private static int solution1(int n, int m) {
        int res = 1;
        if (m == 0) {
            res = 0;
        } else {
            while (m > n) {
                m -= n;
                res++;
            }
        }
        return res;
    }

    private static int solution2(int n, int m) {
        int res;
        if (m == 0) {
            res = 0;
        } else {
            res = (m + n - 1) / n;
            // 使用公式
        }
        return res;
    }

    public static void main2(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNextInt()) {//注意while处理多个case
            int n = in.nextInt();
            int m = in.nextInt();
            int res = solution2(n, m);
            System.out.println(res);
            break;
        }
    }

    public static void main(String[] args) {

        for (int n = 1; n < 1000; n++) {
            for (int m = 0; m < 1000000; m++) {
                int res1 = solution1(n, m);
                int res2 = solution2(n, m);
                if (res1 != res2) {
                    System.out.println("n: " + n + " m: " + m + " res1: " + res1 + " res2: " + res2);
                }
            }
        }
    }
}
