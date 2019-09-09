package com.leetcode;


import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class qianxin02 {

    private static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    private static TreeNode fun(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) {
            return null;
        }
        if (root.val == p.val || root.val == q.val) {
            return root;
        }
        if (root.val >= p.val && root.val <= q.val) {
            return root;
        }
        if (root.val <= p.val && root.val >= q.val) {
            return root;
        }
        if (root.left == null && root.right == null) {
            return null;
        }


        if (root.val >= p.val && root.val >= q.val) {
            return fun(root.left, p, q);
        } else {
            return fun(root.right, p, q);
        }
    }

    private static List<Integer> nodes;
    private static TreeNode[] TreeNodeList;

    private static void buildTree(List<Integer> nodes) {
        if (nodes.size() <= 0) {
            return;
        }

        TreeNodeList = new TreeNode[nodes.size()];
        for (int i = 0; i <= nodes.size() - 1; i++) {
            if (nodes.get(i) != -1) {
                if (TreeNodeList[i] == null) {
                    TreeNodeList[i] = new TreeNode(nodes.get(i));
                }
                int j = 2 * i + 1;
                if (j <= nodes.size() - 1
                        && nodes.get(j) != -1) {
                    TreeNodeList[j] = new TreeNode(
                            nodes.get(j));
                    TreeNodeList[i].left = TreeNodeList[j];
                } else {
                    TreeNodeList[i].left = null;
                }

                j++;
                if (j <= nodes.size() - 1
                        && nodes.get(j) != -1) {
                    TreeNodeList[j] = new TreeNode(
                            nodes.get(j));
                    TreeNodeList[i].right = TreeNodeList[j];
                } else {
                    TreeNodeList[i].right = null;
                }
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int level = Integer.parseInt(sc.nextLine());
        String tmp = sc.nextLine();
        nodes = new ArrayList<>();
        for (String t : tmp.split(" ")) {
            nodes.add(Integer.parseInt(t));
        }
        int pInt = sc.nextInt();
        int qInt = sc.nextInt();
        buildTree(nodes);
        TreeNode res = fun(TreeNodeList[0], TreeNodeList[pInt], TreeNodeList[qInt]);
        System.out.println(res.val);
    }
}
