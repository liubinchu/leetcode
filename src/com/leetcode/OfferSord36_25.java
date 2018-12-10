package com.leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * @author liubi
 * @date 2018-12-09 21:35
 **/
public class OfferSord36_25 {
    /**
     * 算法分析： 注意： 叶子节点 的左右 指针 应该 指向祖先节点
     * 左指针指向; 最后一个由右指针产生他/或者他的祖先 的 祖祖先节点
     * 右指针指向; 最后一个由左指针产生他/或者他的祖先 的 祖祖先节点
     * @param p
     * @return
     */
    private TreeNode findRightest(TreeNode p){
        if(p==null){
            return null;
        }
        while(p.right!=null){
            p = p.right;
        }
        return p;
    }
    private TreeNode findLeftest(TreeNode p){
        if(p==null){
            return null;
        }
        while(p.left!=null){
            p = p.left;
        }
        return p;
    }
    private void ConvertFun(TreeNode p,TreeNode rightFather, TreeNode leftFather){
        TreeNode left = p.left;
        TreeNode right = p.right;
        if(p.left!=null&&p.right!=null){
            p.left = findRightest(left);
            p.right = findLeftest(right);
            ConvertFun(right,p,leftFather);
            ConvertFun(left,rightFather,p);
        }
        else if(p.left!=null && p.right == null){
            p.left = findRightest(left);
            p.right = leftFather;
            ConvertFun(left,rightFather,p);
        }
        else if (p.left==null && p.right!=null){
            p.left = rightFather;
            p.right = findLeftest(right);
            ConvertFun(right,p,leftFather);
        }
        else if(p.left ==null && p.right == null){
                p.right = leftFather;
                p.left = rightFather;
        }
    }
    public TreeNode Convert(TreeNode pRootOfTree) {
        if(pRootOfTree == null){
            return null;
        }
        else{
            ConvertFun(pRootOfTree,null,null);
        }
        return findLeftest(pRootOfTree);
    }
    public static void main(String[] args) {
        TreeNode root1 = new TreeNode(7);
        root1.left = new TreeNode(4);
        root1.right = new TreeNode(10);
        root1.left.left = new TreeNode(2);
        root1.left.right = new TreeNode(5);
        root1.right.left = new TreeNode(9);
        root1.right.right =new TreeNode(11);
        root1.left.left.left = new TreeNode(1);
        root1.left.left.right =new TreeNode(3);
        root1.left.right.right = new TreeNode(6);
        root1.right.left.left =new TreeNode(8);
        root1.right.right.right =new TreeNode(12);

        OfferSord36_25 solution = new OfferSord36_25();
        root1 = solution.Convert(root1);
        TreeNode p = root1;
        System.out.print(p.val+" ");
        while (p.left!=null){
            p=p.left;
            System.out.print(p.val+" ");

        }
        System.out.println(" ");
        while (p!=null){
            System.out.print(p.val+" ");
            p=p.right;
        }
    }
}
