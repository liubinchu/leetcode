package com.leetcode;

/**
 * @author liubi
 * @date 2019-01-07 14:36
 **/
public class OfferSord64_46 {
    /**
     * 算法分析： 三种常规解法：1. 公式2. 循环 3.递归
     * 限制条件不能用 1.乘除 2. for while 3. 条件判断 if else
     * 那么 上述三种就都不能用
     * 实际上 要做的就是用奇巧淫技 代替 乘除，循环 条件判断
     * https://www.nowcoder.com/questionTerminal/7a0da8fc483247ff8800059e12d7caf1
     * 方法非常多
     * @param n
     * @return
     */
    public int Sum_Solution(int n) {
        // 利用逻辑运算的短路特性代替if else 实现递归版本
        // 前半部分 false 时 后半部分不进行运算
        int res = n;
        boolean flag = (res!=0) && (((res+=Sum_Solution(n-1)))==0);
        return res;
    }
    public int Sum_Solution1(int n) {
        //利用sizeof + 二维数组 替代乘法，用一位替代 /2
        // 利用公式计算
        int res= 0;
        boolean[][] array= new boolean[n][n+1];
        // res = sizeof(array)>>1;
        // C++ 中
        return res;
    }
    public int Sum_Solution2(int n) {
        //用异常退出递归
        try {
            int i = 1%n;
            return n+Sum_Solution2(n-1);
        }catch (Exception e){
            return 0;
        }
    }
    public static void main(String[] args) {
        OfferSord64_46 solution = new OfferSord64_46();
        System.out.println(solution.Sum_Solution2(100));
    }
}
