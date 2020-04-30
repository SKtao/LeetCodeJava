package com.ktao.leetcode.链表;

/**
 * 86.分隔链表
 * @version 1.0
 * @author: kongtao
 * @description:
 * @date: 2020/4/30 11:38 上午
 */
public class PartitionList {
    /**
     * 给定一个链表和一个特定值 x，对链表进行分隔，使得所有小于 x 的节点都在大于或等于 x 的节点之前。
     *
     * 你应当保留两个分区中每个节点的初始相对位置。
     *
     * 示例:
     *
     * 输入: head = 1->4->3->2->5->2, x = 3
     * 输出: 1->2->2->4->3->5
     */
    public ListNode partition(ListNode head, int x) {
        if (head == null || head.next == null) return head;
        ListNode dummy1 = new ListNode(-1), dummy2 = new ListNode(-1);
        ListNode p1 = dummy1, p2 = dummy2;
        ListNode p = head;
        while (p != null){
            if (p.val < x){
                p1.next = new ListNode(p.val);
                p1 = p1.next;
            } else {
                p2.next = new ListNode(p.val);
                p2 = p2.next;
            }
            p = p.next;
        }
        p1.next = dummy2.next;
        return dummy1.next;
    }
}
