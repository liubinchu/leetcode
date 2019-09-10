package com.leetcode;

import java.util.Scanner;

public class dianxin02 {
    private static String fun(int num) {
        StringBuilder res = new StringBuilder();
        while (num >= 1000) {
            num -= 1000;
            res.append("M");
        }
        if (num >= 900) {
            num -= 900;
            res.append("CM");
        }
        while (num >= 500) {
            num -= 500;
            res.append("D");
        }
        if (num >= 400) {
            num -= 400;
            res.append("CD");
        }
        while (num >= 100) {
            num -= 100;
            res.append("C");
        }
        if (num >= 90) {
            num -= 90;
            res.append("XC");
        }
        while (num >= 50) {
            num -= 50;
            res.append("L");
        }
        if (num >= 40) {
            num -= 40;
            res.append("XL");
        }
        while (num >= 10) {
            num -= 10;
            res.append("X");
        }
        if (num >= 9) {
            num -= 9;
            res.append("IX");
        }
        while (num >= 5) {
            num -= 5;
            res.append("V");
        }
        if (num >= 4) {
            num -= 4;
            res.append("IV");
        }
        while (num >= 1) {
            num -= 1;
            res.append("I");
        }
        return res.toString();
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        System.out.println(fun(num));
    }
}
