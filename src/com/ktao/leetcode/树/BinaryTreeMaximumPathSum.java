package com.ktao.leetcode.树;

/**
 * @author kongtao
 * @version 1.0
 * @description: 124.二叉树中的最大路径和
 * @date 2020/4/17
 **/
public class BinaryTreeMaximumPathSum {
    /**
     * 给定一个非空二叉树，返回其最大路径和。
     *
     * 本题中，路径被定义为一条从树中任意节点出发，达到任意节点的序列。该路径至少包含一个节点，且不一定经过根节点。
     *
     * 示例 1:
     *
     * 输入: [1,2,3]
     *
     *        1
     *       / \
     *      2   3
     *
     * 输出: 6
     * 示例 2:
     *
     * 输入: [-10,9,20,null,null,15,7]
     *
     *    -10
     *    / \
     *   9  20
     *     /  \
     *    15   7
     */
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) {
            val = x;
        }
    }

    private int maxSum = Integer.MIN_VALUE;
    public int maxPathSum(TreeNode root) {
        find(root);
        return maxSum;
    }

    private int find(TreeNode root){
        if (root == null) return 0;
        int left = Math.max(0, find(root.left));
        int right = Math.max(0, find(root.right));
        maxSum = Math.max(maxSum, left + right + root.val);
        return root.val + Math.max(left, right);
    }
}
