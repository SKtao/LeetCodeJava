package com.ktao.leetcode.链表;

/**
 * 234. 回文链表
 * @author kongtao
 * @version 1.0
 * @description:
 * @date 2020/5/30
 **/
public class PalindromeLinkedList {
    /**
     * 请判断一个链表是否为回文链表。
     *
     * 示例 1:
     *
     * 输入: 1->2
     * 输出: false
     * 示例 2:
     *
     * 输入: 1->2->2->1
     * 输出: true
     * 进阶：
     * 你能否用 O(n) 时间复杂度和 O(1) 空间复杂度解决此题？
     */
    public boolean isPalindrome(ListNode head) {
        if (head == null || head.next == null) return true;
        ListNode slow = head, fast = head;
        while (fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }
        slow = reverse(slow);
        while (head != null && slow != null){
            if (head.val != slow.val) return false;
            head = head.next;
            slow = slow.next;
        }
        return true;
    }

    private ListNode reverse(ListNode head){
        ListNode pre = null, pNode = head;
        while (pNode != null){
            ListNode next = pNode.next;
            pNode.next = pre;
            pre = pNode;
            pNode = next;
        }
        return pre;
    }
}
