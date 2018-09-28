package com.leetcode;

import java.util.HashSet;
import java.util.Set;

public class leetcode_217 {
    public boolean containsDuplicate(int[] nums) {
        Set nums_set = new HashSet();
        for (int num : nums){
            if (!nums_set.add(num)) return true;
        }
        return false;
    }
}
