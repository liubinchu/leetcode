package com.leetcode;

/**
 * @author liubi
 * @date 2019-01-07 09:15
 **/
public class OfferSord58_2_41 {
    /**
     * 算法分析：时间复杂度O（1） 空间复杂度 O（1）
     * @param str
     * @param n
     * @return
     */
    public String LeftRotateString(String str,int n) {
        if(str.length() == 0){
            n = 0;
        }
        else {
            n = n% str.length();
        }
        StringBuilder stringBuilder = new StringBuilder(str.substring(n));
        stringBuilder.append(str.substring(0,n)); // 其中 0-n 的范围 是 [0,n) 0在新的字符串中， n 不在新的字符串中， 左闭右开区间看来是默认情况
        return stringBuilder.toString();
    }
    public static void main(String[] args) {
        OfferSord58_2_41 solution = new OfferSord58_2_41();
        System.out.println(solution.LeftRotateString("abcXYZdef",3));
    }
}
