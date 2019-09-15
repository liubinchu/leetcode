package com.leetcode;

import java.util.Scanner;

public class ByteDance02 {
    static int max = 0;
    static int totalTime = 1;

    public static void main(String[] args) {
     Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[][] data = new int[n][2];
        for (int i=0;i<n;i++){
            data[i][0] = sc.nextInt();
            data[i][1] = sc.nextInt();
        }
       /*    int[][] data = new int[][]{{1, 3}, {2, 3}, {3, 3}};*/
        fun(data);
        System.out.println(totalTime + " " + max);
    }


    public static void fun(int[][] data) {
        int remain = 0;
        for (int i = 0; i < data.length; i++) {
            if (i == 0) {
                totalTime += data[0][1];
                remain = data[0][1];
                max = Math.max(max, remain);
            } else {
                int timePast = data[i][0] - data[i - 1][0];
                remain -= timePast;
                remain = Math.max(0, remain);
                remain += data[i][1];
                max = Math.max(max, remain);
                totalTime += data[i][1];
            }
        }
    }
}
