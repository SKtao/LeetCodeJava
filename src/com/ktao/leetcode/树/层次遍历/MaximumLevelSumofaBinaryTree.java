package com.ktao.leetcode.树.层次遍历;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 1161. 最大层内元素和
 * @author kongtao
 * @version 1.0
 * @description:
 * @date 2020/4/28
 **/
public class MaximumLevelSumofaBinaryTree {
    /**
     * 给你一个二叉树的根节点 root。设根节点位于二叉树的第 1 层，而根节点的子节点位于第 2 层，依此类推。
     *
     * 请你找出层内元素之和 最大 的那几层（可能只有一层）的层号，并返回其中 最小 的那个。
     */
    public int maxLevelSum(TreeNode root) {
        if (root == null) return 0;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int maxLevelSum = Integer.MIN_VALUE;
        int maxLevel = 0;
        int curLevel = 0;
        while (!queue.isEmpty()){
            int size = queue.size();
            curLevel++;
            int curLevelSum = 0;
            for (int i = 0; i < size; i++){
                TreeNode node = queue.poll();
                curLevelSum += node.val;
                if (node.left != null) queue.offer(node.left);
                if (node.right != null) queue.offer(node.right);
            }
            if (curLevelSum > maxLevelSum){
                maxLevelSum = curLevelSum;
                maxLevel = curLevel;
            }
        }
        return maxLevel;
    }
}
