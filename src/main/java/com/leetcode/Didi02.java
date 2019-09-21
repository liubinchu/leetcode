package com.leetcode;

import java.util.Scanner;

/**
 * @author liubi
 * @date 2019-09-19 20:27
 **/
public class Didi02 {
    public static int fun(int[] data, int m) {
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < data.length - m + 1; i++) {
            int sum = 0;
            for (int j = i; j < i + m; j++) {
                sum += data[j];
            }
            min = Math.min(min, sum);
        }
        return min;
    }

    @FunctionalInterface
    public interface Converter<F, T> {
        T convert(F from);
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[] data = new int[n];
        for (int i = 0; i < n; i++) {
            data[i] = sc.nextInt();
        }

/*        int n = 5;
        int m = 3;
        int[] data = new int[]{1, 2, 3, 4, 5};*/
        System.out.println(fun(data, m));
    }
}
