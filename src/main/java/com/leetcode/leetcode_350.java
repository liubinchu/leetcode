package com.leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class leetcode_350 {
    public int[] intersect(int[] nums1, int[] nums2) {
        List<Integer> res = new ArrayList<>();
        Map<Integer, Integer> nums1_map = new HashMap<Integer ,Integer>();
        for(int i =0 ; i<nums1.length ;i++){
            if(nums1_map.containsKey(nums1[i])) {
                int count = nums1_map.get(nums1[i])+1;
                //nums1_map.remove(nums1[i]);
                nums1_map.put(nums1[i], count);
            }
            else {
                nums1_map.put(nums1[i], 1);
            }
        }
        for(int i = 0 ; i<nums2.length ; i++){
            if((nums1_map.containsKey(nums2[i]))&&((nums1_map.get(nums2[i]))!=0)){
                res.add(nums2[i]);
                int count = nums1_map.get(nums2[i])-1;
                //nums1_map.remove(nums1[i]);
                nums1_map.put(nums2[i], count);
            }
        }

        int[] result = new int[res.size()];
        for(int i =0;i<res.size();i++){
            result[i]= res.get(i);
        }
        return result;
    }
}
