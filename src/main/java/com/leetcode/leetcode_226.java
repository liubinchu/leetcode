package com.leetcode;

/**
 * @author liubi
 * @date 2019-05-14 20:34
 **/
public class leetcode_226 {
    private void invertCore(TreeNode root){
        if(root==null){
            return;
        }
        else {
            TreeNode temp = root.left;
            root.left = root.right;
            root.right = temp;
            invertCore(root.left);
            invertCore(root.right);
        }
    }
    public TreeNode invertTree(TreeNode root) {
        invertCore(root);
        return root;
    }
    public static void main(String[] args) {
        leetcode_226 solution = new leetcode_226();
    }
}
