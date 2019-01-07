package com.leetcode;

/**
 * @author liubi
 * @date 2019-01-07 15:45
 **/
public class OfferSord65_47 {
    /**
     * 算法分析：简单来说就是实现累加器（显然是利用位运算）
     * @param num1
     * @param num2
     * @return
     */
    public int Add(int num1,int num2) {
        int sum = num1;
        int carry = num2;
        int currentSum = num1;
        while (carry!=0){
            currentSum = sum^carry;
            carry = (sum&carry)<<1;
            sum = currentSum;
        }
        return sum;
    }
    public static void main(String[] args) {
        OfferSord65_47 solution = new OfferSord65_47();
        System.out.println("7&11   "+(Integer)(7&11));
        solution.Add(0,2);
        for(int num1 = 0;num1<1000000000;num1++){
            for (int num2 =0;num2<100000000;num2++){
                if(solution.Add(num1,num2)!=num1+num2){
                    System.out.println("Error");
                }
            }
        }
        System.out.println("finish");
    }
}
