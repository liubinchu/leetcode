package com.leetcode;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

/**
 * @author liubi
 * @date 2018-12-16 14:16
 * numOfOne
 * key: 表示位数 value 表示 几位数 中 一 的个数 如key =2 表示 两位数的个数
 **/
public class OfferSord43_30 {

    public int NumberOf1Between1AndN_Solution(int n) {
        int length = getNumLength(n);
        int firstNum = getFirstNum(n);
        if (length == 0) {
            return 0;
        } else if (length == 1) {
            return 1;
        }
        int result = 0;
        result += (length-1) * getPowerBase10(length-2);
        int residue = n % getPowerBase10(length-1);
        if (firstNum != 1) {
            result += getPowerBase10(length - 1) + (firstNum - 1) * (length - 1) * getPowerBase10(length - 2);
        } else {
            result += (residue + 1);
        }

        result += NumberOf1Between1AndN_Solution(residue);
        return result;
    }

    /**
     * 计算 num 位数范围内 1的个数， 如 num =2 表示 10-99 中  1的个数
     *
     * @param num 位数
     * @return
     */
    private int calNumOf1Digits(int num) {
        return getPowerBase10(num - 1) + 10 * (num - 1);
    }

    private int getFirstNum(int num) {
        int number = -1;
        if (num < 0) {
            number = -num;
        } else {
            number = num;
        }
        while (number > 9) {
            number /= 10;
        }
        return number;
    }

    private int getNumLength(int num) {
        // the length of 0 is 0
        int number = 0;
        int length = 0;
        if (num < 0) {
            number = -num;
        } else {
            number = num;
        }
        while (number > 0) {
            number /= 10;
            length++;
        }
        return length;
    }

    private int getPowerBase10(int num) {
        int result = 1;
        for (int i = 0; i < num; i++) {
            result *= 10;
        }
        return result;
    }

    private int getNumOfOneInNumber(int number) {
        int res = 0;
        int lastDigits = 0;
        while (number > 0) {
            lastDigits = number % 10;
            if (lastDigits == 1) {
                res += 1;
            }
            number /= 10;
        }
        return res;
    }

    private int getNumOfOneInRange(int range) {
        int res = 0;
        for (int i = 1; i < range + 1; i++) {
            res += getNumOfOneInNumber(i);
        }
        return res;
    }

    public static void main(String[] args) {
        OfferSord43_30 solution = new OfferSord43_30();
        Random random = new Random();
        for (int i = 1; i < 10; i++) {
            int testNum = random.nextInt(100000);
            testNum = testNum>0? testNum:-testNum;
            System.out.println(solution.getNumOfOneInRange(testNum));
            System.out.println(solution.NumberOf1Between1AndN_Solution(testNum));
            System.out.println((testNum));
            System.out.println("------------------------------------");
        }
    }

}
