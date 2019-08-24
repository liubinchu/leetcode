package com.leetcode;

import java.util.Arrays;

/**
 * @author liubi
 * @date 2019-08-24 19:47
 **/
public class jd01 {
    private static int max = Integer.MIN_VALUE;

    public static void fun(int[] data, int current, int curentNum) {
        if (current < -1 || current > data.length - 1) {
            System.out.println("error");
        }
        int[] qian, hou;
        int maxQian = Integer.MIN_VALUE;
        int minHou = Integer.MAX_VALUE;
        if (current + 1 > 0) {
            qian = Arrays.copyOfRange(data, 0, current + 1);
            Arrays.sort(qian);
            maxQian = qian[qian.length - 1];
            for (int i = 0; i < qian.length; i++) {
                data[i] = qian[i];
            }
        }
        if (current + 1 < data.length) {
            hou = Arrays.copyOfRange(data, current + 1, data.length);
            Arrays.sort(hou);
            minHou = hou[0];
        }
        if (maxQian > minHou) {
            // 该组合不成立
            return;
        } else {// 成立向下搜索
            max = Math.max(curentNum + 1, max);
            for (int i = 0; i < data.length - 2 - current; i++) {
                fun(data, current + i + 1, curentNum + 1);
            }
        }
    }

    /**
     * @param data
     * @return index of min
     */
    public static int findMin(int[] data) {
        int[] sored = data.clone();
        Arrays.sort(sored);
        int min = sored[0];
        for (int i = 0; i < data.length; i++) {
            if (min == data[i]) {
                return i;
            }
        }
        return data.length;
    }

    /**
     * 之后做出来 是没有用的
     * @param data
     * @return
     */
    public static int zhiHouChuZuoLai(int[] data) {
        int partNum = 1;
        int minIndex = -1;
        while (true) {
            minIndex = findMin(data);
            if (minIndex >= data.length - 1) {
                break;
            }
            partNum++;
            data = Arrays.copyOfRange(data, minIndex + 1, data.length);
        }
        return partNum;
    }

    public static void main(String[] args) {
/*        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] data = new int[n];
        for (int i = 0; i < n; i++) {
            data[i] = in.nextInt();
        }*/
/*        int n = 10;
        int[] data = new int[]{6, 23, 7, 65, 44, 27, 75, 76, 99, 88};*/
        int n = 4;
        int[] data = new int[]{2, 1, 3, 2};

/*
        fun(data, -1, 0);
        System.out.println(max);*/
        System.out.println(zhiHouChuZuoLai(data));
    }
}
