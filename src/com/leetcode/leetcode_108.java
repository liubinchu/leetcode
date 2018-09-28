package com.leetcode;

public class leetcode_108 {
    public TreeNode createBalanceSearchTree(int i,int j, int[] nums){
        if(j<i) return null;
        int mid = (i+j)/2;
        TreeNode root = new TreeNode(nums[mid]);
        if(i == j) return root;
        else {
            //if(i<=mid-1)  //  if(j<i) return null; 代替了其作用
            root.left = createBalanceSearchTree(i,mid-1,nums);
            //if(mid+1<=j)
            root.right = createBalanceSearchTree(mid+1,j,nums);
            return root;
        }
    }
    public TreeNode sortedArrayToBST(int[] nums) {
        return createBalanceSearchTree(0,nums.length-1,nums);
    }
}
