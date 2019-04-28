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
        Integer aInt = 1;
        Integer bInt = 2;
        Integer cInt = 3;
        Integer dInt = 3;
        Integer eInt = 321;
        Integer fInt = 321;
        Long gLong = 3L;
        Long hLong = 2L;
        Byte iByte = 1;
        Byte jByte = 2;

        System.out.println(cInt==dInt);
        System.out.println(eInt==fInt);
        System.out.println(cInt==(aInt+bInt));
        System.out.println(cInt==(iByte+jByte));
        System.out.println(cInt.equals(aInt+bInt));

        System.out.println(gLong==(aInt+bInt));
        System.out.println(gLong.equals(aInt+bInt));
        System.out.println(gLong.equals(aInt+hLong));
        //System.out.println(fun(15,4));
    }
}
