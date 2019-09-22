package com.leetcode;

import java.io.*;
import java.lang.reflect.Array;
import java.util.Arrays;

/**
 * Welcome to vivo !
 */

public class vivo02 {

    public static void main(String[] args) throws Exception {
/*        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String inputStr = br.readLine();
        int input[] = parseInts(inputStr.split(" "));*/
        int[] input = new int[]{6, 3};
        String output = solution(input);
        System.out.println(output);
    }

    private static int[] parseInts(String[] strArr) {
        if (strArr == null || strArr.length == 0) {
            return new int[0];
        }
        int[] intArr = new int[strArr.length];
        for (int i = 0; i < intArr.length; i++) {
            intArr[i] = Integer.parseInt(strArr[i]);
        }
        return intArr;
    }

    private static String solution(int[] input) {
        StringBuilder res = new StringBuilder();
        int n = input[0];
        int m = input[1];
        int[] a = new int[n];
        for (int i = 0; i < n; i++) { //为n个人编号（从1开始编号）
            a[i] = i + 1;
        }
        int remain = n;
        int lastIndex = 0;
        while (remain > 0) {
            int i = lastIndex;
            for (int k = 0; k < m; i++) {
                if (a[i%n] != -1) {
                    k++;
                }
            }
            res.append(a[(i-1)%n]).append(" ");
            a[(i-1)%n] = -1;
            lastIndex = (i-1)%n;
            remain--;
        }
        return res.toString();
    }

/*    private static String solution(int[] input) {

        // TODO Write your code here
        return "3 6 4 2 5 1";
    }*/

}
