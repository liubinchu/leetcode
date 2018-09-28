package com.liubinchu;

public class leetcode_14 {
    public  String longestCommonPrefix(String[] strs) {
        int n_string = strs.length;
        if(n_string == 0) return "";
        else if (n_string == 1) return strs[0];
        int index = 0; // 指向每一个数字的第i个元素
        boolean loopControl = true;
        while(loopControl){
            for(int i=0; i<n_string; i++){ // check wether index out of bound on some string
                if(strs[i].length()<=index) {// index 在某个string 上 已经越界
                    loopControl = false;
                    break;
                }
            }
            if(!loopControl) break;
            boolean indexAdd = true;
            for(int i=0; i<n_string-1; i++){
                if(strs[i].charAt(index) != strs[i+1].charAt(index)){
                    loopControl = false;
                    indexAdd = false;
                    break;
                }
            }
            if(indexAdd) index++;
        }
        // index 指向最长公共前缀的下一个元素
        if((index-1) <= -1) return "";
        else return strs[0].substring(0,index); //该函数 index 指向的字符 取不到
    }
}
