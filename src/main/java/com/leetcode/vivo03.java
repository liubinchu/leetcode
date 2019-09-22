package com.leetcode;

import java.io.*;
import java.util.Arrays;

/**
 * Welcome to vivo !
 */

public class vivo03 {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String inputStr = br.readLine();
        int input[] = parseInts(inputStr.split(" "));
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
        int a = 0;
        int b = 0;
        Arrays.sort(input);
        for (int i = 0; i < input.length; i++) {
            if (i%2==0){
                b+=input[i];
            }else {
                a+=input[i];
            }
        }
        return Math.abs(b-a);
        // TODO Write your code here


    }
}
