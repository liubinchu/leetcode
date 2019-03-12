package com.leetcode;

/**
 * @author liubi
 * @date 2019-03-12 21:23
 **/
public class YuanJing01 {
    public String ReverseSentence1(String str) {
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
    public String ReverseSentence(String str) {
        // 很神奇 一样的思路 在考的时候 竟然报错， 可能还是紧张的问题
        String[] strings = str.split(" ");
        if(strings.length==0){
            return str;
        }
        else {
            StringBuilder sb = new StringBuilder();
            for(int i=0;i<strings.length-1;i++){
                sb.append(strings[strings.length-i-1]);
                sb.append(" ");
            }
            sb.append(strings[0]);
            return sb.toString();
        }
    }
    public static void main(String[] args) {
        String string = "i am a student.";
        YuanJing01 solution = new YuanJing01();
        System.out.println(solution.ReverseSentence(string));
    }
}
