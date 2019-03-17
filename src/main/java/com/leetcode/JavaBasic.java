package com.leetcode;

import java.util.HashMap;
import java.util.Map;

public class JavaBasic {
    class Inner{
        private int data;
    }
    public Inner getInner(){
        return new Inner();
    }
    public void unstaticMethod(){
        Inner inner = new Inner();
    }
    public static void main(String[] args) {
        Integer a =125;
        Integer b = 125;
        System.out.println(a == b);
        System.out.println(",");
        Integer c =321;
        Integer d = 321;
        System.out.println(c==d);

    }
}// write your code here