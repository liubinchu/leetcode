package com.leetcode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

/**
 * @author liubi
 * @date 2019-01-11 10:47
 **/
public class OfferSordPrintBinaryTree_59 {
    ArrayList<ArrayList<Integer>> Print(TreeNode pRoot) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        if(pRoot!=null){
            Queue<TreeNode> levelTraverse = new LinkedList<>();
            levelTraverse.offer(pRoot);
            levelTraverse.offer(null);
            ArrayList<Integer> currentRes = new ArrayList<>();
            while (!(levelTraverse.peek()==null&&levelTraverse.size()==1)){
                TreeNode current = levelTraverse.poll();
                if(current==null){
                    result.add(currentRes);
                    currentRes = new ArrayList<>();
                    levelTraverse.offer(null);
                }
                else {
                    currentRes.add(current.val);
                    if(current.left!=null){
                        levelTraverse.offer(current.left);
                    }
                    if (current.right!=null){
                        levelTraverse.offer(current.right);
                    }
                }
            }
            result.add(currentRes);
        }
        return result;
    }
    public static void main(String[] args) {
        OfferSordPrintBinaryTree_59 solution = new OfferSordPrintBinaryTree_59();
        TreeNode t1 = new TreeNode(1);
        TreeNode t2 = new TreeNode(2);
        TreeNode t3 = new TreeNode(3);
        TreeNode t4 = new TreeNode(4);
        TreeNode t5 = new TreeNode(5);
        TreeNode t6 = new TreeNode(6);
        TreeNode t7 = new TreeNode(7);
        TreeNode t8 = new TreeNode(8);
        t1.left = t2;
        t1.right = t3;
        t2.left = t4;
        t2.right = t5;
        t3.left = t6;
        t3.right = t7;
        t4.left = t8;
        System.out.println(solution.Print(t1));
    }
}
