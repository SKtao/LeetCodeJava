package com.ktao.leetcode.链表;

/**
 * 92.反转链表II
 * @author kongtao
 * @version 1.0
 * @description:
 * @date 2020/5/6
 **/
public class ReverseLinkedListII {
    /**
     *反转从位置 m 到 n 的链表。请使用一趟扫描完成反转。
     *
     * 说明:
     * 1 ≤ m ≤ n ≤ 链表长度。
     *
     * 示例:
     *
     * 输入: 1->2->3->4->5->NULL, m = 2, n = 4
     * 输出: 1->4->3->2->5->NULL
     */
    public ListNode reverseBetween(ListNode head, int m, int n) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode pre = dummy;
        for(int i = 1; i < m; i++){
            pre = pre.next;
        }
        ListNode mHead = pre.next;
        for(int i = m; i < n; i++){
            ListNode nex = mHead.next;
            mHead.next = nex.next;
            nex.next = pre.next;
            pre.next = nex;
        }
        return dummy.next;
    }
}
