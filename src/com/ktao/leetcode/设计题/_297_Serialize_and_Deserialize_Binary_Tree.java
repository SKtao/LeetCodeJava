package com.ktao.leetcode.设计题;

import com.ktao.leetcode.树.层次遍历.TreeNode;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @author kongtao
 * @version 1.0
 * @description:
 * @date 2020/6/22
 **/
public class _297_Serialize_and_Deserialize_Binary_Tree {
    // BFS 序列化
    public String serialize(TreeNode root) {
        StringBuilder builder = new StringBuilder();
        LinkedList<TreeNode> stack = new LinkedList<>();
        stack.offer(root);
        while (!stack.isEmpty()) {
            TreeNode node = stack.poll();
            if (node != null) {
                builder.append(node.val);
                stack.offer(node.left);
                stack.offer(node.right);
            } else
                builder.append("#");
            builder.append(",");
        }
        return builder.toString();
    }
    // 反序列化
    public TreeNode deserialize(String data) {
        String[] splits = data.split(",");
        if (splits[0].equals("#"))
            return null;
        TreeNode root = new TreeNode(Integer.parseInt(splits[0]));
        LinkedList<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        for (int i = 1; i < splits.length; ++i) {
            TreeNode node = queue.poll();
            if (node == null)
                continue;
            if (!splits[i].equals("#")) {
                node.left = new TreeNode(Integer.parseInt(splits[i++]));
                queue.offer(node.left);
            } else
                ++i;
            if (!splits[i].equals("#")) {
                node.right = new TreeNode(Integer.parseInt(splits[i]));
                queue.offer(node.right);
            }
        }
        return root;
    }
}