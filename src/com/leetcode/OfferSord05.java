package com.leetcode;

import java.util.ArrayList;

/**
 * @author liubi
 * @date 2018-11-19 10:07
 **/
public class OfferSord05 {
    /* 该揭发时间复杂度O（n^2）
    public String replaceSpace(StringBuffer str) {
        for(int i =0;i<str.length();i++){
            char curr = str.charAt(i);
            if(curr == ' '){
                str.replace(i,i+1,"%20");
            }
        }
        return str.toString();
    }
    */

    public String replaceSpace(StringBuffer str) {
        // Time O(n) Space: O(n)
        StringBuffer newStr = new StringBuffer();
        for(int i =0;i<str.length();i++){
            char curr = str.charAt(i);
            if(curr == ' '){
                newStr.append("%20");
            }
            else newStr.append(curr);
        }
        return newStr.toString();
    }
    public static void main(String[] args) {
        OfferSord05 solution = new OfferSord05();
        ArrayList<Integer> result = new ArrayList<>();
        result.add(100);
        System.out.println(result.get(0));
    }
}
