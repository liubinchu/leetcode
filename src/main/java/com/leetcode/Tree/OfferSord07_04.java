package com.leetcode.Tree;

import com.leetcode.TreeNode;
import com.leetcode.Search.SequenceSearch;

import java.util.Arrays;
import java.util.LinkedList;


/**
 * @author liubi
 * @date 2018-11-19 14:55
 **/

public class OfferSord07_04 {
    private void reConstruct(TreeNode root, int startIndex, int endIndex, int rootIndex, LinkedList<Integer> preQueue, int[] in) {
        if (rootIndex < startIndex || rootIndex > endIndex || startIndex > endIndex) {
            return;
        }
        if (startIndex < rootIndex) {
            root.left = new TreeNode(preQueue.pop());
            int newRootIndex = 0;
            for (int i = startIndex; i < rootIndex; i++) {
                if (in[i] == root.left.val) {
                    newRootIndex = i;
                    break;
                }
            }
            reConstruct(root.left, startIndex, rootIndex - 1, newRootIndex, preQueue, in);
        }
        if (rootIndex < endIndex) {
            root.right = new TreeNode(preQueue.pop());
            int newRootIndex = 0;
            for (int i = rootIndex + 1; i < endIndex + 1; i++) {
                if (in[i] == root.right.val) {
                    newRootIndex = i;
                    break;
                }
            }
            reConstruct(root.right, rootIndex + 1, endIndex, newRootIndex, preQueue, in);
        }

    }

    public TreeNode reConstructBinaryTree(int[] pre, int[] in) {
        LinkedList<Integer> preQueue = new LinkedList<>();
        for (int i : pre) {
            preQueue.offer(i);
        }
        int rootVal = preQueue.pop();
        TreeNode root = new TreeNode(rootVal);
        // root node
        int rootIndex = 0;
        for (int i = 0; i < in.length; i++) {
            if (in[i] == rootVal) {
                rootIndex = i;
                break;
            }
        }
        reConstruct(root, 0, in.length - 1, rootIndex, preQueue, in);
        return root;
    }


    public TreeNode reConstructBinaryTree1(int[] pre, int[] in) {
        if (pre == null || in == null || pre.length == 0 || in.length == 0) {
            return null;
        }
        TreeNode root = new TreeNode(pre[0]);
        int index = SequenceSearch.find(in, pre[0]);

        root.left = reConstructBinaryTree1(1 < index + 1 ?
                        Arrays.copyOfRange(pre, 1, index + 1) : null
                , Arrays.copyOfRange(in, 0, index));
        root.right = reConstructBinaryTree1(index + 1 < pre.length ?
                        Arrays.copyOfRange(pre, index + 1, pre.length) : null,
                index + 1 < in.length ?
                        Arrays.copyOfRange(in, index + 1, in.length) : null);
        return root;
    }


    private int[] pre;
    private int[] in;

    private TreeNode reConBinTreeCore(int preStart, int inStart, int len) {
        if (len == 0) {
            return null;
        } else {
            int rootVal = pre[preStart];
            TreeNode root = new TreeNode(rootVal);
            int indexIn = SequenceSearch.find(in, rootVal);
            int newLen = indexIn - inStart;
            root.left = reConBinTreeCore(preStart + 1, inStart, newLen);
            root.right = reConBinTreeCore(preStart + 1 + newLen, inStart + newLen + 1, len-1-newLen);
            return root;
        }
    }

    public TreeNode reConstructBinaryTree2(int[] pre, int[] in) {
        this.pre = pre;
        this.in = in;
        return reConBinTreeCore(0, 0, pre.length);
    }

    public static void main(String[] args) {
        OfferSord07_04 solution = new OfferSord07_04();
        int[] pre = {1, 2, 4, 7, 3, 5, 6, 8};
        int[] in = {4, 7, 2, 1, 5, 3, 8, 6};
        TreeNode tree = solution.reConstructBinaryTree2(pre, in);
       System.out.println( tree.right);
    }
}
