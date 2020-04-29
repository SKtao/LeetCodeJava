package com.ktao.leetcode.设计题;

import com.ktao.leetcode.树.层次遍历.TreeNode;

import java.util.Stack;

/**
 * @author kongtao
 * @version 1.0
 * @description:
 * @date 2020/4/29
 **/
public class BSTIterator {
    /**
     * 实现一个二叉搜索树迭代器。你将使用二叉搜索树的根节点初始化迭代器。
     * 调用 next() 将返回二叉搜索树中的下一个最小的数。
     *
     *     7
     *    /  \
     *  3     15
     *       /  \
     *      9   20
     * BSTIterator iterator = new BSTIterator(root);
     * iterator.next();    // 返回 3
     * iterator.next();    // 返回 7
     * iterator.hasNext(); // 返回 true
     * iterator.next();    // 返回 9
     * iterator.hasNext(); // 返回 true
     * iterator.next();    // 返回 15
     * iterator.hasNext(); // 返回 true
     * iterator.next();    // 返回 20
     * iterator.hasNext(); // 返回 false
     *
     * 提示：
     *
     * next() 和 hasNext() 操作的时间复杂度是 O(1)，并使用 O(h) 内存，其中 h 是树的高度。
     * 你可以假设 next() 调用总是有效的，也就是说，当调用 next() 时，BST 中至少存在一个下一个最小的数。
     */

    private Stack<TreeNode> stack = new Stack<>();
    public BSTIterator(TreeNode root) {
        push(root);
    }

    public int next() {
        TreeNode cur = stack.pop();
        // 将又子树入栈
        push(cur.right);
        return cur.val;
    }

    public boolean hasNext() {
        return !stack.isEmpty();
    }

    // 将左子树+根入栈
    private void push(TreeNode root){
        while (root != null){
            stack.push(root);
            root = root.left;
        }
    }
}
