package com.leetcode;

/**
 * @author liubi
 * @date 2018-11-27 20:02
 **/
public class OfferSord15_10 {
    /**
     * 算法分析：按位操作 复杂度O（n）
     * n = 从做开始， 第一个1 出现的位置 至最后
     * 如 0110 则 n =3
     * @param n
     * @return
     */
    public int NumberOf1_1(int n) {
        int res = 0;
        int number = n;
        while(number!=0){
            if((number & 1) != 0){
                // 使用位运算 代替 模运算 number%2
                res++;
            }
            number = number & (~1);
            number = number >>>1;
        }
        return res;
    }

    /**
     * 在c++ 等语言中 如果没有 >>> 无符号右移 上面算法 失效
     * 下面算法 用掩码的左移代替 待求数的右移
     * O(n) n=32
     * @param n
     * @return
     */
    public int NumberOf1_2(int n) {
        int res = 0;
        int number = n;
        int mask = 1;
        for(int i =0;i<32 ;i++,mask<<=1){
            if((number & mask)!=0){
                res++;
            }
        }
        return  res;
    }

    /**
     * 算法分析： 上述算法 复杂度固定为O（32） 可以改进
     * 对于一个数 n = 1001 或者 1100
     * n-1 后 变为 1000 或者 1011
     * 也就是 从右起第一个1以及以后的位 都反转了
     * 那么 n&（n-1） 则 将最右的一个1 变为0
     * @param n
     * @return
     */
    public int NumberOf1_3(int n) {
        int res = 0;
        int number = n;
        while(number!=0){
            number = number&(number-1);
            res++;
        }
        return  res;
    }
    public static void main(String[] args) {
        OfferSord15_10 solution = new OfferSord15_10();
        System.out.println(solution.NumberOf1_3(10));
    }
}
