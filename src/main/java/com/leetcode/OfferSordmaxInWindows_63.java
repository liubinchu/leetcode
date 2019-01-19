package com.leetcode;

import java.util.ArrayList;

/**
 * @author liubi
 * @date 2019-01-12 19:49
 **/
public class OfferSordmaxInWindows_63 {
    public ArrayList<Integer> maxInWindows(int[] nums, int size) {
        ArrayList<Integer> result = new ArrayList<>();
        if (nums != null && size != 0 && nums.length >= size) {
            int currentRes = Integer.MIN_VALUE;
            int currentIndex = -1;
            for (int i = 0; i < size; i++) {
                if (nums[i] >= currentRes) {
                    currentRes = nums[i];
                    currentIndex = i;
                }
            }
            result.add(currentRes);
            for (int i = size; i < nums.length; i++) {
                if (currentIndex > i - size) {
                    // currentRes still in maxWindow
                    if (nums[i] >= currentRes) {
                        currentRes = nums[i];
                        currentIndex = i;
                    }
                } else {
                    currentRes = Integer.MIN_VALUE;
                    for (int j = i - size + 1; j < i + 1; j++) {
                        if (nums[j] > currentRes) {
                            currentRes = nums[j];
                        }
                    }
                }
                result.add(currentRes);
            }
        }
        return result;
    }

    public static void main(String[] args) {
        OfferSordmaxInWindows_63 solution = new OfferSordmaxInWindows_63();
        int[] numbers = {2, 3, 4, 2, 6, 2, 5, 1};
        System.out.println(solution.maxInWindows(numbers, 3));
    }
}
