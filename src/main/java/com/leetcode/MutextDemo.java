package com.leetcode;

import java.util.concurrent.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author liubi
 * @date 2019-02-20 20:45
 **/
public class MutextDemo {
    public static  int getMax(int [] errorScore){
        int result = Integer.MIN_VALUE;
        int index = -1;
        for(int i=0;i<errorScore.length;i++){
            if (errorScore[i]>result){
                result = errorScore[i];
                index = i;
            }
        }

        return index;
    }
    public static  int getMin(int [] errorScore){
        int result = Integer.MAX_VALUE;
        int index = -1;
        for(int i=0;i<errorScore.length;i++){
            if (errorScore[i]<result){
                result = errorScore[i];
                index = i;
            }
        }
        return index;
    }

    public  int fun(int num, int projCmptDec,int restDec,int[]errorScore){
        int result = 0;
        if( num!=errorScore.length){
            return -1;
        }
        if(projCmptDec>=restDec){
            while (true){
                int maxValueIndex = getMax(errorScore);
                if(maxValueIndex==-1||errorScore[maxValueIndex]<=0){
                    break;
                }
                // deduct
                for(int i=0;i<errorScore.length;i++){
                    if(i==maxValueIndex){
                        errorScore[maxValueIndex] -= projCmptDec;
                    }
                    else {
                        errorScore[i]-= restDec;
                    }
                }
                result++;
            }
        }
        else {
            while (true){
                int maxValueIndex = getMax(errorScore);
                int minValueIndex = getMin(errorScore);
                if(maxValueIndex==-1||errorScore[maxValueIndex]<=0){
                    break;
                }
                // deduct
                for(int i=0;i<errorScore.length;i++){
                    if(i==minValueIndex){
                        errorScore[i] -= projCmptDec;
                    }
                    else {
                        errorScore[i]-= restDec;
                    }
                }
                result++;
            }
        }
        return result;
    }
    public static void main(String[] args){
        int n=3;
        int pro = 2;
        int rest =1;
        int [] data = {4,3,2};
        MutextDemo mutextDemo = new MutextDemo();
        System.out.println(mutextDemo.fun(n,pro,rest,data));
    }
}

