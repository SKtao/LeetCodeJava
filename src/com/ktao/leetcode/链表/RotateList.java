package com.ktao.leetcode.链表;

/**
 * 61.旋转链表
 * @version 1.0
 * @author: kongtao
 * @description:
 * @date: 2020/4/30 10:53 上午
 */
public class RotateList {
    /**
     * 给定一个链表，旋转链表，将链表每个节点向右移动 k 个位置，其中 k 是非负数。
     *
     * 示例 1:
     *
     * 输入: 1->2->3->4->5->NULL, k = 2
     * 输出: 4->5->1->2->3->NULL
     * 解释:
     * 向右旋转 1 步: 5->1->2->3->4->NULL
     * 向右旋转 2 步: 4->5->1->2->3->NULL
     * 示例 2:
     *
     * 输入: 0->1->2->NULL, k = 4
     * 输出: 2->0->1->NULL
     * 解释:
     * 向右旋转 1 步: 2->0->1->NULL
     * 向右旋转 2 步: 1->2->0->NULL
     * 向右旋转 3 步: 0->1->2->NULL
     * 向右旋转 4 步: 2->0->1->NULL
     */
    public ListNode rotateRight(ListNode head, int k) {
        if (head == null) return head;
        ListNode pNode = head;
        int n = 1;
        while (pNode.next != null){
            pNode = pNode.next;
            n++;
        }
        k = n - k % n;
        pNode.next = head;
        ListNode pNext = head;
        while (--k >= 0){
            pNode = pNode.next;
            pNext = pNext.next;
        }
        pNode.next = null;
        return pNext;
    }
}
