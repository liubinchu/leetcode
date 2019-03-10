package com.leetcode;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

/**
 * @author liubi
 * @date 2019-03-09 21:06
 **/
public class tengxunMar09_04 {
    public static void main(String[] args) {
        //Scanner in = new Scanner(System.in);

        //while (in.hasNextInt()) {//注意while处理多个case
            //int n = in.nextInt();
            //int m = in.nextInt();
        int n = 12;
        int m = 5;
            int min = Integer.MAX_VALUE;
            int count = 0;
            Set<Integer> ball = new HashSet<>();
            int[] data = {2,5,3,1,3,2,4,1,0,5,4,3};
            for (int i = 0; i < n; i++) {
                //int current = in.nextInt();
                int current = data[i];
                if (current != 0) {
                    count++;
                    ball.add(current);

                } else {
                    count = 0;
                }
                if (ball.size() == m && count < min) {
                    min = count;
                }
            }
            System.out.println(min);
        //}
    }
}
