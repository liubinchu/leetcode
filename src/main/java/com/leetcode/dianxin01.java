package com.leetcode;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class dianxin01 {
    public static void main(String[] args) {
/*        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        int[] nums = new int[num];
                for (int i = 0; i < num; i++) {
            nums[i] = sc.nextInt();
        }
        */
        int num = 5;
        int[] nums = new int[]{4, 5, 1, 2, 3};
        Arrays.sort(nums);
        int index;
        if ((num & 1) == 0) {
            index = (int) (num / 2) - 1;
        } else {
            index = (int) (num / 2);
        }
        System.out.println(nums[index]);
    }
}
