package com.leetcode;
import java.lang.Math;
public class leetcode_326 {
    // 最朴素的想法
    /*
    public boolean isPowerOfThree(int n) {
        if(n<=0) return false;
        if(n == 1 ) return true;
        while(n>1){
            if(n%3 != 0) return false;
            else n/=3;
        }
        return true;
    }
    */
    // solution 中看到的一个巧妙的办法
    //1. 因为计算机中的数字是有范围的 最大的三的倍数%任何小于它的三的倍数 == 0
    public boolean isPowerOfThree(int n){
        int maxBeiShu = (int) (Math.log(Integer.MAX_VALUE)/Math.log(3));
        int maxValue = (int) Math.pow(3,maxBeiShu);
        if(n>0 && maxValue%n==0) return true;
        else return false;
    }

    public static void main(String[] args) {
        leetcode_326 solution = new leetcode_326();
    }
}
