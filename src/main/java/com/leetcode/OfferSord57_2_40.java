package com.leetcode;

import java.util.ArrayList;

/**
 * @author liubi
 * @date 2019-01-04 09:37
 **/
public class OfferSord57_2_40 {
    /**
     * 算法思想：
     * 时间复杂度 O（n2）
     * 根据公式 sum = （num1+num2）*（num2-num1+1）/2，先确定一个数字 根据公式 迭代计算另一个数字
     * @param sum
     * @return
     */
    public ArrayList<ArrayList<Integer>> FindContinuousSequence_1(int sum) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        for(int i = sum; i>1;i--){
            int residue = sum *2  - i*i +i;
            if(residue>0){
                if(residue%(2*i) == 0){
                    int start = residue/2/i;
                    ArrayList<Integer> continuousSequence = new ArrayList<>();
                    for(int j = 0;j<i;j++){
                        continuousSequence.add(j+start);
                    }
                    result.add(continuousSequence);
                }
            }
        }
        return result;
    }

    /**
     * 时间复杂度 O（n）
     * 算法分析：详见剑指offer书
     * @param targetSum
     * @return
     */
    public ArrayList<ArrayList<Integer>> FindContinuousSequence(int targetSum) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        int num1 = 1;
        int num2 = 2;
        int sum = num1 +num2;
        while(num1<(targetSum+1)/2){
            sum = (num1+num2)*(num2-num1+1)/2;
            if(sum == targetSum){
                ArrayList<Integer> currentRes = new ArrayList<>();
                for(int i=num1;i<num2+1;i++){
                    currentRes.add(i);
                }
                result.add(currentRes);
                num2++;
            }
            else if(sum<targetSum){
                num2++;
            }
            else if(sum>targetSum){
                num1++;
            }
        }
        return result;
    }
    public static void main(String[] args) {
        OfferSord57_2_40 solution = new OfferSord57_2_40();
        System.out.println(solution.FindContinuousSequence(3));
    }
}
