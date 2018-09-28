package com.leetcode;

public class leetcode_242 {
    // 最暴力的方法 O n2 超时
    //public boolean isAnagram(String s, String t) {
    //    char [] charArray_t = t.toCharArray();
    //    int s_n = s.length();
    //    int t_n = t.length();
    //   for(int i = 0 ;i<s_n;i++){
    //       boolean flag = false ;
    //       for(int j = 0; j<t_n; j++){
    //           if(charArray_t[j] == s.charAt(i)){
    //               flag = true;
    //               charArray_t[j] = 'A';
    //               break;
    //           }
    //       }
    //       if( !flag ) return false;// 说明 s 中的元素s_i 不存在于t中
    //   }
    //  for(int i = 0 ;i<t_n ;i++){
    //       if(charArray_t[i]!= 'A') return false;//说明 t 中存在元素 不存在于t中
    //   }
    //   return true;
    // }

    // 方法二 ： 因为
    public boolean isAnagram(String s, String t){
        int [] table = new int [26];
        int n_s = s.length();
        int n_t = t.length();
        for(int i = 0; i<n_s;i++){
            table[s.charAt(i)-'a']++;
        }
        for(int i = 0; i<n_t;i++){
            table[t.charAt(i)-'a']--;
        }
        for(int i = 0 ;i<26 ;i++){
            if(table[i]!= 0) return false ;
        }
        return true;
    }
}
