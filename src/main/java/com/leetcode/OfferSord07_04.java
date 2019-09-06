package com.leetcode;

import java.util.*;


/**
 * @author liubi
 * @date 2018-11-19 14:55
 **/

public class OfferSord07_04 {
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
    public int find(int target,int []array){
        if(array==null||array.length==0){
            return -1;
        }else {
            for(int i=0;i<array.length;i++){
                if(array[i]==target){
                    return i;
                }
            }
            return -1;
        }
    }
    public int lowerBound(int target,int[] array){
        // 二分 只能用在有序情况
        if(array==null||array.length==0){
            return -1;
        }
        int first = 0;
        int last = array.length;
        while (first<last){
            int mid = first+(last-first)/2;
            if(target<array[mid]){
                last = mid;
            }else if(target==array[mid]){
                return mid;
            }else {
                first=mid+1;
            }
        }
        return first;
    }
    public TreeNode reConstructBinaryTree1(int [] pre,int [] in) {
        if(pre==null||in==null||pre.length==0||in.length==0){
            return null;
        }
        TreeNode root = new TreeNode(pre[0]);
        int index = find(pre[0],in);

        root.left = reConstructBinaryTree1(1<index+1?
                        Arrays.copyOfRange(pre,1,index+1):null
                ,Arrays.copyOfRange(in,0,index));
        root.right = reConstructBinaryTree1(index+1<pre.length?
                        Arrays.copyOfRange(pre,index+1,pre.length):null,
                index+1<in.length?
                        Arrays.copyOfRange(in,index+1,in.length):null);
        return root;
    }

    public static void main(String[] args) {
        OfferSord07_04 solution = new OfferSord07_04();
        int[] pre =  {1,2,4,3,5,6};
        int[] in = {4,2,1,5,3,6};
        TreeNode tree = solution.reConstructBinaryTree1(pre,in);
    }
}
