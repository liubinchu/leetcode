package com.leetcode;

public class leetcode_27 {
    public int removeElement(int[] nums, int val) {
        int n = nums.length;
        for(int i=0; i<n; i++){
            if(nums[i] == val){
                nums[i] = nums[n-1];
                n--;
                i--;// 被交换过去的元素 可能 == val 因此 需要检查两遍
                if(n==0) return n;
            }
        }
        return n;
    }
}
