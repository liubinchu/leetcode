package com.leetcode;

import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Set;

/**
 * @author liubi
 * @date 2018-12-28 13:42
 **/
public class OfferSord56_1_39 {
    /**
     * @param array
     * @param num1 为长度为1的数组。传出参数
     * @param num2 为长度为1的数组。传出参数
     */
    public void FindNumsAppearOnce(int [] array,int num1[] , int num2[]) {
        Set<Integer> result = new LinkedHashSet<>();
        for(Integer number :array){
            if(result.contains(number)){
                result.remove(number);
            }
            else {
                result.add(number);
            }
        }
        if(result.size()!=2){
            throw new IllegalArgumentException("输入的元素中不止两个元素");
        }
        else{
            Iterator<Integer> it = result.iterator();
            num1[0] = it.next();
            num2[0] = it.next();
        }
    }
    public static void main(String[] args) {
        OfferSord56_1_39 solution = new OfferSord56_1_39();
        int[] data = {1,2,3,4,5,6,2,3,5};
        int[] num1 = new int[1];
        int[] num2 = new int[1];
        solution.FindNumsAppearOnce(data,num1,num2);
        System.out.println(num1[0]);
        System.out.println(num2[0]);
    }
}
