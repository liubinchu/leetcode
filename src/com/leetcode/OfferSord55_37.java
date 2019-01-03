package com.leetcode;

/**
 * @author liubi
 * @date 2018-12-27 21:39
 **/
public class OfferSord55_37 {
    /**
     * 解题分析：很简单的遍历二叉树的办法 除此之外没有别的办法 递归遍历（前中后），栈遍历（前中后），mirror遍历
     * 实现才用递归
     * 对于所有递归函数都通用的一个变量 设置为类成员/并且在每次第一次调用递归时初始化
     * 注意：
     * 递归遍历 自己的实现preOrderTraversal1 同 参考经典实现 preOrderTraversal2
     * preOrderTraversal2更加优美
     * preOrderTraversal2 先递归至树的底部，返回时 返回当前子树的深度， 自底向上
     * 自己的实现 preOrderTraversal1  自顶向下
     * 先访问当前节点（长度+1），再递归左右子树,这种做法需要用到一个全局变量 this.maxDeep
     */
    private int maxDeep ;
    private int preOrderTraversal1(TreeNode root , int currentDeep){
    if(root!=null){
        currentDeep++;
        if(currentDeep>this.maxDeep){
            this.maxDeep = currentDeep;
        }
        preOrderTraversal1(root.left,currentDeep);
        preOrderTraversal1(root.right,currentDeep);
    }
        return this.maxDeep;
    }

    private int preOrderTraversal2(TreeNode root){
        if(root == null){
            return 0;
        }
        else {
            int leftDeepth = preOrderTraversal2(root.left);
            int rightDeepth = preOrderTraversal2(root.right);
            return leftDeepth>rightDeepth? leftDeepth+1:rightDeepth+1;
        }
    }




    public int TreeDepth(TreeNode root) {
        this.maxDeep = 0; //在每次第一次调用递归时初始化该成员
        int deepth = preOrderTraversal2(root);
        return  deepth;
    }
    public static void main(String[] args) {
        OfferSord55_37 solution = new OfferSord55_37();
        TreeNode root1 = new TreeNode(8);
        root1.left = new TreeNode(8);
        root1.right = new TreeNode(7);
        root1.left.left = new TreeNode(9);
        root1.left.right = new TreeNode(2);
        root1.left.right.left = new TreeNode(4);
        root1.left.right.right =new TreeNode(7);

        TreeNode root2 = new TreeNode(8);
        root2.left = new TreeNode(9);
        root2.right = new TreeNode(2);
        System.out.println(solution.TreeDepth(root1));
        System.out.println(solution.TreeDepth(root2));
    }
}
