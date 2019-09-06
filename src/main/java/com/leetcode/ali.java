package com.leetcode;
public class ali {
    class TreeNode {

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

    private static int distance = Integer.MIN_VALUE;
    public static int getDepth(TreeNode root,int depth){
        if(root==null){
            return -1;
        }else{
            int leftDepth = getDepth(root.left,depth++)+1;
            int rightDepth = getDepth(root.right,depth++)+1;
            int currDistance = leftDepth + rightDepth;
            distance = Math.max(distance,currDistance);
            return Math.max(leftDepth,rightDepth);
        }
    }
}
