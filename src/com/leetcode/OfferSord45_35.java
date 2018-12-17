package com.leetcode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * @author liubi
 * @date 2018-12-16 21:59
 **/
class IntegerStringOrderCMP implements Comparator<Integer>{
    @Override
    public int compare(Integer o1, Integer o2) {
        char[] s1 = (o1.toString()+o2.toString()).toCharArray();
        char[] s2 = (o2.toString()+o1.toString()).toCharArray();
        for(int i=0;i<s1.length;i++){
            if(s1[i]>s2[i]){
                return 1;
            }
            else if(s1[i]<s2[i]){
                return -1;
            }
        }
        return 0; // 完全相等
    }
}

/**
 * 题解: 1. 对于两个数字，其两种排列情况 长度都相等， 对于多个数字， 其所有排列的总长度也相等，
 * 因此对于多个数字进行排列 求的最小值的过程 可以 退化成 将数字两两按照组合成的最小值进行排序。（两两排序的结果 能够得到多个数字排序最小值 需要证明 自反性，对称性，以及传递性）
 * 2. 如果两个数字的拼接 结果 超过 int/long 范围， 如果使用 double 会损失精度，一个常用的做法 是比较其字符串中的字符顺序（！！实用！！）
 */
public class OfferSord45_35 {
    public String PrintMinNumber(int [] numbers) {
        StringBuilder stringBuilder = new StringBuilder();
        IntegerStringOrderCMP cmp = new IntegerStringOrderCMP();
        List<Integer> nums = new ArrayList<>();
        for(int n: numbers){
            nums.add(n);
        }
        Collections.sort(nums,cmp);
        for(Integer n: nums){
            stringBuilder.append(n);
        }
        return stringBuilder.toString();
    }

    public static void main(String[] args) {
        OfferSord45_35 solution = new OfferSord45_35();
        int[] nums = {3,32,321};
        System.out.println(solution.PrintMinNumber(nums));
    }
}
