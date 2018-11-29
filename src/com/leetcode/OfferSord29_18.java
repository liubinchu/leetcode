package com.leetcode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author liubi
 * @date 2018-11-29 21:00
 **/
public class OfferSord29_18 {
    public ArrayList<Integer> printMatrix(int [][] matrix) {
        ArrayList<Integer> res = new ArrayList<>();
        int m = matrix.length; // 行数
        int n= matrix[0].length; // 列数
        int i = 0 , j = -1;// pos

        while(j<n-1){
            res.add(matrix[i][++j]);
        }
        int maxStep = m<=n? m:n;// select smaller one
        int step = 1;
        int direction = 0;// range :0 down,1 left,2up,3 right
        while(step<maxStep){
            switch (direction){
                case 0:
                    for(int count = 0 ; count < m-step ; count++){
                        res.add(matrix[++i][j]);
                    }
                    break;
                case 1:
                    for(int count = 0;count < n-step;count++){
                        res.add(matrix[i][--j]);
                    }
                    step++;
                    break;
                case 2:
                    for(int count = 0;count < m-step;count++){
                        res.add(matrix[--i][j]);
                    }
                    break;
                case 3:
                    for(int count = 0;count < n-step;count++){
                        res.add(matrix[i][++j]);
                    }
                    step++;
                default:
            }
            direction = (direction+1)%4;
        }
        //System.out.println(res.toString()+" ");
        return  res;
    }
    public static void main(String[] args) {
        OfferSord29_18 solution = new OfferSord29_18();
        int [][] matrix = {{1,2,3,4},{5,6,7,8},{9,10,11,12}};
        solution.printMatrix(matrix);
    }
}