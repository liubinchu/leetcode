package com.leetcode;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author liubi
 * @date 2019-05-14 20:34
 **/
public class leetcode_226 {
    private void invertCore(TreeNode root){
        if(root==null){
            return;
        }
        else {
            TreeNode temp = root.left;
            root.left = root.right;
            root.right = temp;
            invertCore(root.left);
            invertCore(root.right);
        }
    }
    public TreeNode invertTree(TreeNode root) {
        invertCore(root);
        return root;
    }
    public static int tyrTest(){
        try {
            System.out.println("try test");
            return 1;
        }finally {
            System.out.println("finally");
        }
    }
    public static void main(String[] args) throws InterruptedException {
        leetcode_226 solution = new leetcode_226();
        Lock lock = new ReentrantLock();
        Condition condition = lock.newCondition();
        condition.await();
        condition.awaitNanos(100);
        tyrTest();


    }
}
