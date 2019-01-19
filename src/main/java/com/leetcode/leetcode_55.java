package com.leetcode;

import java.util.ArrayList;

public class leetcode_55 {
    public boolean canJump(int[] nums) {
        // 动态规划问题：第n步可到达的状态为r(n) 那么如果 从之前任意一步 可以到达 第n步 那么 第n步 可达，
        // 判断 任意一个位置是否可以到达另一个位置 1. 该位置可以到达 2. 该位置的可以走的步数 >= 该位置到另一个位置的距离
        ArrayList<Boolean> result = new ArrayList<>();
        //result.add(false); // make index the same with actual position
        result.add(true); // the first point is always reachable
        for(int i=2 ; i<=nums.length;i++){
            boolean reachable = false;
            for(int j=1;j<i;j++){
                if(result.get(j-1)&&(nums[j-1]>=i-j)){
                    reachable = true;
                    break;
                }
            }
            result.add(reachable);
        }
        return result.get(nums.length-1);
    }
    public static void main(String[] args) {
        leetcode_55 solution = new leetcode_55();
        int[] nums = {3,2,1,0,4};
        solution.canJump(nums);
    }
}
