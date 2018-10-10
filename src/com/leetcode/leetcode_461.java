package com.leetcode;

public class leetcode_461 {
    // 思想： 经过观察，发现两个数 按位异或之后 二进制数中 1的个数 就是距离
        public int hammingDistance(int x, int y) {
            Long x_long = Integer.toUnsignedLong(x);
            Long y_long = Integer.toUnsignedLong(y);
            Long xor_res = x_long ^ y_long;
            int distance = 0;
            while(xor_res>0){
                distance += xor_res%2;
                xor_res /= 2;
            }
            return distance;
        }

    public static void main(String[] args) {
            leetcode_461 solution = new leetcode_461();
            Long res= 1L;
            for(int i =0;i <31;i++){
                res *=2;
            }
            //res >>=1;
        int num = 2147483647;
            Long n1 = 2147483648L;
            num+=1;
            System.out.println(n1);
    }
}
