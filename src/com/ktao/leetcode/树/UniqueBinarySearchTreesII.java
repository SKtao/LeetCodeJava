package com.ktao.leetcode.树;

import com.ktao.leetcode.树.层次遍历.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author kongtao
 * @version 1.0
 * @description:
 * @date 2020/5/3
 **/
public class UniqueBinarySearchTreesII {
    /**
     * Given an integer n, generate all structurally unique BST's (binary search trees) that store values 1 ... n.
     *
     * Example:
     *
     * Input: 3
     * Output:
     * [
     *   [1,null,3,2],
     *   [3,2,null,1],
     *   [3,1,null,null,2],
     *   [2,1,3],
     *   [1,null,2,null,3]
     * ]
     * Explanation:
     * The above output corresponds to the 5 unique BST's shown below:
     *
     *    1         3     3      2      1
     *     \       /     /      / \      \
     *      3     2     1      1   3      2
     *     /     /       \                 \
     *    2     1         2
     */
    public List<TreeNode> generateTrees(int n) {
        if (n == 0) return new ArrayList<>();
        return helper(1, n);
    }

    private List<TreeNode> helper(int start, int end){
        List<TreeNode> res = new ArrayList<>();
        if (start > end){
            res.add(null);
            return res;
        }
        for (int i = start; i <= end; i++){
            List<TreeNode> lefts = helper(start, i-1);
            List<TreeNode> rights = helper(i+1, end);
            for (TreeNode left : lefts){
                for (TreeNode right : rights){
                    TreeNode root = new TreeNode(i);
                    root.left = left;
                    root.right = right;
                    res.add(root);
                }
            }
        }
        return res;
    }
}
