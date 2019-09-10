package com.leetcode.Tree;

import com.leetcode.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

/**
 * @author liubi
 * @date 2018-11-30 14:52
 **/
public class OfferSord32_21 {
    /**
     * 算法分析： 算法很简单 二叉树的层次遍历
     * @param root
     * @return
     */
    public ArrayList<Integer> PrintFromTopToBottom(TreeNode root) {
        Queue<TreeNode> levelOrder = new LinkedList<>();
        ArrayList<Integer> res = new ArrayList<>();
        if(root!= null){
            levelOrder.offer(root);
        }
        while(!levelOrder.isEmpty()){
            TreeNode treeNode = levelOrder.poll();
            res.add(treeNode.val);
            if(treeNode.left!=null){
                levelOrder.offer(treeNode.left);
            }
            if(treeNode.right!=null){
                levelOrder.offer(treeNode.right);
            }
        }
        return res;
    }

    public ArrayList<Integer> levelOrdetTravel(TreeNode root) {
        Queue<TreeNode> levelOrder = new LinkedList<>();
        ArrayList<Integer> res = new ArrayList<>();
        if(root==null){
            return res;
        }else {
            levelOrder.offer(root);
            while (!levelOrder.isEmpty()){
              TreeNode curr = levelOrder.poll();
              res.add(curr.val);
              if(curr.left!=null){
                  levelOrder.offer(curr.left);
              }
                if(curr.right!=null){
                    levelOrder.offer(curr.right);
                }
            }
        }
        return res;
    }
    public static void main(String[] args) {
        OfferSord32_21 solution = new OfferSord32_21();
    }
}
