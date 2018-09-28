package com.liubinchu;

public class leetcode_8 {
    // 主要有两个部分 1. 找到第一个元素 2. 判断是否越界
    public int myAtoi(String str) {
        boolean finded = false;
        boolean positive = true;
        int n = str.length();
        int res = 0;
        int res_temp = 0;
        int temp = 0;
        for(int i =0 ; i<n ; i++){
            if((finded == false)&& (str.charAt(i) == ' ')) continue;
            else if((finded == false)&& (i == (n-1)) && ((str.charAt(i)>'9')||(str.charAt(i) <'0'))) return 0;
            else if((finded == false)&& (str.charAt(i) == '+')&& (str.charAt(i+1)<='9')&&(str.charAt(i+1) >= '0')) {
                finded = true;
                continue;
            }
            else if((finded == false)&& (str.charAt(i) == '-')&& (str.charAt(i+1)<='9')&&(str.charAt(i+1) >= '0')){
                finded = true;
                positive = false;
                continue;
            }
            else if((finded == false)&& (str.charAt(i)<='9')&&(str.charAt(i) >= '0')){
                finded = true;
                temp = str.charAt(i)-'0';
            }
            else if((finded == false)) return 0;
            else if((finded == true)&& (str.charAt(i)<='9')&&(str.charAt(i) >= '0')){
                temp = str.charAt(i)-'0';
            }
            else if((finded == true)) break; //如小数点向下取整 如其他字符 结束
            res_temp = res *10 + temp ;
            if((res_temp/10)!=res){
                if(positive == true) return Integer.MAX_VALUE;
                else return Integer.MIN_VALUE;
            }
            else res = res_temp;
        }
        if(positive) return res;
        else return -res;
    }

}
