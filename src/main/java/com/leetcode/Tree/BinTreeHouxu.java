package com.leetcode.Tree;

import com.leetcode.ListNode;
import com.leetcode.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author liubi
 * @date 2019-09-08 11:20
 **/
public class BinTreeHouxu {
    List<Integer> res = new ArrayList<>();

    public void houxubianli(TreeNode root) {
        if(root==null){
            return;
        }else {
            houxubianli(root.left);
            houxubianli(root.right);
            res.add(root.val);
        }
    }
}
