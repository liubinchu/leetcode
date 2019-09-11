//package com.leetcode;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class leetcode_1029 {
    private static int fun(int[][] costs) {
        Arrays.sort(costs, new Comparator<int[]>() {
            public int compare(int[] a, int[] b) {
                int v1 = a[1] - a[0];
                int v2 = b[1] - b[0];
                return v1 - v2;
            }
        });
        int sum = 0;
        for (int[] cost : costs) {
            sum += cost[0];
        }
        for (int i = 0; i < costs.length / 2; ++i) {
            sum += costs[i][1] - costs[i][0];
        }
        return sum;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int a = sc.nextInt();
        int b = sc.nextInt();
        int[][] costs = new int[n][2];
        for (int i = 0; i < n; i++) {
            costs[i][0] = sc.nextInt();
            costs[i][1] = sc.nextInt();
        }
        int cost = fun(costs);
        System.out.println(cost);
    }
}
