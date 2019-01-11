package com.leetcode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author liubi
 * @date 2019-01-11 15:55
 **/
public class OfferSord37_60 {
    /**
     * 算法思想：二叉树遍历的变形
     * @param root
     * @return
     */
    String Serialize(TreeNode root) {
        StringBuilder serializeSb = new StringBuilder();
        Queue<TreeNode> levelTraversal = new LinkedList<>();
        if (root != null) {
            levelTraversal.offer(root);
            TreeNode current = null;
            while (!levelTraversal.isEmpty()) {
                current = levelTraversal.poll();
                if (current != null) {
                    levelTraversal.offer(current.left);
                    levelTraversal.offer(current.right);
                    serializeSb.append(current.val);
                    serializeSb.append(",");
                } else {
                    serializeSb.append("#,");
                    //represent null element
                }
            }
        }
        return serializeSb.toString();
    }

    TreeNode Deserialize(String str) {
        TreeNode treeNode = null;
        if (str.length() != 0) {
            int index = 0;
            String[] strings = str.split(",");
            treeNode = new TreeNode(Integer.parseInt(strings[index]));
            Queue<TreeNode> previous = new LinkedList<>();
            Queue<TreeNode> current = new LinkedList<>();
            previous.offer(treeNode);
            TreeNode currentNode = null;
            String leftVal = null;
            String rightVal = null;
            while (index < strings.length - 1) {
                while (!previous.isEmpty()) {
                    currentNode = previous.poll();
                    if(index < strings.length-1){
                        leftVal = strings[++index];
                        System.out.println(leftVal);
                        if (!"#".equals(leftVal)) {
                            currentNode.left = new TreeNode(Integer.parseInt(leftVal));
                            current.offer(currentNode.left);
                        }
                    }
                    if(index < strings.length-1){
                        rightVal = strings[++index];
                        System.out.println(rightVal);
                        if (!"#".equals(rightVal)) {
                            currentNode.right = new TreeNode(Integer.parseInt(rightVal));
                            current.offer(currentNode.right);
                        }
                    }
                }
                previous = current;
                current = new LinkedList<>();
            }
        }
        return treeNode;
    }

    public static void main(String[] args) {
        OfferSord37_60 solution = new OfferSord37_60();
        /*
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
        t3.right = t5;
        t4.left = t6;
        t5.right = t7;
        */
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
        System.out.println(solution.Serialize(t1));

        TreeNode treeNode = solution.Deserialize(solution.Serialize(t1));
        System.out.println(treeNode);
        //treeNode.val = 1;
    }
}