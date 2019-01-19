package com.leetcode;

import java.util.Formatter;
import java.util.Scanner;

/**
 * @author liubi
 * @date 2018-11-22 10:59
 **/

class AException extends Exception{
    @Override
    public String toString(){
        return "AException";
    }
    public void  fun(){
        System.out.println("fun()");
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

    public static <number> void main(String[] args) throws IllegalAccessException, InstantiationException {
            Object object = null;
            Class scannerClass = AException.class;
            object = scannerClass.newInstance();
            System.out.println(object.toString());
            AException aException = (AException) object;
            aException.fun();
            Integer integer = null;
            Number number;
    }
}
