package com.leetcode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * @author liubi
 * @date 2018-12-03 11:04
 **/
class DataLogger{
    ArrayList<Integer> path ;
    TreeNode root;
    int reserved;
    DataLogger(int path, TreeNode root, int reserved){
        this.path = new ArrayList<>();
        this.path.add(path);
        this.root = root;
        this.reserved = reserved;
    }
    DataLogger(ArrayList<Integer> path , TreeNode root,int reserved){
        this.path = path;
        this.reserved = reserved;
        this.root = root;
    }
}
public class OfferSord34_23 {
    public ArrayList<ArrayList<Integer>> FindPath(TreeNode root,int target) {
        ArrayList<ArrayList<Integer>> res = new ArrayList<>();
        Stack<ArrayList<Integer>> result = new Stack<ArrayList<Integer>>();
        if(root == null||root.val>target) {
            return res;
        }
        Queue<DataLogger> BFSQueue = new LinkedList<>();
        BFSQueue.offer(new DataLogger(root.val,root,target - root.val));
        while(!BFSQueue.isEmpty()){
            DataLogger curent = BFSQueue.poll();
            if(curent.root.left==null && curent.root.right==null && curent.reserved==0){
                result.push(curent.path);
            }
            else if(curent.root.left!= null && curent.root.left.val<=curent.reserved){
                ArrayList<Integer> path = (ArrayList<Integer>) curent.path.clone();
                path.add(curent.root.left.val);
                DataLogger left = new DataLogger(path, curent.root.left, curent.reserved-curent.root.left.val);
                BFSQueue.offer(left);
            }
            if(curent.root.right!=null&& curent.root.right.val<=curent.reserved){
                ArrayList<Integer> path = (ArrayList<Integer>) curent.path.clone();
                path.add(curent.root.right.val);
                DataLogger right = new DataLogger(path, curent.root.right, curent.reserved-curent.root.right.val);
                BFSQueue.offer(right);
            }
        }
        while(!result.empty()){
            res.add(result.pop());
        }
        return res;
    }
    public static void main(String[] args) {
        OfferSord34_23 solution = new OfferSord34_23();
        TreeNode root = new TreeNode(10);
        root.left = new TreeNode(5);
        root.right = new TreeNode(12);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(7);
        ArrayList<ArrayList<Integer>> res = solution.FindPath(root,22);
    }
}
