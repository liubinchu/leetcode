package com.leetcode;

/**
 * @author liubi
 * @date 2018-11-19 10:07
 **/
public class OfferSord05 {
    public String replaceSpace(StringBuffer str) {
        for(int i =0;i<str.length();i++){
            char curr = str.charAt(i);
            if(curr == ' '){
                str.replace(i,i+1,"%20");
            }
        }
        return str.toString();
    }
    public static void main(String[] args) {
        OfferSord05 solution = new OfferSord05();
    }
}
