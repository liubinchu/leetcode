package com.leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * @author liubi
 * @date 2018-12-09 21:35
 **/
public class OfferSord36_25 {
    /**思路一：
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
            //ConvertFun(pRootOfTree,null,null);
            ConvertFun(pRootOfTree);
        }
        return findLeftest(pRootOfTree);
    }

    /**
     * 思路二： 利用二叉搜索树的中序 遍历顺序就是 元素的排列顺序 因此 在中序遍历的基础上进行指针变化
     * 引申：二叉搜索树的线索话 也可以类似实现
     * @param root
     */
    public void midOrderSearch(TreeNode root){
        // 原始的中序遍历
        if(root == null){
            return;
        }
        midOrderSearch(root.left);
        System.out.println(root.val);
        midOrderSearch(root.right);
    }
    TreeNode lastNodeInList = null;
    public void ConvertFun(TreeNode root){
        if(root == null){
            return;
        }
        ConvertFun(root.left);
        // 将中序遍历的 遍历 部分 改为 更改指针的部分
        root.left = lastNodeInList;
        if(lastNodeInList!= null){
            lastNodeInList.right = root;
        }
        lastNodeInList = root;
        // 将中序遍历的 遍历 部分 改为 更改指针的部分

        ConvertFun(root.right);
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
        //solution.midOrderSearch(root1);
        root1 = solution.Convert(root1);
        while(root1!=null){
            System.out.println(root1.val);
            root1 = root1.right;
        }
    }
}
