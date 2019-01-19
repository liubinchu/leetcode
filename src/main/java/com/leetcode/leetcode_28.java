package com.leetcode;

public class leetcode_28 {
    public int strStr(String haystack, String needle) {
        int n_h = haystack.length();
        int n_n = needle.length();
        if(n_n == 0) return 0;
        else if (n_n > n_h) return -1;
        for(int i = 0; i<n_h -n_n+1;i++){
            int j =0 ;
            for(;j< n_n; j++){
                if(haystack.charAt(i+j) != needle.charAt(j))
                    break;
            }
            if(j == n_n) return i;
        }
        return -1;
    }
}
