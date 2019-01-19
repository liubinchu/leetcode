package com.leetcode;

/**
 * @author liubi
 * @date 2019-01-08 12:35
 **/
public class OfferSord19_51 {
    /**
     * 算法思想：见剑指offer 实际上是 NFA 非确定有限状态自动机
     */
    private char[] str ;
    private char[] pattern ;
    public boolean match(char[] str, char[] pattern)
    {
        if(str==null||pattern==null){
            return false;
        }
        else{
            this.pattern = pattern;
            this.str = str;
            return NFA(0,0);
        }
    }
    private boolean NFA(int strIndex, int patternIndex){
        if(strIndex==str.length&&patternIndex==pattern.length){
            return true;
        }
        else if(strIndex==str.length&&patternIndex<pattern.length){
            if(patternIndex+2==pattern.length && pattern[patternIndex+1] =='*'){
                return true;
            }
            else {
                return false;
            }
        }
        else if(strIndex<str.length&&patternIndex==pattern.length){
            return false;
        }
        char ch = str[strIndex];
        char pa = pattern[patternIndex];
        boolean anyAmount = false;
        if(patternIndex+1<pattern.length && pattern[patternIndex+1] =='*'){
            anyAmount = true;
        }
        if(!anyAmount){
            if(ch==pa||pa == '.'){
                return NFA(strIndex+1,patternIndex+1);
            }
            else {
                return false;
            }
        }
        else {
            // anyAmount == true
            if(ch==pa||pa == '.'){
                return NFA(strIndex,patternIndex+2)||
                        NFA(strIndex+1,patternIndex+2)||
                        NFA(strIndex+1,patternIndex);
            }
            else {
                return NFA(strIndex,patternIndex+2);
            }
        }
    }
    public static void main(String[] args) {
        OfferSord19_51 solution = new OfferSord19_51();
        char[] str = {};
        char[] pattern = {'.','*'};
        System.out.println(solution.match(str,pattern));
    }
}
