package com.ktao.leetcode.树.二叉树路径;

import com.ktao.leetcode.树.层次遍历.TreeNode;

/** 112.路径总和
 * @author kongtao
 * @version 1.0
 * @description:
 * @date 2020/4/29
 **/
public class PathSum {
    /**
     * 给定一个二叉树和一个目标和，判断该树中是否存在根节点到叶子节点的路径，这条路径上所有节点值相加等于目标和。
     *
     * 说明: 叶子节点是指没有子节点的节点。
     */
    public boolean hasPathSum(TreeNode root, int sum) {
        if (root == null) return false;
        return helper(root, sum);
    }

    private boolean helper(TreeNode root, int sum){
        if (root == null) return false;
        if (root.left == null && root.right == null) return sum == root.val;
        return helper(root.left, sum - root.val) || helper(root.right, sum - root.val);
    }
}
