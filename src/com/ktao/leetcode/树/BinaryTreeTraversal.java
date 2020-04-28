package com.ktao.leetcode.树;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * 二叉树遍历(前中后)
 * @version 1.0
 * @author: kongtao
 * @description:
 * @date: 2020/4/27 9:28 上午
 */
public class BinaryTreeTraversal {

    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) {
            val = x;
        }
    }

    // 前序遍历
    public List<Integer> preorderTraversal(TreeNode root) {
        Stack<TreeNode> stack = new Stack<TreeNode>();
        List<Integer> res = new ArrayList<>();
        while (root != null || !stack.isEmpty()){
            while (root != null){
                stack.push(root);
                res.add(root.val);
                root = root.left;
            }
            TreeNode cur = stack.pop();
            root = cur.right;
        }
        return res;
    }

    // 中序遍历
    public List<Integer> inorderTraversal(TreeNode root) {
        Stack<TreeNode> stack = new Stack<TreeNode>();
        List<Integer> res = new ArrayList<>();
        while (!stack.isEmpty() || root != null){
            while (root != null){
                stack.push(root);
                root = root.left;
            }
            TreeNode cur = stack.pop();
            res.add(cur.val);
            root = cur.right;
        }
        return res;
    }

    // 后序遍历
}
