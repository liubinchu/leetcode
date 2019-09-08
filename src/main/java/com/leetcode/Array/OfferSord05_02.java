package com.leetcode.Array;

import java.util.ArrayList;

/**
 * @author liubi
 * @date 2018-11-19 10:07
 **/
public class OfferSord05_02 {
    /* 该揭发时间复杂度O（n^2）
    public String replaceSpace1(StringBuffer str) {
        for(int i =0;i<str.length();i++){
            char curr = str.charAt(i);
            if(curr == ' '){
                str.replace(i,i+1,"%20");
            }
        }
        return str.toString();
    }
    */

    public String replaceSpace2(StringBuffer str) {
        // Time O(n) Space: O(n)
        StringBuffer newStr = new StringBuffer();
        for (int i = 0; i < str.length(); i++) {
            char curr = str.charAt(i);
            if (curr == ' ') {
                newStr.append("%20");
            } else {
                newStr.append(curr);
            }
        }
        return newStr.toString();
    }

    public String replaceSpace(StringBuffer str) {
        //return  str.toString().replace(" ","%20");
        char[] data = str.toString().toCharArray();
        int numOfSpace = 0;
        for (char c : data) {
            if (c == ' ') {
                numOfSpace++;
            }
        }
        int len1 = data.length;
        int len2 = len1 - numOfSpace + numOfSpace * 3;
        char[] newData = new char[len2];

        for (int i = len1 - 1, j = len2 - 1; i >= 0 && j >= 0; i--) {
            if (data[i] != ' ') {
                newData[j--] = data[i];
            } else {
                newData[j--] = '0';
                newData[j--] = '2';
                newData[j--] = '%';
            }
        }

        return String.valueOf(newData);
    }

    public static void main(String[] args) {
        OfferSord05_02 solution = new OfferSord05_02();
        System.out.println(solution.replaceSpace(new StringBuffer("hello world")));
    }
}
