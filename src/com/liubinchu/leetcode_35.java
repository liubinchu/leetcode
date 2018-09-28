package com.liubinchu;

public class leetcode_35 {
    public int searchInsert(int[] nums, int target) {
        int low = 0;
        int high = nums.length-1;
        int mid = (low + high) /2;
        while(high > low){
            if(nums[mid] == target) return mid;
            else if (nums[mid]<target) {
                low = mid +1;
            }
            else if (nums[mid]>target){
                high = mid -1;
            }
            mid = (low + high) /2 ;
        }
        if (nums[mid] < target) return mid+1;
        else return mid ;
    }
}
