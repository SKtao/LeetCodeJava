package com.ktao.leetcode.树.层次遍历;

import java.util.*;

/**
 * 103. 二叉树的锯齿形层次遍历
 * @author kongtao
 * @version 1.0
 * @description:
 * @date 2020/4/28
 **/
public class BinaryTreeZigzagLevelOrderTraversal {
    /**
     * 给定一个二叉树，返回其节点值的锯齿形层次遍历。（即先从左往右，再从右往左进行下一层遍历，以此类推，层与层之间交替进行）。
     *
     * 例如：
     * 给定二叉树 [3,9,20,null,null,15,7],
     *
     *     3
     *    / \
     *   9  20
     *     /  \
     *    15   7
     * 返回锯齿形层次遍历如下：
     *
     * [
     *   [3],
     *   [20,9],
     *   [15,7]
     * ]
     */

    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null) return res;
        List<TreeNode> list = new LinkedList<>();
        list.add(root);
        boolean left2Right = true;
        while (!list.isEmpty()){
            int size = list.size();
            List<Integer> curLevel = new ArrayList<>();
            for (int i = 0; i < size; i++) {
                if (left2Right) {
                    TreeNode node = list.remove(0);
                    curLevel.add(node.val);
                    // 尾插
                    if (node.left != null) list.add(node.left);
                    if (node.right != null) list.add(node.right);
                } else {
                    TreeNode node = list.remove(list.size() - 1);
                    curLevel.add(node.val);
                    // 头插
                    if (node.right != null) list.add(0, node.right);
                    if (node.left != null) list.add(0, node.left);
                }
            }
            res.add(curLevel);
            left2Right = !left2Right;
        }
        return res;
    }
}
