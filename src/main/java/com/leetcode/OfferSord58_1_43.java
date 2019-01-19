package com.leetcode;

/**
 * @author liubi
 * @date 2019-01-07 09:51
 **/
public class OfferSord58_1_43 {
    /**
     * 算法分析：
     * 基本思路是两次翻转
     * 先整体反转 再每个部分分别反转
     * @param str
     * @return
     */
    public String ReverseSentence(String str) {
        if(str.trim().length()==0){
            return str;
        }
        else {
            str = new StringBuilder(str).reverse().toString();
            StringBuilder stringBuilder = new StringBuilder();
            for (String s : str.split(" ")) {
                //System.out.println(s);
                stringBuilder.append(new StringBuilder(s).reverse());
                stringBuilder.append(" ");
            }
            stringBuilder.deleteCharAt(stringBuilder.length() - 1);
            //System.out.println(stringBuilder);
            return stringBuilder.toString();
        }
    }
    public static void main(String[] args) {
        OfferSord58_1_43 solution = new OfferSord58_1_43();
        solution.ReverseSentence(" ");
    }
}
