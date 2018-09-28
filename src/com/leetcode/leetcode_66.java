package com.leetcode;

public class leetcode_66 {
    public int[] plusOne(int[] digits) {
        int carry = 0; //表示进位
        digits[digits.length-1]+= 1;
        for (int i = digits.length-1; i>=0; i--){
            digits[i]+= carry;
            carry =0 ;
            if(digits[i]>9){
                carry = digits[i] / 10;
                digits[i] %= 10;
            }
        }
        if (carry == 0) return digits; // 如果最高为 没有进位 无需添加数组元素
        else{
            int[] new_digits = new int[digits.length+1];
            new_digits[0] = carry;
            for(int i = 1;i<new_digits.length;i++){
                new_digits[i] = digits[i-1];
            }
            return new_digits;
        }
    }
}
