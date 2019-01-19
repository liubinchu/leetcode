package com.leetcode;

/**
 * @author liubi
 * @date 2019-01-11 15:20
 **/
public class OfferSord54_61 {
    private int index = 0;
    private TreeNode wanted = null;
    private int target = 0;

    private void midOrderTraversal(TreeNode pRoot) {
        if (pRoot.left != null) {
            midOrderTraversal(pRoot.left);
        }

        this.index++;

        if (this.index < this.target) {
            if (pRoot.right != null) {
                midOrderTraversal(pRoot.right);
            }
        } else if (this.index == this.target) {
            this.wanted = pRoot;
        }
    }

    /**
     * 算法分析：时间复杂度O（k）,二叉搜索树中序遍历即为有序，本题是中序遍历的变形
     * @param pRoot
     * @param k
     * @return
     */
    public TreeNode KthNode(TreeNode pRoot, int k) {
        if (pRoot == null) {
            return null;
        } else {
            this.target = k;
            midOrderTraversal(pRoot);
            return this.wanted;
        }

    }

    public static void main(String[] args) {
        OfferSord54_61 solution = new OfferSord54_61();
        solution.KthNode(null, 0);
    }
}
