package com.leetcode;

public class leetcode_268 {
        // 缺失值的位置可以分为三种 1. 缺失值为最小值 题目规定始终为0 2. 缺失值为最大值 3. 缺失值在中间
        // 缺失值在中间是最普遍的情况 思路为 1. 通过找出最大值，且最小值确定 可以确定没有缺失值的情况下的理想和 idealSum
        // 计算实际上的数组元素和 sum 两者相减为缺失值
        // 经过分析 缺失值 为0 是 上述方法正确
        // 缺失值 为 最大值是 计算出的假设缺失值 为 max/2 (缺失值位置在中间时可以为max/2)
        // 判断缺失值位置是否在最后：通过 遍历数组元素 如果计算得到的缺失值 出现在数组中 则计算得到的缺失值不是真实缺失值
        public int missingNumber(int[] nums) {
            int max = 0;
            int sum =0;
            for(int i =0 ;i<nums.length ;i++){
                if(nums[i]>max) max = nums[i];
                sum += nums[i];
            }
            int idealSum = (max+0)*(nums.length+1)/2;
            int res = idealSum - sum;

            // 缺失值为最大值的情况
            boolean finded = false;
            for(int i =0 ;i<nums.length ;i++){
                if(nums[i]==res) {
                    finded = true;
                    break;
                }
            }
            if(finded) return max+1;
            else return res;
        }

    public static void main(String[] args) {
        leetcode_268 solution = new leetcode_268();
        int[] nums = {3,0,1};
        solution.missingNumber(nums);
    }
}
