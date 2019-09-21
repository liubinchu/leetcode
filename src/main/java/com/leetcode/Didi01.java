package com.leetcode;

import java.util.Map;
import java.util.Scanner;
import java.util.Set;

/**
 * @author liubi
 * @date 2019-09-19 19:56
 **/
public class Didi01 {
    static int n;
    static int m;
    static Map<Integer, Set<Integer>> yueShu;
    static int max = Integer.MIN_VALUE;
    static Set<Integer> laJi;

    public static void dfs(int curr, Set<Integer> A, Set<Integer> B) {
        if (curr >= n) {
            max = Math.max(max, Math.max(A.size(), B.size()));
        } else {
            if (!yueShu.containsKey(curr)) {
                A.add(curr);
                dfs(curr + 1, A, B);
                A.remove(curr);

                B.add(curr);
                dfs(curr + 1, A, B);
                B.remove(curr);
            } else {
                for (int y : yueShu.get(curr)) {
                    if (A.contains(y)) {
                        B.add(curr);
                        dfs(curr + 1, A, B);
                        B.remove(curr);
                    } else if (B.contains(y)) {
                        A.add(curr);
                        dfs(curr + 1, A, B);
                        A.remove(curr);
                    } else {
                        A.add(curr);
                        dfs(curr + 1, A, B);
                        A.remove(curr);

                        B.add(curr);
                        dfs(curr + 1, A, B);
                        B.remove(curr);
                    }
                }
            }
        }
    }

    /*    public static void main(String[] args) {
            Scanner sc = new Scanner(System.in);
          n = sc.nextInt();
            m = sc.nextInt();
    *//*        n = 5;
        m = 2;*//*
        laJi = new HashSet<>();
        for (int i = 0; i < n; i++) {
            laJi.add(i);
        }
   int[][] input = new int[m][2];
     for (int i = 0; i < m; i++) {
            input[i][0] = sc.nextInt();
            input[i][1] = sc.nextInt();
        }
     *//*   int[][] input = new int[][]{{1, 4}, {3, 4}};*//*

        yueShu = new HashMap<>();
        // key : laji  value ： 排斥的垃圾
        for (int i = 0; i < m; i++) {
            //    int a = sc.nextInt();
            //   int b = sc.nextInt();
            int a = input[i][0];
            int b = input[i][1];
            if (yueShu.containsKey(a)) {
                yueShu.get(a).add(b);
            } else {
                Set<Integer> tmpA = new HashSet<>();
                tmpA.add(b);
                yueShu.put(a, tmpA);
            }
            if (yueShu.containsKey(b)) {
                yueShu.get(b).add(a);
            } else {
                Set<Integer> tmpB = new HashSet<>();
                tmpB.add(a);
                yueShu.put(b, tmpB);
            }
        }

        dfs(0, new HashSet<>(), new HashSet<>());
        System.out.println(max);
    }*/

}
