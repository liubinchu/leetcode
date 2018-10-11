package com.leetcode;

import java.util.ArrayList;

public class leetcode_62 {
    // 动态规划问题：第(i,j)位置的可达不同路径数目 n(i,j)= n(i-1,j)+n(i,j-1) 即 相邻位置可达路径数目之和， 边境点可达路径数==1
    public int uniquePaths(int m, int n) {
        int res[][] = new int[m][n];
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(i==0||j==0) res[i][j]=1;
                else{
                    res[i][j] = res[i-1][j] +res[i][j-1];
                }
            }
        }
        return res[m-1][n-1];
    }

    public static void main(String[] args) {
        leetcode_62 solution = new leetcode_62();
        int [][] res = new int[10][2];
        System.out.println(res[5][0]);
    }
}
