package com.leetcode;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author liubi
 * @date 2019-03-10 20:48
 **/
public class tengxunMar10ML_01 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNextInt()) {//注意while处理多个case
/*            int n = in.nextInt();
            int a = in.nextInt();
            int data[] = new int[n];
            for(int i=0;i<n;i++){
                data[i] = in.nextInt();
            }*/
            int n = 4;
            int a = 4;
            int data[] = new int[]{1, 2, 3, 5,6};
            int res = Integer.MAX_VALUE;
            Arrays.sort(data);
            int index = Arrays.binarySearch(data, a);
            if(index>0){//found
                for(int i=index-1;i>=0;i--){
                    int dest = n+i-2;
                    if(dest>n-1){
                        continue;
                    }
                    int distance = data[index] - data[i];
                    distance *= 2;
                    distance+=data[dest]-data[index];
                    res = Math.min(res,distance);
                }
            }
            else {//not find
                index = -index;
                for(int i=index-1;i>=0;i--){
                    int dest = n+i-1;
                    if(dest>n-1){
                        continue;
                    }
                    int distance = data[index] - data[i];
                    distance *= 2;
                    distance+=data[dest]-data[index];
                    res = Math.min(res,distance);
                }
            }
            int min = Integer.MAX_VALUE;
            System.out.println(res);
        }
    }
}
