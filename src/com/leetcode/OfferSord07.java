package com.leetcode;

import java.util.*;

/**
 * @author liubi
 * @date 2018-11-19 14:55
 **/
public class OfferSord07 {
    private void reConstruct(TreeNode root, int startIndex, int endIndex, int rootIndex, LinkedList<Integer> preQueue, int[] in){
        if(rootIndex<startIndex || rootIndex>endIndex || startIndex>endIndex) {
            return;
        }
        if(startIndex<rootIndex){
            root.left = new TreeNode(preQueue.pop());
            int newRootIndex = 0;
            for(int i = startIndex;i<rootIndex;i++){
                if(in[i] == root.left.val){
                    newRootIndex = i;
                    break;
                }
            }
            reConstruct(root.left,startIndex,rootIndex-1,newRootIndex,preQueue,in);
        }
        if(rootIndex<endIndex){
            root.right = new TreeNode(preQueue.pop());
            int newRootIndex = 0;
            for(int i = rootIndex+1;i<endIndex+1;i++){
                if(in[i] == root.right.val){
                    newRootIndex = i;
                    break;
                }
            }
            reConstruct(root.right,rootIndex+1,endIndex,newRootIndex,preQueue,in);
        }

    }
    public TreeNode reConstructBinaryTree(int [] pre,int [] in) {
        LinkedList<Integer> preQueue = new LinkedList<>();
        for(int i : pre){
            preQueue.offer(i);
        }
        int rootVal =  preQueue.pop();
        TreeNode root = new TreeNode(rootVal);
        // root node
        int rootIndex =0 ;
        for(int i=0;i<in.length;i++){
            if(in[i] == rootVal){
                rootIndex = i;
                break;
            }
        }
        reConstruct(root,0,in.length-1,rootIndex,preQueue,in);
        return root;
    }

    public static void main(String[] args) {
        OfferSord07 solution = new OfferSord07();
        int[] pre =  {1,2,3,4};
        int[] in = {4,3,2,1};
        TreeNode tree = solution.reConstructBinaryTree(pre,in);
        System.out.println(tree.val);
    }
}
