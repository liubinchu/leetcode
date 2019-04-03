package com.leetcode;

import java.util.*;

/**
 * @author liubi
 * @date 2019-04-03 19:22
 **/
public class MicroSoft01 {
    public   int maxCircles(int input1,int input2,int input3){
        int n = input1;
        int p = input2;
        int x = input3;
        int[][] graph = new int[n][n];
        for (int i=0;i<n;i++){  // i对应的label  是 i+1
            for (int j=i+1;j<n;j++){
                if((j+1)%(i+1)==0){
                    graph[i][j] = 1;
                    graph[j][i] = 1;
                }
            }
        }
        ArrayList<Set<Integer>> possibleMoves = new ArrayList<>(n);
        for(int i=0;i<n;i++){
            Set<Integer> possibleMove = new HashSet<>();
            for(int j=0;j<n;j++){
                if(graph[i][j]==1){
                    possibleMove.add(j);
                }
            }
            possibleMoves.add(possibleMove);
        }
        System.out.println(possibleMoves);
        int result = 0;
        LinkedList<Integer> bFsQueue1 = new LinkedList<>();
        LinkedList<Integer> bFsQueue2 = new LinkedList<>();
        bFsQueue1.push(p-1);
        for(int deep = 2;deep<=x+1;deep++){
            while (!bFsQueue1.isEmpty()){
                int lastMove = bFsQueue1.pop();
                for(int nextMove : possibleMoves.get(lastMove)){
                    if(nextMove==(p-1)){
                        result++;
                    }
                    bFsQueue2.add(nextMove);
                }
            }
            bFsQueue1 = bFsQueue2;
            bFsQueue2 = new LinkedList<>();
        }
        return result;
    }
    public static void main(String[] args){
        MicroSoft01 microSoft01 = new MicroSoft01();
        System.out.println(microSoft01.maxCircles(3,2,4));
    }
}
