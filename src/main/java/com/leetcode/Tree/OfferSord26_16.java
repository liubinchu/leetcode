package com.leetcode.Tree;

import com.leetcode.TreeNode;

/**
 * @author liubi
 * @date 2018-11-29 14:16
 **/
public class OfferSord26_16 {
    /**
     * 算法分析：分成两步 第一步 两个树中 根节点相同的位置
     * 第二步 判断是否是子树一 是否包含树2
     * 一开始自己的想法尽管思路 一样 但是没有分成两步 所以 思考起来 很复杂 因此 一个启示： 可以将算法 分解成 若干子部分 便于思考
     * 第二步 判断是否是子树一 是否包含树2 时：
     * 一开始的思路 是判断 两个子树的左右节点 是否相同 但是 这样 需要考虑 左右节点是否为空的情况
     * 实际上 可以 将左右节点的判断 放到 递归之下一层 时 他变成 根节点 时再进行判断。
     *
     * @param root1
     * @param root2
     * @return
     */
    private boolean isTree1ContainTree2(TreeNode root1, TreeNode root2) {
        if (root2 == null) {
            //root2== null root1 == null || root1!= null
            return true;
        } else if (root1 == null) {
            //root2！= null && root1 ==null
            return false;
        } else {
            // root2 != null && root1 != null
            if (root1.val != root2.val) {
                return false;
            } else {
                return isTree1ContainTree2(root1.right, root2.right)
                        &&
                        isTree1ContainTree2(root1.left, root2.left);
            }
        }
    }

    public boolean HasSubtree(TreeNode root1, TreeNode root2) {
        if (root1 == null || root2 == null) {
            return false;
        } else if (root1.val == root2.val && isTree1ContainTree2(root1, root2)) {
            return true;
        } else {
            return HasSubtree(root1.left, root2)
                    ||
                    HasSubtree(root1.right, root2);
        }
    }

    public boolean root1ContainsRoot2(TreeNode root1, TreeNode root2) {
        if (root2 == null) {
            return true;
        }
        if (root1 == null) {// root2 != null,  root1==null
            return false;
        }
        if (root1.val == root2.val) {
            return root1ContainsRoot2(root1.left, root2.left)
                    && root1ContainsRoot2(root1.right, root2.right);
        } else {
            return false;
        }
    }

    public boolean HasSubtree1(TreeNode root1, TreeNode root2) {
        if (root2 == null || root1 == null) {
            return false;
        }
        if (root1ContainsRoot2(root1, root2)) {
            return true;
        } else {
            return root1ContainsRoot2(root1.left, root2)
                    || root1ContainsRoot2(root1.right, root2);
        }
    }

    public static void main(String[] args) {
        TreeNode root1 = new TreeNode(8);
        root1.left = new TreeNode(8);
        root1.right = new TreeNode(7);
        root1.left.left = new TreeNode(9);
        root1.left.right = new TreeNode(2);
        root1.left.right.left = new TreeNode(4);
        root1.left.right.right = new TreeNode(7);

        TreeNode root2 = new TreeNode(8);
        root2.left = new TreeNode(9);
        root2.right = new TreeNode(2);
        OfferSord26_16 solution = new OfferSord26_16();
        System.out.println(solution.HasSubtree1(root1, root2));
    }
}
