package com.leetcode.Tree;

import com.leetcode.TreeNode;

import java.util.Stack;

/**
 * @author liubi
 * @date 2019-09-12 18:26
 **/
public class DFSByStack {
    public void dfs(TreeNode root) {
        Stack<TreeNode> dfsStack = new Stack<>();
        if (root != null) {
            dfsStack.push(root);
        }
        while (!dfsStack.empty()) {
            TreeNode current = dfsStack.pop();
            // visit
            if (current.left != null) {
                dfsStack.push(current.left);
            }
            if (current.right != null) {
                dfsStack.push(current.right);
            }
        }
    }

    public static void main(String[] args) {
        while (true) {
            new Thread();
            new Integer(10);
        }
    }
}
