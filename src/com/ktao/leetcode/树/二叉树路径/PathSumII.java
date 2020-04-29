package com.ktao.leetcode.树.二叉树路径;

import com.ktao.leetcode.树.层次遍历.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * 113. 路径总和II
 * @author kongtao
 * @version 1.0
 * @description:
 * @date 2020/4/29
 **/
public class PathSumII {
    /**
     * 给定一个二叉树和一个目标和，找到所有从根节点到叶子节点路径总和等于给定目标和的路径。
     *
     * 说明: 叶子节点是指没有子节点的节点。
     *
     * 示例:
     * 给定如下二叉树，以及目标和 sum = 22，
     */
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<List<Integer>> res = new ArrayList<>();
        helper(root, res, new ArrayList<>(), sum);
        return res;
    }

    private void helper(TreeNode root, List<List<Integer>>res, List<Integer> cur, int sum) {
        if (root == null) return;
        cur.add(root.val);
        if (root.left == null && root.right == null) {
            if (root.val != sum) return;
            res.add(new ArrayList<>(cur));
        }
        if (root.left != null) {
            helper(root.left, res, cur, sum - root.val);
            cur.remove(cur.size() - 1);
        }
        if (root.right != null) {
            helper(root.right, res, cur, sum - root.val);
            cur.remove(cur.size() - 1);
        }
    }
}
