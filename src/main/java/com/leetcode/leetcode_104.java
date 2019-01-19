package com.leetcode;

public class leetcode_104 {
    public int maxDepth(TreeNode root) {
        if(root ==null) return 0;
        int lhight = maxDepth(root.left);
        int rhight = maxDepth(root.right);
        if(lhight > rhight) return lhight+1;
        else return rhight+1;
    }
}
