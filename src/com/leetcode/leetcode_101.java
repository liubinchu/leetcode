package com.leetcode;

import java.util.ArrayList;
import java.util.List;

public class leetcode_101 {
    // 思路 层次遍历二叉树 每一层 判断回文
    public boolean isSymmetric(TreeNode root) {
        List<TreeNode> pre = new ArrayList<TreeNode>(); // 存储上一层节点的引用
        List<TreeNode> curr = new ArrayList<TreeNode>(); // 存储当前层节点的引用
        if(root == null) return true;
        else pre.add(root); // root 节点不用判断
        while(!pre.isEmpty()){
            List<Integer> column = new ArrayList<Integer>();
            for(TreeNode node : pre){
                if(node.left!=null) {column.add(node.left.val); curr.add(node.left);} //2 null
                else column.add(null);
                if(node.right!=null) {column.add(node.right.val); curr.add(node.right);}
                else column.add(null);
            }
            // 检查回文
            int counter = column.size()/2;
            int j = column.size()-1;
            for(int i=0; i<counter;i++, j--){
                if(column.get(i) != column.get(j)) return false;
            }
            pre.clear();
            pre.addAll(curr);
            curr.clear();
        }
        return true;
    }
}
