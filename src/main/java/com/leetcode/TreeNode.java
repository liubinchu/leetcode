package com.leetcode;

/**
 * @author liubi
 */
public   class TreeNode {
    public int val;
    public TreeNode left;
    public TreeNode right;

    TreeNode(int x) {
        val = x;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this(val);
        this.left = left;
        this.right = right;
    }
}
