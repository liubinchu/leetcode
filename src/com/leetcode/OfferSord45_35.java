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
