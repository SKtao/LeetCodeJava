package com.ktao.leetcode.链表;

/**
 * 24. 两两交换链表中的节点
 * @version 1.0
 * @author: kongtao
 * @description:
 * @date: 2020/4/29 8:24 下午
 */
public class SwapNodesinPairs {
    /**
     * 给定一个链表，两两交换其中相邻的节点，并返回交换后的链表。
     *
     * 你不能只是单纯的改变节点内部的值，而是需要实际的进行节点交换。
     * 示例:
     *
     * 给定 1->2->3->4, 你应该返回 2->1->4->3.
     */
    public ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode p1 = head, p2 = head.next;
        ListNode next = p2.next;
        p1.next = swapPairs(next);
        p2.next = p1;
        return p2;
    }
}
