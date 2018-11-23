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
        Scanner scanner = new Scanner("liubinchu is a person, 24 years old, likes John and LiZongSheng, 56.04 kg ");
        while (scanner.hasNext()){
            if(scanner.hasNextInt()){
                System.out.println(scanner.nextInt());
            }
            else if(scanner.hasNextFloat()){
                System.out.println(scanner.nextFloat());
            }
            else {
                System.out.println(scanner.next());
            }
            System.out.println(scanner.ioException());
            scanner.next();
            scanner.match();
        }
    }
}
