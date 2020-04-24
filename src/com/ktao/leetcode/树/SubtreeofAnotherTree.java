package com.ktao.leetcode.树;

/**
 * @author kongtao
 * @version 1.0
 * @description: 572.另一个树的子树
 * @date 2020/4/17
 **/
public class SubtreeofAnotherTree {
    /**
     * 给定两个非空二叉树 s 和 t，检验 s 中是否包含和 t 具有相同结构和节点值的子树。s 的一个子树包括 s 的一个节点和这个节点的所有子孙。s 也可以看做它自身的一棵子树。
     *
     * 示例 1:
     * 给定的树 s:
     *
     *      3
     *     / \
     *    4   5
     *   / \
     *  1   2
     * 给定的树 t：
     *
     *    4
     *   / \
     *  1   2
     * 返回 true，因为 t 与 s 的一个子树拥有相同的结构和节点值。
     */
    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) {
            val = x;
        }
    }
    public boolean isSubtree(TreeNode s, TreeNode t) {
        if (s == null) return false;
        if (isSame(s, t)) return true;
        return isSubtree(s.left, t) || isSubtree(s.right, t);
    }

    private boolean isSame(TreeNode a, TreeNode b){
        if (a == null && b == null) return true;
        if (a == null || b == null) return false;
        if (a.val != b.val) return false;
        return isSame(a.left, b.left) && isSame(a.right, b.right);
    }
}
