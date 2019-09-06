package com.leetcode;

import java.util.Scanner;

/**
 * @author liubi
 * @date 2019-08-24 20:54
 **/
public class jd02 {

    static int[][] test;
    static int[] out;

    public static void fun() {
        while (check(test.length)) {
            for (int i = 0; i < test.length; i++) {
                int temp = 0;
                for (int j = 0; j < test.length; j++) {
                    if (test[i][j] == 1) {
                        temp++;
                    }
                }
                if (temp > 0) {
                    // 第i个人出去
                    out[i] = 1;
                    clear(i, test.length);
                }
            }
        }
        int res = 0;
        for (int j = 0; j < test.length; j++) {
            if (out[j] == 1) {
                res++;
            }

        }
        System.out.println(res);
        for (int j = 0; j < test.length; j++) {
            if (out[j] == 1) {
                System.out.println(j);
            }
        }
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int m = in.nextInt();
        out = new int[2 * n + 1];
        test = new int[out.length][out.length];
        for (int i = 0; i < m; i++) {
            int girl = in.nextInt();
            int boy = in.nextInt();
            test[girl][boy] = 1;
        }
        fun();
    }

    private static boolean check(int len) {
        for (int i = 0; i < len; i++) {
            for (int j = 0; j < len; j++) {
                if (test[i][j] == 1) {
                    return true;
                }
            }
        }
        return false;
    }

    private static void clear(int k, int len) {
        for (int i = 0; i < len; i++) {
            test[k][i] = 0;
        }
        for (int j = 0; j < len; j++) {
            test[j][k] = 0;
        }
    }

}
