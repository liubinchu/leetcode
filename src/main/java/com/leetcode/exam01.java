package com.leetcode;

import java.util.Scanner;

/**
 * @author liubi
 * @date 2019-02-20 20:45
 **/
public class exam01 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int x = -1, f = -1, d = -1, p = Integer.MAX_VALUE;
        while (sc.hasNextInt()) {
            x = sc.nextInt();
            f = sc.nextInt();
            d = sc.nextInt();
            p = sc.nextInt();
        }
        if (x < 1 || f < 1 || d < 1) {
            System.out.println(-1);
        }
        double maxP = 2 * Math.pow(10, 9);
        if (p > maxP) {
            System.out.println(-1);
        }
        int days = (f * p + d) / (x + p);
        System.out.println(days);
    }
}
