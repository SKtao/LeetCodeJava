package com.ktao.leetcode.树;

import com.ktao.leetcode.树.层次遍历.TreeNode;

/**
 * 226. 翻转二叉树
 * @author kongtao
 * @version 1.0
 * @description:
 * @date 2020/5/30
 **/
public class InvertBinaryTree {
    /**
     * 翻转一棵二叉树。
     *
     * 示例：
     *
     * 输入：
     *
     *      4
     *    /   \
     *   2     7
     *  / \   / \
     * 1   3 6   9
     * 输出：
     *
     *      4
     *    /   \
     *   7     2
     *  / \   / \
     * 9   6 3   1
     *
     */
    public TreeNode invertTree(TreeNode root) {
        if (root == null) return root;
        TreeNode left = invertTree(root.left);
        TreeNode right = invertTree(root.right);
        root.left = right;
        root.right = left;
        return root;
    }
}
