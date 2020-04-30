package com.ktao.leetcode.链表;

/**
 * 25.K个一组翻转链表
 * @version 1.0
 * @author: kongtao
 * @description:
 * @date: 2020/4/29 8:32 下午
 */
public class ReverseNodesink_Group {
    /**
     * 给你一个链表，每 k 个节点一组进行翻转，请你返回翻转后的链表。
     *
     * k 是一个正整数，它的值小于或等于链表的长度。
     *
     * 如果节点总数不是 k 的整数倍，那么请将最后剩余的节点保持原有顺序。
     *
     * 示例：
     *
     * 给你这个链表：1->2->3->4->5
     *
     * 当 k = 2 时，应当返回: 2->1->4->3->5
     *
     * 当 k = 3 时，应当返回: 3->2->1->4->5
     *
     * 说明：
     *
     * 你的算法只能使用常数的额外空间。
     * 你不能只是单纯的改变节点内部的值，而是需要实际进行节点交换。
     */
    public ListNode reverseKGroup(ListNode head, int k) {
        if (head == null) return head;
        ListNode pre = head, p = head;
        for (int i = 0; i < k; i++){
            if (p == null) return head;
            pre = p;
            p = p.next;
        }

        pre.next = null;
        pre = reverse(head);
        head.next = reverseKGroup(p, k);
        return pre;
    }

    private ListNode reverse(ListNode head){
        ListNode pNode = head, pre = null;
        while (pNode != null){
            ListNode next = pNode.next;
            pNode.next = pre;
            pre = pNode;
            pNode = next;
        }
        return pre;
    }
}
