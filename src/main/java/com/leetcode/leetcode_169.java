package com.leetcode;

/**
 * @author liubi
 * @date 2019-05-14 20:21
 **/
public class leetcode_169 {
    public int majorityElement(int[] nums) {
        if(nums==null||nums.length==0){
            return Integer.MIN_VALUE;
        }
        int curr = Integer.MAX_VALUE;
        int count = 0;
        for(int num : nums){
            if(count==0){
                curr = num;
                count++;
            }
            else if (curr==num) {
                count++;
            }
            else if (curr!=num){
                count--;
            }
        }
        return curr;
    }
    public static void main(String[] args) {

        leetcode_169 solution = new leetcode_169();
    }
}
