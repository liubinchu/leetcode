package com.leetcode;

import java.util.ArrayList;
import java.util.List;

public class leetcode_102 {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        List<TreeNode> pre = new ArrayList<TreeNode>(); // 存储上一层节点的引用
        List<TreeNode> curr = new ArrayList<TreeNode>(); // 存储当前层节点的引用
        if(root == null) return res;
        else {
            List<Integer> column = new ArrayList<Integer>();
            column.add(root.val);
            res.add(column);
            pre.add(root);
        }
        while(!pre.isEmpty()){
            List<Integer> column = new ArrayList<Integer>();
            for(TreeNode node : pre){
                if(node.left!=null) {column.add(node.left.val); curr.add(node.left);}  // column 9
                if(node.right!=null) {column.add(node.right.val); curr.add(node.right);} // 9 20
            }
            res.add(column);
            pre.clear();
            pre.addAll(curr);
            curr.clear();
        }
        res.remove(res.size()-1);
        return res;
    }
}
