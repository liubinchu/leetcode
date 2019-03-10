package com.leetcode;

import java.util.Scanner;

/**
 * @author liubi
 * @date 2019-03-09 20:52
 **/
public class tengxunMar09_03 {
    private static int fac(int n){
        if(n<=1){
            return 1;
        }
        else{
            return n * fac(n-1);
        }
    }
    private static int combination(int n, int m){
        return fac(n)/(fac(m)*fac(n-m));
    }
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNextInt()) {//注意while处理多个case
            int n = in.nextInt();
            int s = in.nextInt();
            int w,p,l;
            int res = 0;
            res = (int) (combination(n,s) * Math.pow(2,n-s));
            System.out.println(res);
            break;
        }
    }
}
