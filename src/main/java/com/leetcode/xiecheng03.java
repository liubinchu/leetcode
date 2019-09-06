package com.leetcode;

/**
 * @author liubi
 * @date 2019-09-04 20:30
 **/

import java.util.Scanner;

public class xiecheng03 {


    /*请完成下面这个函数，实现题目要求的功能
    当然，你也可以不按照下面这个模板来作答，完全按照自己的想法来 ^-^
    ******************************开始写代码******************************/
    static int schedule(int m, int[] array) {
        int max = 0;
        int sum = 0;
        int i = 0;
        while (i < array.length) {
            max = max > array[i] ? max : array[i];
            sum += array[i++];//求A数组全部值的和，最少切1份
        }
        int low = max;
        int high = sum;
        while (low < high) {
            int mid = low + (high - low) / 2;
            int p = split(array, mid);
            if (p <= m) {
                high = mid;
            } else {
                low = mid + 1;
            }
        }
        return low;
        /*        return fun(m, array.length, array);*/
    }


    private static int split(int[] array, int largestSum) {
        int p = 1;
        int sum = 0;
        for (int a : array) {
            if (sum + a <= largestSum) {
                sum += a;
            } else {
                sum = a;
                p++;
            }
        }
        return p;
    }

    /******************************结束写代码******************************/
/*
    static HashMap<Integer, HashMap<Integer, Integer>> bigset = new HashMap<Integer, HashMap<Integer, Integer>>();
*/

 /*   static int fun(int m, int p, int[] arr) {
        HashMap<Integer, Integer> sset;
        if (bigset.containsKey(p)) {
            if (bigset.get(p).containsKey(m)) {
                return bigset.get(p).get(m);
            }
        }
        int sum = 0, temp, total = Integer.MAX_VALUE;
        if (m == 0) {
            for (int i = 0; i < p; i++) {
                sum += arr[i];
            }
            return sum;
        }
        for (int i = 0; i < p; i++) {
            sum = 0;
            temp = fun(m - 1, i, arr);
            for (int j = i; j < p; j++) {
                sum += arr[j];
            }
            total = Math.min(Math.max(temp, sum), total);
        }
        if (!bigset.containsKey(p)) {
            sset = new HashMap<Integer, Integer>();
            sset.put(m, total);
            bigset.put(p, sset);
        } else {
            bigset.get(p).put(m, total);
        }

        return total;
    }*/
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int m = in.nextInt();
        int size = in.nextInt();
        int[] array = new int[size];
        for (int i = 0; i < size; i++) {
            array[i] = in.nextInt();
        }
        int res = schedule(m, array);
        System.out.println(String.valueOf(res));
    }
}
