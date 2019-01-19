package com.leetcode;

public class leetcode_190 {
        // you need treat n as an unsigned value
        public int reverseBits(int n) {
            //return Integer.reverse(n); 调用java自带函数
            Long multiplier = 2147483648L; // 2的31次方
            Long number = Integer.toUnsignedLong(n);
            int res = 0;
            while(number>0){
                res += (number%2)*multiplier;
                multiplier >>= 1; // divide 2
                number /= 2;
            }
            return res;
        }

    public static void main(String[] args) {
        leetcode_190 solution = new leetcode_190();
    }
}
