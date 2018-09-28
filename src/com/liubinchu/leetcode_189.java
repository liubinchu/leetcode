package com.liubinchu;

public class leetcode_189 {
    public void reverse(int[] nums, int i, int j){
        int temp;
        while (i<j){
            temp = nums[i];
            nums[i] = nums[j];
            nums[j] = temp;
            i++;
            j--;
        }
    }
    public void rotate(int[] nums, int k) {
        k %= nums.length;
        reverse(nums,0,nums.length-1);
        // 若向左翻转 k = nums.length - k;
        reverse(nums,0,k-1);
        reverse(nums,k,nums.length-1);
    }
}
