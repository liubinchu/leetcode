package com.leetcode;

import javafx.util.Pair;

import java.util.*;

public class aiqiyi01 {
    public String run(D obj) {
        return ("A_D");
    }

    public String run(aiqiyi01 obj) {
        return ("A_A");
    }

    static class B extends aiqiyi01 {
        public String run(B obj) {
            return ("B_B");
        }

        public String run(aiqiyi01 obj) {
            return ("B_A");
        }
    }

    static class C extends B {
    }

    static class D extends B {
    }

    public static void main(String[] args) {
        aiqiyi01 ab = new B();
        System.out.println(ab.run(new B()));
        System.out.println(ab.run(new C()));
        System.out.println(ab.run(new D()));
        LinkedList<Integer> ll = new LinkedList<>();
        ArrayList<Integer> al = new ArrayList<>();

    }
}
