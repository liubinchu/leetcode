package com.leetcode;

public class laohu01 {

    public TreeNode search(TreeNode root, TreeNode A, TreeNode B) {
        if (root == null || root == A || root == B) {
            return root;
        }
        TreeNode left = search(root.left, A, B);
        TreeNode right = search(root.right, A, B);
        if (left != null && right != null) {
            return root;
        }
        return left == null ? right : left;
    }
}
