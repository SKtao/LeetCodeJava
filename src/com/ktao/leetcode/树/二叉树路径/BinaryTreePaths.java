package com.ktao.leetcode.树.二叉树路径;

import com.ktao.leetcode.树.层次遍历.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * 257. 二叉树的所有路径
 * @author kongtao
 * @version 1.0
 * @description:
 * @date 2020/4/29
 **/
public class BinaryTreePaths {
    /**
     * 给定一个二叉树，返回所有从根节点到叶子节点的路径。
     *
     * 说明: 叶子节点是指没有子节点的节点。
     *
     * 示例:
     *
     * 输入:
     *
     *    1
     *  /   \
     * 2     3
     *  \
     *   5
     *
     * 输出: ["1->2->5", "1->3"]
     *
     * 解释: 所有根节点到叶子节点的路径为: 1->2->5, 1->3
     */
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> res = new ArrayList<>();
        if (root == null) return res;
        helper(root, res, "");
        return res;
    }
    private void helper(TreeNode root, List<String> res, String cur){
        if (root.left == null && root.right == null){
            cur = cur + root.val;
            res.add(new String(cur));
        }
        if (root.left != null){
            helper(root.left, res, cur + root.val + "->");
        }
        if (root.right != null){
            helper(root.right, res, cur + root.val + "->" );
        }
    }
}
