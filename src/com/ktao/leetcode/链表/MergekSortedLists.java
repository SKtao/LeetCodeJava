package com.ktao.leetcode.链表;

/**
 * 23. 合并K个排序链表
 * @version 1.0
 * @author: kongtao
 * @description:
 * @date: 2020/4/29 8:17 下午
 */
public class MergekSortedLists {
    /**
     * 合并 k 个排序链表，返回合并后的排序链表。请分析和描述算法的复杂度。
     *
     * 示例:
     *
     * 输入:
     * [
     *   1->4->5,
     *   1->3->4,
     *   2->6
     * ]
     * 输出: 1->1->2->3->4->4->5->6
     */
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists == null || lists.length == 0) return null;
        if (lists.length == 1) return lists[0];
        if (lists.length == 2) return mergeTwoLists(lists[0], lists[1]);
        int mid = lists.length / 2;
        ListNode[] left = subList(lists, 0, mid);
        ListNode[] right = subList(lists, mid + 1, lists.length - 1);
        return mergeTwoLists(mergeKLists(left), mergeKLists(right));
    }

    private ListNode[] subList(ListNode[] lists, int left, int right){
        ListNode[] res = new ListNode[right - left + 1];
        int index = 0;
        for (int i = left; i <= right; i++){
            res[index++] = lists[i];
        }
        return res;
    }


    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null) return l2;
        if (l2 == null) return l1;
        if (l1.val < l2.val){
            l1.next = mergeTwoLists(l1.next, l2);
            return l1;
        } else {
            l2.next = mergeTwoLists(l1, l2.next);
            return l2;
        }
    }
}
