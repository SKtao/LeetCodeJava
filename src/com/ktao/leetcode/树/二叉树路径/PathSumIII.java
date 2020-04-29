package com.ktao.leetcode.树.二叉树路径;

import com.ktao.leetcode.树.层次遍历.TreeNode;

/**
 * 437.路径总和 III
 * @author kongtao
 * @version 1.0
 * @description:
 * @date 2020/4/29
 **/
public class PathSumIII {
    /**
     *给定一个二叉树，它的每个结点都存放着一个整数值。
     *
     * 找出路径和等于给定数值的路径总数。
     *
     * 路径不需要从根节点开始，也不需要在叶子节点结束，但是路径方向必须是向下的（只能从父节点到子节点）。
     *
     * 二叉树不超过1000个节点，且节点数值范围是 [-1000000,1000000] 的整数。
     */
    public int pathSum(TreeNode root, int sum) {
        if (root == null) return 0;
        return dfs(root, sum) + pathSum(root.left, sum) + pathSum(root.right, sum);
    }

    private int dfs(TreeNode root, int sum){
        if (root == null) return 0;
        sum -= root.val;
        return (sum == 0 ? 1 : 0) + dfs(root.left, sum) + dfs(root.right, sum);
    }
}
