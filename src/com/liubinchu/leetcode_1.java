package com.liubinchu;

import java.util.HashMap;
import java.util.Map;

public class leetcode_1 {
    //Two Sum
    public int[] twoSum(int[] nums, int target) {
        Map<Integer ,Integer> map = new HashMap<>();
        for (int i = 0 ; i< nums.length ; i++){
            int delt = target - nums[i];
            if (map.containsKey(delt) && map.get(delt)!=i)
                return new int[] {i,map.get(delt)};
            map.put(nums[i],i);
        }
        return null;
    }
}
