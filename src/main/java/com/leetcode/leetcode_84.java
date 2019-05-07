package com.leetcode;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Stack;

/**
 * @author liubi
 * @date 2019-05-07 15:14
 * 显然可以用DP作，但是时空复杂度高
 *  * 利用单调栈的思想，类似于 leetcode_42
 *  * 单调栈一般用于 优化DP，最大的优势在于线性时间 和 空间
 *  * 一般用于连续数组的问题
 *  * https://blog.csdn.net/qy724728631/article/details/82350682
 *  * https://blog.csdn.net/zuzhiang/article/details/78134247
 *  * http://www.cnblogs.com/grandyang/p/8887985.html
 **/
public class leetcode_84 {
    public int largestRectangleArea(int[] heights) {
        int max = Integer.MIN_VALUE;
        int[] data=Arrays.copyOf(heights,heights.length+1); // 添加一个0， 确保所有元素都会出栈，计算所有元素的面积
        int shortBar ; // 当前最短的 bar的index
        int areaShortBar; // 以当前最短的 bar 为最短bar，所计算得到的面积
        int i=0;
        LinkedList<Integer> increaseStack = new LinkedList<>(); // 单调栈，单调递增，从栈头（最后一个元素）至栈尾(第一个元素)单调增
        while (i<data.length){
            if (increaseStack.isEmpty()||data[increaseStack.peek()]<=data[i]){
                increaseStack.push(i++);
            }
            else {
                shortBar = data[increaseStack.pop()];
                areaShortBar = shortBar* (increaseStack.isEmpty()?i:i-increaseStack.peek()-1);
                max = Math.max(max,areaShortBar);
            }
        }
        return max;
    }

    public static void main(String[] args) {
        leetcode_84 solution = new leetcode_84();
        int hist[] = {6, 2, 5, 4, 5, 1, 6};
        int res = solution.largestRectangleArea(hist);
        System.out.println("Maximum area is " + res);

    }
}
