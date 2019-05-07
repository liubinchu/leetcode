package com.leetcode;

import java.util.Arrays;
import java.util.LinkedList;

/**
 * @author liubi
 * @date 2019-05-07 21:28
 * 利用 leetcode84 最大连续的高度的解法
 * 将二维数组抽象成多个 柱状图
 **/
public class leetcode_85_2 {

    public int maximalRectangle(char[][] matrix) {
        int max =0;
        if(matrix.length==0){
            return max;
        }
        int[] heights = new int[matrix[0].length];
        for(int i=0;i<matrix.length;i++){
            heights = resetHeights(i,heights,matrix);
            max = Math.max(max,largestRectangleArea(heights));
        }
        return max;
    }
    private int[] resetHeights(int i,int[]heights, char[][]matrix){
        int length = matrix[0].length;
        for(int j=0;j<length;j++){
            if (matrix[i][j]=='1'){
                heights[j]++;
            }
            else {
                heights[j]=0;
            }
        }
        return heights;
    }
    private int largestRectangleArea(int[] heights) {
        int max = Integer.MIN_VALUE;
        int[] data= Arrays.copyOf(heights,heights.length+1); // 添加一个0， 确保所有元素都会出栈，计算所有元素的面积
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
        leetcode_85_2 solution = new leetcode_85_2();
        char[][] matrix = new char[2][2];
        matrix[0][0] = '0';
        matrix[0][1] = '1';
        matrix[1][0] = '1';
        matrix[1][1] = '0';
        int res = solution.maximalRectangle(matrix);
        System.out.println(res);
    }
}
