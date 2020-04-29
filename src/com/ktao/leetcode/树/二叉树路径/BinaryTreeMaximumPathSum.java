package com.ktao.leetcode.树.二叉树路径;

import com.ktao.leetcode.树.层次遍历.TreeNode;

/**
 * @author kongtao
 * @version 1.0
 * @description:
 * @date 2020/4/29
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
     *
     * 输出: 42
     */
    private int maxSum = Integer.MIN_VALUE;
    public int maxPathSum(TreeNode root) {
        helper(root);
        return maxSum;
    }

    private int helper(TreeNode root){
        if (root == null) return 0;
        int leftSum = Math.max(helper(root.left), 0);
        int rightSum = Math.max(helper(root.right), 0);
        int sum = root.val + leftSum + rightSum;
        maxSum = Math.max(maxSum, sum);
        return Math.max(leftSum, rightSum) + root.val;
    }
}
