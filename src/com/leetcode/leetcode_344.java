package com.leetcode;

public class leetcode_344 {
    public String reverseString(String s) {
        //int n = s.length();
        //if(n==0 || n ==1 ) return s;
        //char [] charArray = s.toCharArray();
        //char temp;
        //for(int i = 0;i<n/2;i++){
        //    temp = charArray[i];
        //    charArray[i] = charArray[n-i-1];
        //    charArray[n-i-1] = temp;
        //}
        //return new String(charArray);
        StringBuilder stringbuilder = new StringBuilder(s);
        return stringbuilder.reverse().toString();
    }
}
