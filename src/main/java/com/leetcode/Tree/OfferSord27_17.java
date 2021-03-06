package com.leetcode.Tree;

import com.leetcode.TreeNode;

/**
 * @author liubi
 * @date 2018-11-29 20:33
 **/
public class OfferSord27_17 {
    public void Mirror(TreeNode root) {
        if(root == null|| (root.right==null&&root.left==null)) {
            return;
        }
        else{
            //swap
            TreeNode temp = root.left;
            root.left = root.right;
            root.right = temp;
            // recursion
            Mirror(root.left);
            Mirror(root.right);
        }
    }
    public void Mirror1(TreeNode root) {
        if(root==null){
            return;
        }
        TreeNode tmp = root.left;
        root.left = root.right;
        root.right = tmp;
        Mirror1(root.left);
        Mirror1(root.right);
    }

    public static void main(String[] args) {
        OfferSord27_17 solution = new OfferSord27_17();
    }
}
