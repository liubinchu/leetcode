package com.leetcode;

/**
 * 算法分析： 二叉树遍历的变形 关键在于设计对称的遍历算法，可以基于前中后三种顺序
 * 实现基于前序进行变形
 * @author liubi
 * @date 2019-01-10 21:03
 **/
public class OfferSord28_57 {
    public void preOrder(TreeNode pRoot){
        System.out.println(pRoot);
        preOrder(pRoot.left);
        preOrder(pRoot.right);
    }

    private boolean isSymmetricalCore(TreeNode left ,TreeNode right){
        if(left==null&&right==null){
            return true;
        }
        else if(left==null||right==null){
            return false;
        }
        else if(left.val !=right.val){
            return false;
        }
        //遍历当前节点
        else { //left.val == right.val
            return isSymmetricalCore(left.left,right.right)&& isSymmetricalCore(left.right,right.left);
        }
    }
    public boolean isSymmetrical(TreeNode pRoot)
    {
        if(pRoot==null){
            return true;
        }
        else {
            return isSymmetricalCore(pRoot.left,pRoot.right);
        }

    }
    public static void main(String[] args) {
        OfferSord28_57 solution = new OfferSord28_57();
    }
}
