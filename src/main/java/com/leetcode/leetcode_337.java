package com.leetcode;

/**
 * @author liubi
 * @date 2019-05-12 14:56
 * 思想 树的搜索问题 当前node 可以选择 抢劫 或者 不抢劫
 **/
public class leetcode_337 {
    public int rob(TreeNode root) {
        if(root==null){
            return 0;
        }
        else {
            return Math.max(rob(root.left)+rob(root.right),
                    root.val+ (root.right!=null?rob(root.right.right)+rob(root.right.left):0)
                    +(root.left!=null?rob(root.left.left)+rob((root.left.right)):0));
        }
    }
    public static void main(String[] args) {
        leetcode_337 solution = new leetcode_337();
    }
}
