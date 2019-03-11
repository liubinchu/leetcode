package com.leetcode;

/**
 * @author liubi
 * @date 2019-03-09 20:03
 **/
public class tengxunMar09_02 {
    private int  fun(int start, int end) {
        int sum = 0;
        sum = (end - start+1) / 2;
        // 两两组合
        if(start%2==0){
            sum = -sum;
        }
        // 每个组合的结果
        int residue = (end - start+1) % 2;
        // 是否存在数子 不在组合中
        if (residue != 0) {
            int symbol = end % 2 == 0 ? 1 : -1;
            sum = sum + end * symbol;
            System.out.println(sum);
        }
        return sum;
    }
    public static void main(String[] args) {
        tengxunMar09_02 solusion = new tengxunMar09_02();
        solusion.fun(2,4);
    }
}

