package com.ktao.leetcode.树.二叉树路径;

import com.ktao.leetcode.树.层次遍历.TreeNode;

/**
 * 129.求根到叶子节点数字之和
 * @author kongtao
 * @version 1.0
 * @description:
 * @date 2020/4/29
 **/
public class SumRoottoLeafNumbers {
    /**
     * 给定一个二叉树，它的每个结点都存放一个 0-9 的数字，每条从根到叶子节点的路径都代表一个数字。
     *
     * 例如，从根到叶子节点路径 1->2->3 代表数字 123。
     *
     * 计算从根到叶子节点生成的所有数字之和。
     *
     * 说明: 叶子节点是指没有子节点的节点。
     *
     * 示例 1:
     *
     * 输入: [1,2,3]
     *     1
     *    / \
     *   2   3
     * 输出: 25
     * 解释:
     * 从根到叶子节点路径 1->2 代表数字 12.
     * 从根到叶子节点路径 1->3 代表数字 13.
     * 因此，数字总和 = 12 + 13 = 25.
     */
    private int sum = 0;
    public int sumNumbers(TreeNode root) {
        if (root == null) return sum;
        helper(root, 0);
        return sum;
    }

    private void helper(TreeNode root, int curSum){
        if (root.left == null && root.right == null){
            curSum = curSum*10 + root.val;
            sum += curSum;
        }
        if (root.left != null) helper(root.left, curSum*10 + root.val);
        if (root.right != null) helper(root.right, curSum*10 + root.val);
    }
}
