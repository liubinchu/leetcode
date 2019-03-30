package com.leetcode;

import javax.print.DocFlavor;
import java.util.Scanner;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author liubi
 * @date 2019-02-20 20:45
 **/
public class exam01 {

    void display(){
        System.out.println("data = "+data);
    }
    int data;
    public static void main(String[] args) {

    }

    class S{
        int data1;
        float data2;
        S(int data1 ,float data2){
            this.data1  =data1;
            this.data2 = data2;
        }
        void modify (int value){
            this.data1 = this.data1/value;
            this.data2=  this.data2 /value;
            value = value +2;
        }
    }
}
