package com.leetcode;

/**
 * @author liubi
 * @date 2019-03-09 20:03
 **/
public class tengxunMar09_02 {
    private void fun(int start, int end) {
        int sum = 0;
        sum = (end - start+1) / 2;
        if(start%2==0){
            sum = -sum;
        }
        int residue = (end - start+1) % 2;
        if (residue == 0) {
            System.out.println(sum);
        } else {
            int num1 = end;
            int num2 = end % 2 == 0 ? 1 : -1;
            sum = sum + num1 * num2;
            System.out.println(sum);
        }
    }
    public static void main(String[] args) {
        tengxunMar09_02 solusion = new tengxunMar09_02();
        solusion.fun(2,4);
    }
}

