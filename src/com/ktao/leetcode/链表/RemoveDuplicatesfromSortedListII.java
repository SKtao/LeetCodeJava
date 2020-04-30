package com.ktao.leetcode.链表;

/**
 * 82. 删除排序链表中的重复元素 II
 * @version 1.0
 * @author: kongtao
 * @description:
 * @date: 2020/4/30 11:07 上午
 */
public class RemoveDuplicatesfromSortedListII {
    /**
     * 给定一个排序链表，删除所有含有重复数字的节点，只保留原始链表中 没有重复出现 的数字。
     *
     * 示例 1:
     *
     * 输入: 1->2->3->3->4->4->5
     * 输出: 1->2->5
     * 示例 2:
     *
     * 输入: 1->1->1->2->3
     * 输出: 2->3
     */
    public ListNode deleteDuplicates(ListNode head) {
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode p1 = dummy, p2 = head;
        while (p2 != null && p2.next != null){
            if (p1.next.val != p2.next.val){
                p1 = p1.next;
                p2 = p2.next;
                continue;
            }
            while (p2.next != null && p1.next.val == p2.next.val){
                p2 = p2.next;
            }
            p1.next = p2.next;
            p2 = p2.next;
        }
        return dummy.next;
    }
}
