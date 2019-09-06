package com.leetcode;

import java.util.Arrays;

public class laohu02 {
    public int partition(int[] nums, int l, int h) {
        int i = l, j = h + 1;
        int v = nums[l];
        while (true) {
            while ((nums[++i] < v )&& i != h) ;
            while ((v < nums[--j]) && j != l) ;
            if (i >= j) {
                break;
            }
            nums[i] = nums[i] ^ nums[j];
            nums[j] = nums[i] ^ nums[j];
            nums[i] = nums[i] ^ nums[j];
        }
        nums[l] = nums[l] ^ nums[j];
        nums[j] = nums[l] ^ nums[j];
        nums[l] = nums[l] ^ nums[j];
        return j;
    }

    public int[] selectTopKByPartition(int[] nums, int k) {
        int l = 0, h = nums.length - 1;
        while (h > l) {
            int j = partition(nums, l, h);
            if (j == k) {
                return Arrays.copyOfRange(nums,0,k+1);
            } else if (j > k) {
                h = j - 1;
            } else {
                l = j + 1;
            }
        }
        return Arrays.copyOfRange(nums,0,k+1);
    }
}
