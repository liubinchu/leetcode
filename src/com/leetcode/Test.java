package com.leetcode;

import java.util.Formatter;

/**
 * @author liubi
 * @date 2018-11-22 10:59
 **/

class AException extends Exception{
    @Override
    public String toString(){
        return "AException";
    }
}
class BException extends Exception{
    @Override
    public String toString(){
        return "BException";
    }
}

public class Test {
    public static void fun() {
        try {
            try {
                throw new AException();
            } finally {
                throw new BException();
            }
        } catch (Exception e) {
            System.out.println(e);
        }

    }

    public static void main(String[] args) {
        fun();
        System.out.printf("sad");
        Formatter formatter = new Formatter(System.out);
        formatter.format("Sda");
    }
}
