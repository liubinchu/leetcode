package com.leetcode;

public class leetcode_283 {
    // 可以看成是 排序问题 将 0 看作是 最大的元素 那么 就是将最大的元素 排到后面， 其他元素 不参与排序 相对位置不变
// 因此 利用冒泡排序的思想 将 0 元素 交换至最后面
    public void moveZeroes(int[] nums) {
        for(int i=0 ;i<nums.length; i++){ // 共检查 nums.length 次
            int j ;
            int count =0; // 记录已经交换至末尾的个数
            for (j = 0; j<nums.length-1;j++){ // 找到 第一个 0 元素位置
                if(nums[j] == 0) break;
                else continue;
            }
            for(; j<nums.length-1-count;j++){ // 交换
                if(nums[j+1] == 0) continue;
                else{
                    int temp = nums[j];
                    nums[j] = nums[j+1];
                    nums[j+1] = temp;
                }
            }
        }
    }
}
