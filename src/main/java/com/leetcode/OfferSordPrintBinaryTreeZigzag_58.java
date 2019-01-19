package com.leetcode;

import java.util.ArrayList;

/**
 * @author liubi
 * @date 2019-01-11 10:13
 **/
public class OfferSordPrintBinaryTreeZigzag_58 {
    /**
     * 算法分析：二叉树的层次遍历 变形
     * @param pRoot
     * @return
     */
    public ArrayList<ArrayList<Integer>> Print(TreeNode pRoot) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        if(pRoot!=null){
            ArrayList<TreeNode> currentList = new ArrayList<>();
            ArrayList<TreeNode> nextList = new ArrayList<>();
            boolean reverseOrder = false;
            currentList.add(pRoot);
            while (!currentList.isEmpty()){
                // 顺序遍历 得到下层节点
                for(TreeNode treeNode : currentList){
                    if(treeNode.left!=null){
                        nextList.add(treeNode.left);
                    }
                    if(treeNode.right!=null){
                        nextList.add(treeNode.right);
                    }
                }
                ArrayList<Integer> currentRes = new ArrayList<>();
                // zigZag 遍历，得到当前结果
                if(!reverseOrder){
                    for(int i=0;i<currentList.size();i++){
                        currentRes.add(currentList.get(i).val);
                    }
                }
                else {
                    for(int i=currentList.size()-1;i>=0;i--){
                        currentRes.add(currentList.get(i).val);
                    }
                }
                // 反转flag
                reverseOrder = !reverseOrder;
                result.add(currentRes);
                currentList = (ArrayList<TreeNode>) nextList.clone();
                nextList.clear();
            }
        }
        return result;
    }
    public static void main(String[] args) {
        OfferSordPrintBinaryTreeZigzag_58 solution = new OfferSordPrintBinaryTreeZigzag_58();
        TreeNode t1 = new TreeNode(1);
        TreeNode t2 = new TreeNode(2);
        TreeNode t3 = new TreeNode(3);
        TreeNode t4 = new TreeNode(4);
        TreeNode t5 = new TreeNode(5);
        TreeNode t6 = new TreeNode(6);
        TreeNode t7 = new TreeNode(7);
        TreeNode t8 = new TreeNode(8);
        t1.left = t2;
        t1.right = t3;
        t2.left = t4;
        t2.right = t5;
        t3.left = t6;
        t3.right = t7;
        t4.left = t8;
        System.out.println(solution.Print(t1));
    }
}
