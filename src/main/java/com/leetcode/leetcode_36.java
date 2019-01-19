package com.leetcode;

import java.util.HashSet;
import java.util.Set;

public class leetcode_36 {
    public boolean isValidSquare(char[][] board, int x,  int y) { // x y 第一个元素的坐标
        Set set = new HashSet();
        for(int i =x; i< x +3; i++){
            for(int j = y ; j<y+3 ;j++){
                if(board[i][j]!= '.'){
                    if(!set.add(board[i][j])) return false;
                }
            }
        }
        return true;
    }
    public boolean isValidLine(char[][] board, int x, int y) {  // x y 第一个元素的坐标
        Set set = new HashSet();
        for(int i= x ; i<x +9 ;i++){
            if(board[i][y]!= '.'){
                if(!set.add(board[i][y])) return false;
            }
        }
        return true;
    }

    public boolean isValidRow(char[][] board, int x, int y) {  // x y 第一个元素的坐标
        Set set = new HashSet();
        for(int i= y ; i<y +9 ;i++){
            if(board[x][i]!= '.'){
                if(!set.add(board[x][i])) return false;
            }
        }
        return true;
    }

    public boolean isValidSudoku(char[][] board) {
        for(int i = 0 ; i<9;i++){
            if(!isValidLine(board,0,i)) return false;
            if(!isValidRow(board,i,0)) return false;
        }
        for(int i = 0 ; i< 9; i+=3){
            for(int j = 0; j<9 ;j+=3){
                if(!isValidSquare(board,i,j)) return false;
            }
        }
        return true;
    }
}
