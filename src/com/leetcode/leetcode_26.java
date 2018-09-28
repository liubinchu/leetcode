package com.leetcode;

public class leetcode_26 {
//从排序数组中删除重复项
    public int removeDuplicates(int[] nums) {
        int index = 0;
        for (int i=1 ; i<nums.length; i++){
            if( nums[i] != nums[index]){
                index++;
                nums[index] = nums[i];
            }
        }
        return index+1;
    }
}
