package com.ktao.leetcode.链表;

/**
 * 83.删除排序链表中的重复元素
 * @version 1.0
 * @author: kongtao
 * @description:
 * @date: 2020/4/30 11:21 上午
 */
public class RemoveDuplicatesfromSortedList {
    /**
     * 给定一个排序链表，删除所有重复的元素，使得每个元素只出现一次。
     *
     * 示例 1:
     *
     * 输入: 1->1->2
     * 输出: 1->2
     * 示例 2:
     *
     * 输入: 1->1->2->3->3
     * 输出: 1->2->3
     */
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode p1 = head, p2 = head.next;
        while (p2 != null){
            if (p1.val == p2.val){
                p1.next = p2.next;
            } else {
                p1 = p1.next;
            }
            p2 = p2.next;
        }
        return head;
    }
}
