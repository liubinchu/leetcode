package com.leetcode;


public class leetcode_191 {
    // you need to treat n as an unsigned value
    public int hammingWeight(int n) {
        // java 自带函数 return Integer.bitCount(n);
        // java 没有无符号数类型 对于负数 需要看作无符号的正数 将其转换为空间更大的long
        Long number;
        number= Integer.toUnsignedLong(n);

        int weight = 0;
        while(number>0){
            weight += number%2;
            number /= 2;
        }
        return weight;
    }
    public static void main(String[] args) {
        leetcode_191 solution = new leetcode_191();
    }
}
