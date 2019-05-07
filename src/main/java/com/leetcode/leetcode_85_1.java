package com.leetcode;

/**
 * @author liubi
 * @date 2019-05-07 09:22
 * 该解法 爆内存
 **/
public class leetcode_85_1 {
    private int rowLen;
    private int len;
    private boolean[][] dp;
    private char[][] matrix;
    private int max = 0;
    private boolean accessMatrix(int index) {
        return this.matrix[index / this.rowLen][index % this.rowLen] == '1';
    }

    private boolean allOneInrow(int row, int start, int end) {
        for(int index = start;index<end;index++){
            if(this.matrix[row][index]=='0'){
                return false;
            }
        }
        return true;
    }
    private boolean allOneIncolumn(int column, int start, int end) {

        for(int index = start;index<end;index++){
            if(this.matrix[index][column]=='0'){
                return false;
            }
        }
        return true;
    }

    private boolean legalIndexPair(int i, int j) {
        if (i < 0 || j < i || j >= this.len) {
            return false;
        }
        if (j / this.rowLen < i / this.rowLen) {
            return false;
        }
        if (j % this.rowLen < i % this.rowLen) {
            return false;
        }
        return true;
    }

    public int maximalRectangle(char[][] matrix) {
        if (matrix.length == 0) {
            return 0;
        }
        this.rowLen = matrix[0].length;
        this.len = matrix.length * this.rowLen;
        this.dp = new boolean[len][len];
        this.matrix = matrix;

        for (int i = 0; i < this.len; i++) {
            for (int j = i; j < this.len; j++) {
/*                if(i==3&&j==11){
                    System.out.println("c");
                }*/
                dp[i][j] = legalIndexPair(i, j);
                if(i%rowLen==j%rowLen){
                    dp[i][j]=dp[i][j] && allOneIncolumn(j%rowLen,i/rowLen,j/rowLen);
                }
                else {
                    dp[i][j]=dp[i][j] && (j/this.rowLen == (j-1)/this.rowLen&&legalIndexPair(i, j - 1) ? dp[i][j - 1]&&allOneIncolumn(j%rowLen,i/rowLen,j/rowLen): true);
                }
                if(i/rowLen==j/rowLen){
                    dp[i][j]=dp[i][j] &&allOneInrow(j/rowLen,i%rowLen,j%rowLen);
                }
                else {
                    dp[i][j]=dp[i][j] && (legalIndexPair(j - rowLen, i) ? dp[i][j - rowLen]&&allOneInrow(j/rowLen,i%rowLen,j%rowLen) : true);
                }
                dp[i][j]=dp[i][j] && (accessMatrix(j));
                if (dp[i][j]) {
                    int currRes = (j / this.rowLen - i / this.rowLen + 1) * (j % this.rowLen - i % this.rowLen + 1);
                    max = Math.max(currRes, max);
                }
            }
        }
/*        for (int i = 0; i < this.len; i++) {
            for (int j = i; j < this.len; j++) {
                if(legalIndexPair(i, j)){
                    System.out.print(this.dp[i][j] + " i(" + i / this.rowLen + "," + i % this.rowLen + ");j(" + j / this.rowLen + "," + j % this.rowLen + ") ");
                }
            }
            System.out.println("\n------------------------------------");
        }*/
        return max;
    }
    public static void main(String[] args) {
        leetcode_85_1 solution = new leetcode_85_1();
        char[][] matrix = new char[4][4];
        matrix[0][0] = '1';
        matrix[0][1] = '0';
        matrix[0][2] = '1';
        matrix[0][3] = '0';
        //matrix[0][4] = '0';
        matrix[1][0] = '1';
        matrix[1][1] = '0';
        matrix[1][2] = '1';
        matrix[1][3] = '1';
        //matrix[1][4] = '1';
        matrix[2][0] = '1';
        matrix[2][1] = '0';
        matrix[2][2] = '1';
        matrix[2][3] = '1';
      // matrix[2][4] = '1';
        matrix[3][0] = '1';
        matrix[3][1] = '1';
        matrix[3][2] = '1';
        matrix[3][3] = '1';
      //  matrix[3][4] = '0';
        int res = solution.maximalRectangle(matrix);
        System.out.println(res);
    }
}
