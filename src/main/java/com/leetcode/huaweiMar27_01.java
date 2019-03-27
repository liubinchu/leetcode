package com.leetcode;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * @author liubi
 * @date 2019-03-27 19:07
 **/
public class huaweiMar27_01 {
    private static void fun(int n, String data) {
        ArrayList<String> strings = new ArrayList<>(n + 1);
        StringBuilder stringBuilder = new StringBuilder();
        boolean isZero = false;
        for (int i = 0; i < data.length(); i++) {
            char current = data.charAt(i);
            if (current == '0' || current == '1') {
                // 上一次完成的加入
                if (isZero) {
                    strings.add(stringBuilder.reverse().toString());
                } else {
                    strings.add(stringBuilder.toString());
                }
                stringBuilder = new StringBuilder();
                isZero = (current == '0');
            } else {
                stringBuilder.append(current);
            }
        }
        for (int i = 1; i < strings.size(); i++) {
            System.out.print(strings.get(i) + " ");
        }
        //输出最后一个
        if (isZero) {
            System.out.print((stringBuilder.reverse().toString()) + "\n");
        } else {
            System.out.print((stringBuilder.toString()) + "\n");
        }
    }
    private static void fun1(int n, String data) {
        for(int i=0;i<n-1;i++){
            StringBuilder stringBuilder = new StringBuilder();
            boolean isZero = data.charAt(i*9)=='0';
            for(int j=i*9+1; j<i*9+9;j++){
                stringBuilder.append(data.charAt(j));
            }
            if(isZero){
                System.out.print(stringBuilder.reverse().toString()+" ");
            }
            else {
                System.out.print(stringBuilder.toString()+" ");
            }
        }
        StringBuilder stringBuilder = new StringBuilder();
        boolean isZero = data.charAt(data.length()-9)=='0';
        for(int j=data.length()-8; j<data.length();j++){
            stringBuilder.append(data.charAt(j));
        }
        if(isZero){
            System.out.print(stringBuilder.reverse().toString());
        }
        else {
            System.out.print(stringBuilder.toString());
        }
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        String data = in.nextLine();
/*      int n = 2;
        String data = "0abcdefgh1abcdefgh";*/
        fun1(n, data);
    }
}
