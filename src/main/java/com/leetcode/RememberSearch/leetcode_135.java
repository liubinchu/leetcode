package com.leetcode.RememberSearch;

import java.util.Arrays;

/**
 * @author liubi
 * @date 2019-09-11 13:41
 * 题解：https://blog.csdn.net/u010700335/article/details/44136339
 * 记忆化搜索
 **/
public class leetcode_135 {

    private int cal(int r, int[] ratings) {
        int[] state = new int[ratings.length];
        Arrays.fill(state, 0);
        if (state[r] > 0) {
            return state[r];
        } else {
            state[r] = 1; //  如果不受限制，最少分配一个
            if (r - 1 >= 0 && ratings[r - 1] < ratings[r]) {
                state[r] = Math.max(state[r], cal(r - 1, ratings) + 1);
            }
            if (r + 1 < ratings.length && ratings[r + 1] < ratings[r]) {
                state[r] = Math.max(state[r], cal(r + 1, ratings) + 1);
            }
            return state[r];
        }
    }

    public int candy(int[] ratings) {

        int sum = 0;
        for (int r = 0; r < ratings.length; r++) {
            sum += cal(r, ratings);
        }
        return sum;
    }

    public static void main(String[] args) {
        leetcode_135 so = new leetcode_135();
        System.out.println(so.candy(new int[]{1, 0, 2}));
    }

}
