package com.leetcode;

/**
 * @author liubi
 * @date 2019-01-07 11:00
 **/
public class OfferSord62_45 {
    /**
     * 约瑟夫环问题，通过公式推导 的到递推公式 能够用递归或者循环解决
     * LastRemaining_SolutionRecersive 递归版本
     * LastRemaining_SolutionLoop 循环版本
     * @param n
     * @param m
     * @return
     */
    public int LastRemaining_SolutionRecersive(int n, int m) {
        if(n<1) {
            return -1;
        }
        else if(n==1){
            return 0;
        }
        else {
            return (LastRemaining_SolutionRecersive(n-1,m)+ m)%n;
        }
    }
    public int LastRemaining_SolutionLoop(int n, int m) {
        if(n<1) {
            return -1;
        }
        else if(n==1){
            return 0;
        }
        else {
            int currentRes= 0; // init with result of n==1
            int formerRes = (currentRes+m)%2; // init with result of n==2
            for(int r=3 ;r<n+1;r++){
                currentRes = (formerRes+m)%r;
                formerRes = currentRes;
            }
            return currentRes;
        }
    }
    public static void main(String[] args) {
        OfferSord62_45 solution = new OfferSord62_45();
    }
}
