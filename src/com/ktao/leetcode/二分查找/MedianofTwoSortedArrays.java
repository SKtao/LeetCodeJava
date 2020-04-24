package com.ktao.leetcode.二分查找;

/**
 * 4.寻找两个有序数组的中位数
 * @author kongtao
 * @version 1.0
 * @description: 【Hard】
 * @date 2020/4/21
 **/
public class MedianofTwoSortedArrays {
    /**
     *
     * 给定两个大小为 m 和 n 的有序数组 nums1 和 nums2。
     * 请你找出这两个有序数组的中位数，并且要求算法的时间复杂度为 O(log(m + n))。
     * 你可以假设 nums1 和 nums2 不会同时为空。
     *
     * 示例 1:
     *
     * nums1 = [1, 3]
     * nums2 = [2]
     * 则中位数是 2.0
     * 示例 2:
     *
     * nums1 = [1, 2]
     * nums2 = [3, 4]
     * 则中位数是 (2 + 3)/2 = 2.5
     *
     * 分析：
     * 9 10 11 ｜ 12 13 14
     * 2 3 4 5 6 7 8 9 10 11 ｜ 12 13 14 15 16 17 18 19 20 21
     */
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int n1 = nums1.length;
        int n2 = nums2.length;
        // 保证数组1长度比数组2而小
        if (n1 > n2){
            return findMedianSortedArrays(nums2, nums1);
        }
        // 中位数在数组合并后的位置
        int k = (n1 + n2 + 1) / 2;
        int left = 0, right = n1;
        // 二分查找左中位数分割点
        while (left < right){
            // nums1左半边贡献m1个元素
            int m1 = (left + right) / 2;
            // nums2左半边贡献m2个元素
            int m2 = k - m1;
            // 分割线m1对应的元素 < 分割线m2左边的元素
            if (nums1[m1] < nums2[m2 - 1]){
                left = m1 + 1;
            } else {
                right = m1;
            }
        }
        int m1 = left, m2 = k - left;
        // 左中位数
        int c1 = Math.max(m1 == 0 ? Integer.MAX_VALUE : nums1[m1 - 1],
                m2 == 0 ? Integer.MAX_VALUE : nums2[m2 - 1]);
        if ((n1 + n2) % 2 == 1) {
            return c1;
        }
        // 右中位数
        int c2 = Math.min(m1 == n1 ? Integer.MIN_VALUE : nums1[m1],
                m1 == n2 ? Integer.MAX_VALUE : nums2[m2]);
        return (c1 + c2) * 0.5;
    }
}
