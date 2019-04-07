package com.leetcode;

import java.util.LinkedList;

/**
 * @author liubi
 * @date 2019-04-07 20:35
 **/
public class xukun02 {
    public static int fun(int num, int k) {
        LinkedList<Integer> queue1 = new LinkedList<>(); // 保证sheng序
        LinkedList<Integer> queue2 = new LinkedList<>();
        queue1.push(num);
        int deep = 0;
        while (!queue1.isEmpty()) {
            int minNum = queue1.peek();
            if (minNum != 1 && k > 0) {
                k--;
                while (!queue1.isEmpty()) {
                    Integer numToSplit = queue1.pop();
                    Integer num1 = numToSplit / 2;
                    Integer num2 = numToSplit - num1;
                    if (num1 > num2) {
                        int temp = num1;
                        num1 = num2;
                        num2 = temp;
                    }
                    if (num1 != 0) {
                        queue2.push(num1);
                    }
                    if (num2 != 0) {
                        queue2.push(num2);
                    }
                }
                deep++;
            } else {
                while (!queue1.isEmpty()) {
                    int num3 = queue1.pop() - 1;
                    if (num3 != 0) {
                        queue2.push(num3);
                    }
                }
                deep++;
            }
            queue1 = queue2;
            queue2 = new LinkedList<>();
        }
        return deep;
    }

    public static void main(String[] args) {
        System.out.println(fun(15,4));
    }
}
