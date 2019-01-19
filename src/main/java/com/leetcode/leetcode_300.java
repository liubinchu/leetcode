package com.leetcode;

import javax.swing.text.Position;
import java.util.ArrayList;

public class leetcode_300 {

    public int lengthOfLIS (int [] nums){
        if(nums.length == 0) return 0;
        ArrayList<Integer> res = new ArrayList<>();
        res.add(1); // represent condition of length == 1
        int maxLen = 1;
        for(int i=1 ;i<nums.length ; i++){ // start with condition : length == 2
            int currentNum = nums[i];
            int positionJ = -1;
            for(int j=0 ; j<i;j++){
                if(positionJ == -1 && nums[j]<currentNum)  positionJ = j;
                if(positionJ != -1 && res.get(j)>res.get(positionJ) &&  nums[j]<currentNum) positionJ = j;
                // 以当前位置元素为 作为上升子序列的最后一个元素 的子序列中 最长的长度 记为res(i）
                // 首先找到 之前序列中 res最大的子序列res.get(j)>res.get(positionJ)
                //并且当前元素 能够添加到该序列中nums[j]<currentNum)
            }
            int currentLen;
            if(positionJ ==-1)
                currentLen =1;
            else
                currentLen = res.get(positionJ)+1;
            res.add(currentLen);

            if (currentLen >maxLen)
                maxLen = currentLen;
        }
        return maxLen;
    }

    public static void main(String[] args) {
        leetcode_300 solution = new leetcode_300();
        int[] input = {10,9,2,5,3,7,101,18};
        System.out.println(solution.lengthOfLIS(input));
    }
}
