package com.leetcode;

import java.util.Random;

/**
 * @author liubi
 * @date 2019-03-11 22:37
 **/
public class InterviewTengXun01 {
    private int seed ;
    private int mutiplayer = 16807 ;// 7^5 该取值能够满足 全周期，随机性，32位运算器能实现三个特点
    private int range ;
    public void setSeed(int seed) {
        this.seed = seed;
    }

    public void setRange(int range) {
        this.range = range;
    }

    public int next(){
        int res = (mutiplayer*seed)%range;
        seed = res;
        return res;
    }
    public static void main(String[] args) {
        InterviewTengXun01 solution = new InterviewTengXun01();
        solution.setSeed(1);
        solution.setRange(10);
        for(int i=0;i<10;i++){
            System.out.println(solution.next());
        }
        Random random = new Random();
        random.nextInt();
         final long multiplier = 0x5DEECE66DL;
         final long addend = 0xBL;
        final long mask = (1L << 48) - 1;
        System.out.println(multiplier);
        System.out.println(addend);
        System.out.println(mask);
    }
}
