package com.leetcode.Search;

/**
 * @author liubi
 * @date 2019-09-08 09:27
 **/
public class BinarySearch {
    /**
     * 二分查找 上界 有序数组 升序
     *
     * @param data
     * @return 值的index ，若不存在 返回 -1
     */
    public static int find(int[] data, int target) {
        // 二分 只能用在有序情况
        if (data == null || data.length == 0) {
            return -1;
        }
        int low = 0;
        int high = data.length;
        while (low < high) {
            int mid = low + (high - low) / 2;
            if (data[mid] > target) {
                // target 在 0-mid 中
                high = mid;
            } else if (data[mid] == target) {
                return mid;
            } else {
                // target 在 mid  - high中
                low = mid + 1;
            }
        }
        return data[low] == target ? low : -1;
    }
}
