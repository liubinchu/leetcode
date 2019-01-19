package com.leetcode;

public class leetcode_38 {
    public String count_say_once(String input){
        // 传入的String 至少两位
        int n = input.length();
        StringBuilder output = new StringBuilder();
        int counter = 0;
        int i = 0;
        for(;i< n-1;i++){
            if(input.charAt(i)!= input.charAt(i+1)){
                counter++;
                output.append(counter);
                output.append(input.charAt(i));
                counter = 0;
            }
            else counter++ ;
        }
        // 判断最后一个元素
        if(input.charAt(i) != input.charAt(i-1)){
            output.append(1);
        }
        else {
            counter++;
            output.append(counter);
        }
        output.append(input.charAt(i));
        return output.toString();
    }
    public String countAndSay(int n) {
        String output = "11";
        if(n ==1) return "1" ;
        else if(n ==2) return output;
        n--;
        while( --n > 0){
            output = count_say_once(output);
        }
        return output;
    }
}
