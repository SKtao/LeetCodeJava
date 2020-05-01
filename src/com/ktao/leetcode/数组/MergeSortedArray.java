package com.ktao.leetcode.数组;

/**
 * @author kongtao
 * @version 1.0
 * @description:
 * @date 2020/5/1
 **/
public class MergeSortedArray {
    /**
     * 给你两个有序整数数组 nums1 和 nums2，请你将 nums2 合并到 nums1 中，使 nums1 成为一个有序数组。
     * 说明:
     *
     * 初始化 nums1 和 nums2 的元素数量分别为 m 和 n 。
     * 你可以假设 nums1 有足够的空间（空间大小大于或等于 m + n）来保存 nums2 中的元素。
     *
     * 示例:
     *
     * 输入:
     * nums1 = [1,2,3,0,0,0], m = 3
     * nums2 = [2,5,6],       n = 3
     *
     * 输出: [1,2,2,3,5,6]
     */
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int p = m + n - 1;
        int p1 = m - 1, p2 = n - 1;
        while (p1 >= 0 || p2 >= 0){
            int a = (p1 >= 0) ? nums1[p1]:Integer.MIN_VALUE;
            int b = (p2 >= 0) ? nums2[p2]:Integer.MIN_VALUE;
            if (a >= b){
                nums1[p--] = a;p1--;
            } else {
                nums1[p--] = b;p2--;
            }
        }
    }
}
