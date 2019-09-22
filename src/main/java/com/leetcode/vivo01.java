package com.leetcode;

import java.io.*;
import java.util.Arrays;

/**
 * Welcome to vivo !
 */
public class vivo01 {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String inputStr = br.readLine();
        int input[] = parseInts(inputStr.split(" "));
        //int[] input = new int[]{2, 2, 3, 0, 4};
        int output = solution(input);
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

    private static int solution(int[] input) {

        // TODO Write your code here
        int[] dp = new int[input.length];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;
        for (int i = 0; i < input.length; i++) {
            for (int j = 0; j < input[i]; j++) {
                if (i + j + 1 < input.length) {
                    dp[i + j + 1] = Math.min(dp[i + j + 1], dp[i] + 1);
                }
            }
        }
        if (dp[input.length - 1] == Integer.MAX_VALUE) {
            return -1;
        } else {
            return dp[input.length - 1];
        }
    }
}
