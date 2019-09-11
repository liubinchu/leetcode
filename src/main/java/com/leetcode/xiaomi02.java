package com.leetcode;

import java.util.Scanner;

public class xiaomi02 {

    /*请完成下面这个函数，实现题目要求的功能
    当然，你也可以不按照下面这个模板来作答，完全按照自己的想法来 ^-^
    ******************************开始写代码******************************/
    static int solution(int[] arr) {
        sort(arr);
        return count;
    }

    /******************************结束写代码******************************/


    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int res;
        int _arr_size = 0;
        _arr_size = Integer.parseInt(in.nextLine().trim());
        int[] _arr = new int[_arr_size];
        int _arr_item;
        for (int _arr_i = 0; _arr_i < _arr_size; _arr_i++) {
            _arr_item = Integer.parseInt(in.nextLine().trim());
            _arr[_arr_i] = _arr_item;
        }

        res = solution(_arr);
        System.out.println(String.valueOf(res));

    }

    static int count = 0;

    private static void sort(int[] nums) {
        boolean finished = false;
        for (int i = nums.length - 1; i > 0 && !finished; i--) {
            finished = true;
            for (int j = 0; j < i; j++) {
                if (nums[j + 1] < nums[j]) {
                    finished = false;
                    count++;
                    {
                        nums[j] = nums[j] ^ nums[j + 1];
                        nums[j + 1] = nums[j + 1] ^ nums[j];
                        nums[j] = nums[j] ^ nums[j + 1];
                    }
                }
            }
        }
    }
}
