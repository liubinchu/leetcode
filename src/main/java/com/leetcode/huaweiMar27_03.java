package com.leetcode;

import java.util.Scanner;

/**
 * @author liubi
 * @date 2019-03-27 20:19
 **/
public class huaweiMar27_03 {
    private static Pair<Integer, Integer> findMaxDirection(boolean[][] plant, int x, int y) {
        int max = 0;
        int direction = 0;
        {
            // direction0
            int i = x;
            int j = y;
            int sum = 0;
            while (i < 40 && j < 50) {
                if (plant[i][j] = true) {
                    sum++;
                }
                i++;
            }
            while (i >= 0 && j >= 0) {
                if (plant[i][j] = true) {
                    sum++;
                }
                i--;
            }
            if (sum > max) {
                max = sum;
                direction = 0;
            }
        }
        {
            // direction1
            int i = x;
            int j = y;
            int sum = 0;
            while (i < 40 && j < 50) {
                if (plant[i][j] = true) {
                    sum++;
                }
                i++;
                j++;
            }
            while (i >= 0 && j >= 0) {
                if (plant[i][j] = true) {
                    sum++;
                }
                i--;
                j--;
            }
            if (sum > max) {
                max = sum;
                direction = 1;
            }
        }
        {
            // direction2
            int i = x;
            int j = y;
            int sum = 0;
            while (i < 40 && j < 50) {
                if (plant[i][j] = true) {
                    sum++;
                }
                j++;
            }
            while (i >= 0 && j >= 0) {
                if (plant[i][j] = true) {
                    sum++;
                }
                j--;
            }
            if (sum > max) {
                max = sum;
                direction = 2;
            }
        }
        {
            // direction3
            int i = x;
            int j = y;
            int sum = 0;
            while (i < 40 && j >= 0) {
                if (plant[i][j] = true) {
                    sum++;
                }
                j--;
                i++;
            }
             i = x;
             j = y;
            while (i >= 0 && j <50) {
                if (plant[i][j] = true) {
                    sum++;
                }
                j++;
                i--;
            }
            if (sum > max) {
                max = sum;
                direction = 3;
            }
        }

        return new Pair<>(direction, max);
    }

    private static void printPlant(boolean[][] plant) {
        for (int i = 0; i < 40; i++) {
            for (int j = 0; j < 50; j++) {
                if (plant[i][j] == true) {
                    System.out.print("* ");
                } else {
                    System.out.print("_ ");
                }
            }
            System.out.println("\n");
        }
    }

    public static void main(String[] args) {
        boolean[][] plant = new boolean[40][50];
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        for (int i = 0; i < n; i++) {
            int x = in.nextInt();
            int y = in.nextInt();
            plant[x][y] = true;
        }
        printPlant(plant);
    }
}
