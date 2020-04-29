package com.ktao.leetcode.树.二叉树路径;

import com.ktao.leetcode.树.层次遍历.TreeNode;

/**
 * 404.左叶子之和
 * @author kongtao
 * @version 1.0
 * @description:
 * @date 2020/4/29
 **/
public class SumofLeftLeaves {
    /**
     * 计算给定二叉树的所有左叶子之和。
     *
     * 示例：
     *
     *     3
     *    / \
     *   9  20
     *     /  \
     *    15   7
     *
     * 在这个二叉树中，有两个左叶子，分别是 9 和 15，所以返回 24
     */
    private int leftSum = 0;
    public int sumOfLeftLeaves(TreeNode root) {
        if (root == null) return 0;
        if (root.left != null && (root.left.left != null || root.left.right != null)){
            sumOfLeftLeaves(root.left);
        }
        if (root.left != null && (root.left.left == null && root.left.right == null)){
            leftSum += root.left.val;
        }
        if (root.right != null && (root.right.left != null || root.right.right != null)){
            sumOfLeftLeaves(root.right);
        }
        return leftSum;
    }
}
