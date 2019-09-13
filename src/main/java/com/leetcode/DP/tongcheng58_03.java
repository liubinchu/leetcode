package com.leetcode.DP;

import java.util.Arrays;
import java.util.Queue;
import java.util.Scanner;
import java.util.concurrent.SynchronousQueue;

public class tongcheng58_03 {
    public static int[][] dpFunc(int[][] matrix) {
        int[][] state = new int[matrix.length + 1][matrix[0].length + 1];
        for (int i = 0; i < state.length; i++) {
            state[i][0] = Integer.MAX_VALUE;
        }
        for (int i = 0; i < state[0].length; i++) {
            state[0][i] = Integer.MAX_VALUE;
        }
        // dp
        for (int i = 1; i < state.length; i++) {
            for (int j = 1; j < state[0].length; j++) {
                if (i == 1 && j == 1) {
                    state[i][j] = matrix[0][0];
                } else {
                    state[i][j] = Math.min(state[i - 1][j], state[i][j - 1]) + matrix[i - 1][j - 1];
                }
            }
        }
        return state;
    }


    public static void main(String[] args) {
/*        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[][] matrix = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                matrix[i][j] = sc.nextInt();
            }
        }*/
/*        int[][] matrix = new int[1][2];
        matrix[0][0] = 1;
        matrix[0][1] = 2;
        int[][] state = dpFunc(matrix);
        System.out.println(state[state.length - 1][state[0].length - 1]);*/


    }
}
