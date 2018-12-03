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
    /**
     * 算法分析： 采用BFS 的方法 遍历二叉树 遍历时 记录 访问到目前节点的path 还需要凑的数字 以及当前节点
     * 路径结果 入栈顺序 按照 路径长度从小到大的顺序/ BFS 的特点
     * T : O(n)
     * S : O(n*m) m为路径的平均长度
     * 思路二： 剑指offer 书中采用先序遍历的办法  但是路径的入栈顺序同路径的长度无关 因为深度优先
     * 实际上 只要采用 先访问到根节点的遍历方法 都可以实现
     * @param root
     * @param target
     * @return
     */
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
