package com.leetcode;

import java.util.Arrays;

/**
 * @author liubi
 * @date 2019-01-07 10:39
 **/
public class OfferSord61_44 {
    /**
     * 算法思想：
     * 1. 排序
     * 2. 统计大小王（数字0）个数
     * 3. 计算相邻两数之间的间隔，用大小王替代
     * 4. 如果相邻两数相等，return false
     * 5. 最终如果大小王能够填补间隔/或有剩余 flag>= 0，那么则为顺子
     * 算法分析：时间复杂度 排序：O（nlogn）
     * 空间复杂度 O（1）
     * @param numbers
     * @return
     */
    public boolean isContinuous(int [] numbers) {
        if(numbers.length==0){
            return false;
        }
        else {
            Arrays.sort(numbers);
            int flag = 0;
            for(int i = 0;i<numbers.length-1;i++){
                if(numbers[i] == 0){
                    flag++;
                }
                else if(numbers[i]==numbers[i+1]){
                    return false;
                }
                else if (numbers[i]+1!=numbers[i+1]) {
                    flag -= (numbers[i+1]-numbers[i]-1);
                }
            }
            return flag>=0;
        }
    }
    public static void main(String[] args) {
        OfferSord61_44 solution = new OfferSord61_44();
        System.out.println(solution.isContinuous(new int[]{3,0,0,0,0}));
    }
}
