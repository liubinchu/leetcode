package com.leetcode;

/**
 * @author liubi
 * @date 2019-01-10 12:24
 **/
public class TreeLinkNode {
    int val;
    TreeLinkNode left = null;
    TreeLinkNode right = null;
    TreeLinkNode next = null;

    TreeLinkNode(int val) {
        this.val = val;
    }

    @Override
    public String toString() {
        return "TreeLinkNode{" +
                "val=" + val+
                '}';
    }
}
