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
    public void FindNumsAppearOnce_1(int [] array,int num1[] , int num2[]) {
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

    /**
     * 算法分析： 上面的方法， 利用到了set，空间换时间， 如果要求空间复杂度O（1） 时间复杂度O（n）那么需要利用到异或运算的一个性质：两个相同的数异或 为0
     * 那么 如果数组序列中只存在一个数出现次数为单数 其余数字出现次数为双数，那么 将数组中的数字 累积异或，最后的值就是 出现次数为单数 的那个数字
     * 本题中 只存在两个  数出现次数为单数 （有一个非常明显的暗示，这种情况 可以由 上面的情况 /只存在一个数出现次数为单数/ 拓展， 如果 题目描述 中 不知两个 那么拓展起来很麻烦）
     * 存在两个  数出现次数为单数时，数组中数字累积异或的结果 等价于 要求的两个数异或的结果，得到的数字 是 num1 和 num2 不同位数字组合的结果，根据这个数字 可以将数组分成两个部分
     * 将累积异或结果的二进制的第一个1 作为seperator
     * 累积异或的结果 能够将数组分为两个部分 因为满足
     *  1. 他将num1 和 num2 分到两个不同的部分
     *  2. 其余的数字，相同的数字 肯定分到同一个部分， 比如 两个5，异或同一个数 seperator的结果肯定相同
     *  详见 剑指Offer书 276
     * @param array
     * @param num1 为长度为1的数组。传出参数
     * @param num2 为长度为1的数组。传出参数
     */
    public void FindNumsAppearOnce(int [] array,int num1[] , int num2[]) {
        switch (array.length){
            case 0:
                return;
            case 1:
                num1[0] = array[0];
                return;
            case 2:
                if(array[0] == array[1]){
                    throw new IllegalArgumentException("唯二的两个数相同");
                }
                else {
                    num1[0] = array[0];
                    num2[0] = array[1];
                    return;
                }
            default:
                Integer XORSum = array[0];
                for(int i=1;i<array.length;i++){
                    XORSum ^= array[i];
                }
                int seprator = Integer.highestOneBit(XORSum);
                Boolean num1Init = false;
                Boolean num2Init = false;
                for(int i = 0;i<array.length;i++){
                   if((seprator & array[i]) == 0){
                       if(!num1Init){
                           num1Init = true;
                           num1[0] = array[i];
                       }
                       else {
                           num1[0] ^= array[i];
                       }
                   }
                   else {
                       if(!num2Init){
                           num2Init = true;
                           num2[0] = array[i];
                       }
                       else {
                           num2[0] ^= array[i];
                       }
                   }
                }
        }
    }
    public static void main(String[] args) {
        OfferSord56_1_39 solution = new OfferSord56_1_39();
        int[] data = {2,4,3,6,3,2,5,5};
        int[] num1 = new int[1];
        int[] num2 = new int[1];
        solution.FindNumsAppearOnce(data,num1,num2);
        System.out.println(num1[0]);
        System.out.println(num2[0]);
    }
}
