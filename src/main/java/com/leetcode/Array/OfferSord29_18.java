package com.leetcode.Array;

import java.util.ArrayList;

/**
 * @author liubi
 * @date 2018-11-29 21:00
 **/
public class OfferSord29_18 {
    /**
     *算法分析：经过分析 打印顺序 可以分为  0 down,1 left,2up,3 right 3--0--1--2--...
     * 每次步数都等于 length -count 其中 count 第一次为0 第二次 1 接下来 每两次+1
     * 根据规律 进行打印
     * O（n）
     * @param matrix
     * @return
     */
    public ArrayList<Integer> printMatrix(int [][] matrix) {
        ArrayList<Integer> res = new ArrayList<>();
        int m = matrix.length; // 行数
        int n= matrix[0].length; // 列数
        int i = 0 , j = -1;// pos

        int count = 0;
        int direction = 3;// range :0 down,1 left,2up,3 right 先向右打印横行
        while(res.size()<m*n){
            switch (direction){
                case 0:
                    for(int step= 0 ; step< m-count ; step++){
                        res.add(matrix[++i][j]);
                    }
                    break;
                case 1:
                    for(int step= 0;step< n-count;step++){
                        res.add(matrix[i][--j]);
                    }
                    count++;
                    break;
                case 2:
                    for(int step= 0;step< m-count;step++){
                        res.add(matrix[--i][j]);
                    }
                    break;
                case 3:
                    for(int step= 0;step< n-count;step++){
                        res.add(matrix[i][++j]);
                    }
                    count++;
                default:
            }
            direction = (direction+1)%4;
        }
        System.out.println(res.toString());
        return  res;
    }
    public static void main(String[] args) {
        OfferSord29_18 solution = new OfferSord29_18();
        int [][] matrix = {{1},{5},{9}};
        solution.printMatrix(matrix);
    }
}