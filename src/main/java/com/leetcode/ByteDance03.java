package com.leetcode;

import java.util.Arrays;
import java.util.Scanner;

public class ByteDance03 {
    static int maxScore = Integer.MIN_VALUE;
    static int[] data;

    public static void dfs(int start, int end, int myScore) {
        while (start >= end) {
            return;
        }
        if (start < data.length - 1) {
            myScore += data[start];
            maxScore = Math.max(myScore, maxScore);
            start++; // 我从头取
            if (start < data.length - 1) {
                dfs(start + 1, end, myScore); // 对方从头取
            }
            if (end > 1) {
                dfs(start, end - 1, myScore);     // 对方从wei取
            }
        }

        start--;
        myScore -= data[start];
        // restore

        if (end > 1) {
            myScore += data[end - 1];
            maxScore = Math.max(myScore, maxScore);
            end--;// 我从wei取
            if (start < data.length - 1) {
                dfs(start + 1, end, myScore);// 对方从头取
            }
            if (end > 1) {
                dfs(start, end - 1, myScore);     // 对方从wei取
            }
        }
    }

    public static void main(String[] args) {
/*        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        data = new int[n];
        for (int i = 0; i < n; i++) {
            data[i] = sc.nextInt();
        }*/
        data = new int[]{1,  1, 1};
        Arrays.sort(data);
        maxScore = 0;
        int midIndex = data.length / 2;
        for (int i = midIndex; i < data.length; i++) {
            maxScore += data[i];
        }
        //dfs(0, data.length, 0);
        System.out.println(maxScore);
    }
}
