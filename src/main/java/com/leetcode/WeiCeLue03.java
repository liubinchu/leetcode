package com.leetcode;

public class WeiCeLue03 {
    class Node {
        int data;
        Node left;
        Node right;
    }

    public int isPresent(Node x, int val) {
        if (x == null) {
            return 0;
        }
        if (val == x.data) {
            return 1;
        } else if (val < x.data) {//查找左树
            return isPresent(x.left, val);
        } else {//查找右树
            return isPresent(x.right, val);
        }
    }

    public static void main(String[] args) {
        WeiCeLue04 A = new WeiCeLue04("A");
        WeiCeLue04 B = new WeiCeLue04("B");
        B.start();
        A.start();
    }
}
