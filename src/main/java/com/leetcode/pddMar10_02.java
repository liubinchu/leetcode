package com.leetcode;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

/**
 * @author liubi
 * @date 2019-03-10 16:52
 **/
public class pddMar10_02 {
    public static void main(String[] args) {
        Scanner in=new Scanner(System.in);
        while(in.hasNext()) {
            String str=in.nextLine().toLowerCase();
            Character current = 'z';
            for(int i =0;i< str.length();i++) {
                if(current.equals('a') ) {
                    System.out.println(Character.toLowerCase(current));
                    return;
                } else if(-1 != str.indexOf(String.valueOf(str.charAt(i)),i+1)) {
                    if(Character.toLowerCase(str.charAt(i))<current) {
                        current = Character.toLowerCase(str.charAt(i));
                    }
                } else if(Character.toLowerCase(str.charAt(i))<current) {
                    current = Character.toLowerCase(str.charAt(i));
                    System.out.println(Character.toLowerCase(current));
                    return;
                }
            }
            System.out.println(Character.toLowerCase(current));
            return;
        }
    }
}
