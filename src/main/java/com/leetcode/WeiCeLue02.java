package com.leetcode;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author liubi
 * @date 2019-04-04 19:58
 **/
public class WeiCeLue02 {

    static void fun(List<String> a, List<String> b){
        for(int i=0;i<a.size();i++){
            if(funCore(a.get(i),b.get(i))){
                System.out.println("YES");
            }
            else {
                System.out.println("NO");
            }
        }
    }
/*    static boolean containCharInString(String s , char c){
        char[] chars = s.toCharArray();
        for(char charInS : chars){
            if(charInS==c){
                return  true;
            }
        }
        return false;
    }*/
    static boolean  funCore(String a, String b) {
        char[] charsA = a.toCharArray();
        Set<Character> setA = new HashSet<>();
        for(char charA :charsA){
            setA.add(charA);
        }

        char[] charsB = b.toCharArray();
        Set<Character> setB = new HashSet<>();
        for(char charB :charsB){
            setB.add(charB);
        }
        setA.retainAll(setB);
        if(setA.isEmpty()){
            return false;
        }
        else {
            return true;
        }

    }
    public static void main(String[] args){
        List<String> a = new ArrayList<>();
        a.add("hello");
        a.add("hi");
        List<String> b = new ArrayList<>();
        b.add("world");
        b.add("bye");
        fun(a,b);
    }
}
