package com.leetcode;

import java.util.HashSet;
import java.util.Set;

/**
 * @author liubi
 * @date 2018-12-27 20:25
 **/
public class OfferSord03_49 {
    /**
     *
     * @param numbers an array of integers
     * @param length the length of array numbers
     * @param duplication (Output) the duplicated number in the array number,length of duplication array is 1,so using duplication[0] = ? in implementation;
     *     //                  Here duplication like pointor in C/C++, duplication[0] equal *duplication in C/C++
     *     //    这里要特别注意~返回任意重复的一个，赋值duplication[0]
     * @return
     */
    public boolean duplicate1(int numbers[],int length,int [] duplication) {
        if(numbers==null || numbers.length == 0){
            duplication[0] =-1;
            return false;
        }
        else {
            boolean hasDuplication = false;
            Set<Integer> numbersNoDup = new HashSet<>();
            for(int num : numbers){
                if(numbersNoDup.contains(num)){
                    hasDuplication = true;
                    duplication[0] = num;
                    break;
                }
                else {
                    numbersNoDup.add(num);
                }
            }
            return hasDuplication;
        }
    }

    /**
     * 算法分析： 时间复杂度O（n） 空间复杂度O（1）
     * 利用条件：    在一个长度为n的数组里的所有数字都在0到n-1的范围内
     * 将数组的下标 替代 上一种写法的 Set
     * @param numbers
     * @param length
     * @param duplication
     * @return
     */
    public boolean duplicate(int numbers[],int length,int [] duplication) {
        boolean hasDup = false;
        if(numbers==null || numbers.length == 0){
            duplication[0] = -1;
            return false;
        }
        else {
            for(int i=0;i<numbers.length ;i++){
                int num ;
                if(numbers[i]<0){
                    num = - numbers[i];
                }
                else{
                    num = numbers[i];
                }
                if(num>=numbers.length){
                    duplication[0] = -1;
                    hasDup = false;
                    break;
                }
                else if(numbers[num]<0){
                    hasDup = true;
                    duplication[0] = num;
                    break;
                }
                else {
                    numbers[num] *= -1;
                }
            }
            return hasDup;
        }
    }
    public static void main(String[] args) {
        OfferSord03_49 solution = new OfferSord03_49();
        int[] numbers = {2,1,3,1,4};
        int[] dup = new int[1];
        solution.duplicate(numbers,numbers.length,dup);
        System.out.println(dup[0]);
    }
}
