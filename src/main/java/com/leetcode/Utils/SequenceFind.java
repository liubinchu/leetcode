package com.leetcode.Utils;

/**
 * @author liubi
 * @date 2019-09-08 10:40
 **/
public class SequenceFind {
    public static int find(int[] array,int target) {
        if (array == null || array.length == 0) {
            return -1;
        } else {
            for (int i = 0; i < array.length; i++) {
                if (array[i] == target) {
                    return i;
                }
            }
            return -1;
        }
    }
}
