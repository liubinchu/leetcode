package com.leetcode.RememberSearch;

import java.util.Arrays;
import java.util.Scanner;

public class tongcheng58_02 {
    private static int[] state;

    private static int cal(int r, int[] ratings) {
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

    public static int fun(int[] ratings) {
        state = new int[ratings.length];
        Arrays.fill(state, 0);
        int sum = 0;
        for (int r = 0; r < ratings.length; r++) {
            sum += cal(r, ratings);
        }
        return sum;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] rating = new int[sc.nextInt()];
        for (int i = 0; i < rating.length; i++) {
            rating[i] = sc.nextInt();
        }
        System.out.println(fun(rating));
    }
}
