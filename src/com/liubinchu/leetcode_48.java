package com.liubinchu;

public class leetcode_48 {
    public void rotate(int[][] matrix) {
        int  n = matrix.length;
        for(int i=0;i<=(n-1)/2;i++){ //i的取值范围 矩阵的上半部分
            for(int j=i; j<n-1-i;j++){ // j 的取值范围 两条对角线 划分出的 上面一部分
                // swap
                int temp = matrix[i][j];
                matrix[i][j] = matrix[n-1-j][i];
                matrix[n-1-j][i] = matrix[n-1-i][n-1-j];
                matrix[n-1-i][n-1-j] = matrix[j][n-1-i];
                matrix[j][n-1-i] = temp;
            }
        }
    }
}
