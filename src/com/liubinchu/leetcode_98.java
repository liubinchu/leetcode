package com.liubinchu;



public class leetcode_98 {
    // 如果 是一个合法的查找树 那么 最左节点 和 最右节点 会是最小最大值
    public int findleftest (TreeNode root){
        while(root.left!=null){
            root = root.left;
        }
        return root.val;
    }
    public int findrightest (TreeNode root){
        while(root.right!= null){
            root = root.right;
        }
        return root.val;
    }
    public boolean isValidBST(TreeNode root) {
        if(root == null) return true;
        else{
            if(root.left!=null){
                if(!isValidBST(root.left)) return false;  //验证子树合法性
                else if(findrightest(root.left)>=root.val) return false; // 比较大小
            }
            if(root.right!= null) {
                if(!isValidBST(root.right)) return false;
                else if(findleftest(root.right)<=root.val) return false;
            }
            return true;
        }

    }
}
