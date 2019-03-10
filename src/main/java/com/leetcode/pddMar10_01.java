package com.leetcode;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author liubi
 * @date 2019-03-10 16:35
 **/
public class pddMar10_01 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNextInt()) {//注意while处理多个case
            int n = in.nextInt();
            int[] a = new int[n];
            int[] b = new int[n];

            for(int i =0;i<n;i++){
                a[i] = in.nextInt();
            }
            for(int i=0;i<n;i++) {
                b[i] = in.nextInt();
            }
            Arrays.sort(a);
            Arrays.sort(b);
            int res =0;
            for(int i=0;i<n;i++){
                res += a[i]*b[n-i-1];
            }
            System.out.println(res);
        }
    }
}
