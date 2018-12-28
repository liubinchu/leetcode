package com.leetcode;

import javafx.util.Pair;

/**
 * @author liubi
 * @date 2018-12-28 10:24
 **/
public class OfferSord55_1_37 {
    /**
     * 解题报告：AVL树的条件 1. 左右子树是AVL树 2.当前树 左右子树的深度差 不超过一
     */
    private Boolean isAVLTree;
    private int preOrderTraversal(TreeNode root){
        if(root == null){
            return 0;
        }
        else {
            int leftDeepth = preOrderTraversal(root.left);
            int rightDeepth = preOrderTraversal(root.right);
            int delt = leftDeepth - rightDeepth;
            if(delt>1||delt<-1){
                this.isAVLTree = false;
            }
            return leftDeepth>rightDeepth? leftDeepth+1:rightDeepth+1;
        }
    }
    public boolean IsBalanced_Solution(TreeNode root) {
        this.isAVLTree = true;
        System.out.println(preOrderTraversal(root));
        return this.isAVLTree;
    }
    public static void main(String[] args) {
        OfferSord55_1_37 solution = new OfferSord55_1_37();
        TreeNode root1 = new TreeNode(8);
        root1.left = new TreeNode(8);
        root1.right = new TreeNode(7);
        root1.left.left = new TreeNode(9);
        root1.left.right = new TreeNode(2);
        root1.left.right.left = new TreeNode(4);
        root1.left.right.right =new TreeNode(7);

        TreeNode root2 = new TreeNode(8);
        root2.left = new TreeNode(9);
        root2.right = new TreeNode(2);
        System.out.println(solution.IsBalanced_Solution(root1));
        System.out.println(solution.IsBalanced_Solution(root2));
    }
}
