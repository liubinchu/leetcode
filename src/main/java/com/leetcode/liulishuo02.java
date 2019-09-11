package com.leetcode;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class liulishuo02 {
    /**
     * 定义迷宫数组
     */
    private static int[][] migong;
    private static int count = 0;

    private static void check(int i, int j) {

        if (i == migong[0].length - 1 && j == migong.length - 1) {
            count();
            return;
        }

        if (canMove(i, j, i, j + 1)) {
            migong[i][j] = 5;
            check(i, j + 1);
            migong[i][j] = 0;
        }

        if (canMove(i, j, i, j - 1)) {
            migong[i][j] = 5;
            check(i, j - 1);
            migong[i][j] = 0;
        }

        if (canMove(i, j, i + 1, j)) {
            migong[i][j] = 5;
            check(i + 1, j);
            migong[i][j] = 0;
        }
        //向上走
        if (canMove(i, j, i - 1, j)) {
            migong[i][j] = 5;
            check(i - 1, j);
            migong[i][j] = 0;
        }
    }

    private static boolean canMove(int i, int j, int targetI, int targetJ) {
//        System.out.println("从第" + (i + 1) + "行第" + (j + 1) + "列，走到第" + (targetI + 1) + "行第" + (targetJ + 1) + "列");
        if (targetI < 0 || targetJ < 0 || targetI >= migong[0].length || targetJ >= migong.length) {
//            System.out.println("到达最左边或最右边，失败了");
            return false;
        }
        if (migong[targetI][targetJ] == 1) {
//            System.out.println("目标是墙，失败了");
            return false;
        }
        //避免在两个空格间来回走
        if (migong[targetI][targetJ] == 5) {
//            System.out.println("来回走，失败了");
            return false;
        }

        return true;
    }

    private static void count() {
        count++;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        List<String> data = new ArrayList<>();
        while (sc.hasNext()) {
            data.add(sc.nextLine());
        }
        int m = data.get(0).split(" ").length;
        int n = data.size();
        migong = new int[n][m];
        for (int i = 0; i < n; i++) {
            String[] tmp = data.get(i).split(" ");
            for (int j = 0; j < tmp.length; j++) {
                migong[i][j] = Integer.parseInt(tmp[j]);
            }
        }
        check(0, 0);
        System.out.println(count);
    }
}
