package com.leetcode;




import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class wangyiGame02 {
    static public class TreeNode {
        public String val;
        public TreeNode left;
        public TreeNode right;

        public static TreeNode buildTreeNode(String x) {
            if (!x.equals("null")) {
                return new TreeNode(x);
            } else {
                return null;
            }
        }

        private TreeNode(String x) {
            val = x;
        }

/*        TreeNode(String val, TreeNode left, TreeNode right) {
            this(val);
            this.left = left;
            this.right = right;
        }*/
    }

    public static TreeNode buildTree(String[] inOrder) {
        TreeNode root = null;
        if (inOrder != null && inOrder.length != 0) {
            root = TreeNode.buildTreeNode(inOrder[0]);
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int i = 0;
        while (i < inOrder.length) {
            TreeNode curr = queue.poll();
            if (curr == null) {
                return null;
            } else {
                if (++i < inOrder.length) {
                    curr.left = TreeNode.buildTreeNode(inOrder[i]);
                    queue.offer(curr.left);
                }
                if (++i < inOrder.length) {
                    curr.right = TreeNode.buildTreeNode(inOrder[i]);
                    queue.offer(curr.right);
                }
            }
        }
        return root;
    }

    static StringBuilder inOrderRes = new StringBuilder();

    public static void inOrderVisit(TreeNode root) {
        if (root == null) {
            return;
        }
        inOrderVisit(root.left);
        if (root.val != null) {
            inOrderRes.append(root.val);
        }
        inOrderVisit(root.right);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String inOrderString = sc.nextLine();
        // String inOrderString = "null,A,null,null";
        String[] inOrder = inOrderString.split(",");
        TreeNode root = buildTree(inOrder);
        inOrderVisit(root);
        if (inOrderRes.length() == 0) {
            System.out.println("null");
        } else {
            System.out.println(inOrderRes.toString());
        }
    }

}
