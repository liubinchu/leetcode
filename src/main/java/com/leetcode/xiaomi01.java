package com.leetcode;

import java.util.*;

public class xiaomi01 {


    /*请完成下面这个函数，实现题目要求的功能
    当然，你也可以不按照下面这个模板来作答，完全按照自己的想法来 ^-^
    ******************************开始写代码******************************/
    static int[][] a;
    static int n;
    static int m;

    static String solution(String[] input) {
        // init a
        m = input[0].split(" ").length;
        a = new int[n][m];
        for (int i = 0; i < input.length; i++) {
            String[] tmp = input[i].split(" ");
            for (int j = 0; j < tmp.length; j++) {
                a[i][j] = Integer.parseInt(tmp[j]);
            }
        }
        leftRemoveBlank();
        leftMove();
        return outPut();
    }


    static String outPut() {
        StringBuilder res = new StringBuilder();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                res.append(a[i][j]).append(" ");
            }
            res.deleteCharAt(res.length() - 1);
            res.append("\n");
        }
        return res.toString();
    }

    static void leftRemoveBlank() {
        for (int i = 0; i < n; i++) {
            for (int j = 1; j < m; j++) {
                int k = j;
                while (k - 1 >= 0 && a[i][k - 1] == 0) {
                    a[i][k] = a[i][k] ^ a[i][k - 1];
                    a[i][k - 1] = a[i][k - 1] ^ a[i][k];
                    a[i][k] = a[i][k] ^ a[i][k - 1];
                    k--;
                }
            }
        }
    }

    static void leftMove() {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m - 1; j++) {
                if (a[i][j] == a[i][j + 1]) {
                    a[i][j] += a[i][j + 1];
                    a[i][j + 1] = 0;
                    leftRemoveBlank();
                }
            }
        }
    }


    /******************************结束写代码******************************/


    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String res;

        n = Integer.parseInt(in.nextLine().trim());
        String[] _input = new String[n];
        String _input_item;
        for (int _input_i = 0; _input_i < n; _input_i++) {
            try {
                _input_item = in.nextLine();
            } catch (Exception e) {
                _input_item = null;
            }
            _input[_input_i] = _input_item;
        }

        res = solution(_input);
        System.out.println(res);
    }


}
