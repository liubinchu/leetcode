package com.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author liubi
 * @date 2019-04-02 20:39
 **/
public class baidu02 {
    public static  class TreeNode {
        public int val;
        public TreeNode left;
        public TreeNode right;

        TreeNode(int x) {
            val = x;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this(val);
            this.left = left;
            this.right = right;
        }
    }


    public static TreeNode conTree(int numNodes, List<Integer> values,
                                   List<List<Integer>> edges) {
        List<TreeNode> treeNodes = new ArrayList<>(values.size());
        for (int i = 0; i < values.size(); i++) {
            treeNodes.add(new TreeNode(values.get(i)));
        }
        for (List<Integer> edge : edges) {
            TreeNode node1 = treeNodes.get(edge.get(0)-1);
            TreeNode node2 = treeNodes.get(edge.get(1)-1);
            if (node1.left == null) {
                node1.left = node2;
            } else if (node1.right == null) {
                node1.right = node2;
            } else {
                // duplicate edge
            }
        }
        return treeNodes.get(0);
    }
    public static void main(String[] args){
        int n = 4;
        List<Integer> values1 = new ArrayList<>();
        values1.add(-1);
        values1.add(2);
        values1.add(3);
        values1.add(2);
        List<List<Integer>> edges = new ArrayList<>();
        List<Integer> edge1 = new ArrayList<>();
        edge1.add(1);
        edge1.add(2);
        edges.add(edge1);
        List<Integer> edge2 = new ArrayList<>();
        edge2.add(1);
        edge2.add(3);
        edges.add(edge2);
        List<Integer> edge3 = new ArrayList<>();
        edge3.add(3);
        edge3.add(4);
        edges.add(edge3);

    }
}

// METHOD SIGNATURE ENDS

