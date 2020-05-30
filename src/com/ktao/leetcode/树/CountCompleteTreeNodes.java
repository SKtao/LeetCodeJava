package com.ktao.leetcode.树;

import com.ktao.leetcode.树.层次遍历.TreeNode;

/**
 * @author kongtao
 * @version 1.0
 * @description:
 * @date 2020/5/27
 **/
public class CountCompleteTreeNodes {
    /**
     * 给出一个完全二叉树，求出该树的节点个数。
     *
     * 说明：
     *
     * 完全二叉树的定义如下：在完全二叉树中，除了最底层节点可能没填满外，其余每层节点数都达到最大值，并且最下面一层的节点都集中在该层最左边的若干位置。若最底层为第 h 层，则该层包含 1~ 2h 个节点。
     *
     * 示例:
     *
     * 输入:
     *     1
     *    / \
     *   2   3
     *  / \  /
     * 4  5 6
     *
     * 输出: 6
     */

    /**
     * 思路：完全二叉树，可能是完美二叉树或者非完美二叉树
     * 1. 若为完美二叉树：总节点数 = 2^h - 1, h为完美二叉树高度
     * 2. 若为非完美二叉树：则一个个计算
     */
    public int countNodes(TreeNode root) {
        if (root == null) return 0;
        int leftH = 1, rightH = 1;
        TreeNode pNode = root;
        while (pNode.left != null){
            leftH++;
            pNode = pNode.left;
        }
        pNode = root;
        while (pNode.right != null){
            rightH++;
            pNode = pNode.right;
        }
        if (leftH == rightH) return (int)Math.pow(2, leftH) - 1;
        return countNodes(root.left) + countNodes(root.right) + 1;
    }
}
