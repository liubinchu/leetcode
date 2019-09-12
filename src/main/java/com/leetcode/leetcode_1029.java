package com.leetcode;

import java.util.*;

public class leetcode_1029 {
    public int twoCitySchedCost(int[][] costs) {
        Arrays.sort(costs, new Comparator<int[]>() {
            @Override
            public int compare(int[] ints, int[] t1) {
                return (ints[0] - ints[1]) - (t1[0] - t1[1]);
            }
        });
        int sum = 0;
        for (int i = 0; i < costs.length / 2; i++) {
            sum += costs[i][0];
        }
        for (int i = costs.length / 2; i < costs.length; i++) {
            sum += costs[i][1];
        }
        return sum;
    }


    public static void main(String[] args) {
/*        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int a = sc.nextInt();
        int b = sc.nextInt();
        int[][] costs = new int[n][2];
        for (int i = 0; i < n; i++) {
            costs[i][0] = sc.nextInt();
            costs[i][1] = sc.nextInt();
        }
        int cost = fun(costs);
        System.out.println(cost);*/
        int[][] costs = new int[6][2];
        costs[0] = new int[]{259, 770};
        costs[1] = new int[]{448, 54};
        costs[2] = new int[]{926, 667};
        costs[3] = new int[]{184, 139};
        costs[4] = new int[]{840, 118};
        costs[5] = new int[]{577, 469};
        leetcode_1029 so = new leetcode_1029();
        System.out.println(so.twoCitySchedCost(costs));
    }
}
