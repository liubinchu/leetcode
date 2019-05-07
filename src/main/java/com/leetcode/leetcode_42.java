package com.leetcode;

import java.util.LinkedList;

/**
 * @author liubi
 * @date 2019-05-07 20:51
 * 利用单调栈的思想，类似于 leetcode_84
 * 单调栈一般用于 优化DP，最大的优势在于线性时间 和 空间
 * 一般用于连续数组的问题
 * https://blog.csdn.net/qy724728631/article/details/82350682
 * https://blog.csdn.net/zuzhiang/article/details/78134247
 * http://www.cnblogs.com/grandyang/p/8887985.html
 *
 *
 * https://leetcode.com/articles/trapping-rain-water/ 该题有很多解法，目前只写了 利用单调栈的方法
 **/
public class leetcode_42 {
    public int trap(int[] height) {
        LinkedList<Integer> decreaseStack = new LinkedList<>();
        int shortBarIndex;
        int areaSum = 0;
        int currentSum = 0;
        int i=0;
        while (i<height.length){
            if(decreaseStack.isEmpty()||height[decreaseStack.peek()]>=height[i]){
                decreaseStack.push(i++);
            }
            else {
                shortBarIndex = decreaseStack.pop();
                if(decreaseStack.isEmpty()){
                    currentSum = 0;
                }
                else {
                    currentSum =(Math.min(height[decreaseStack.peek()],height[i]) - height[shortBarIndex])*(i-decreaseStack.peek()-1);
                }
                areaSum +=currentSum;
            }
        }
        return areaSum;
    }
    public static void main(String[] args) {
        //int hist[] = {6, 2, 5, 4, 5, 1, 6};
        int hist[] = {0,1,0,2,1,0,1,3,2,1,2,1};
        leetcode_42 solution = new leetcode_42();
        System.out.println(solution.trap(hist));
    }
}
