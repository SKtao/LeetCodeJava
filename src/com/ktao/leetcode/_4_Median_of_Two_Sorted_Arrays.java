package com.ktao.leetcode;

/**
 * 4.寻找两个正序数组的中位数
 * @author kongtao
 * @version 1.0
 * @description:
 * @date 2020/6/15
 **/
public class _4_Median_of_Two_Sorted_Arrays {
    /**
     * 给定两个大小为 m 和 n 的正序（从小到大）数组 nums1 和 nums2。
     *
     * 请你找出这两个正序数组的中位数，并且要求算法的时间复杂度为 O(log(m + n))。
     *
     * 你可以假设 nums1 和 nums2 不会同时为空。
     */
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int len1 = nums1.length, len2 = nums2.length;
        if (len1 > len2){
            return findMedianSortedArrays(nums2, nums1);
        }
        int left = 0, right = len1;
        int k = (len1 + len2 + 1) / 2;
        while (left < right){
            int mid1 = (left + right) / 2;
            int mid2 = k - mid1;
            if (nums1[mid1] < nums2[mid2 - 1]){
                left = mid1 + 1;
            } else {
                right = mid1;
            }
        }
        int m1 = left, m2 = k - left;
        // 左中位数
        int c1 = Math.max(m1 == 0 ? Integer.MIN_VALUE : nums1[m1 - 1],m2 == 0 ? Integer.MIN_VALUE : nums2[m2 - 1]);
        if ((len1 + len2) % 2 == 1) {
            return c1;
        }
        int c2 = Math.min(m1 == len1 ? Integer.MAX_VALUE : nums1[m1],m2 == len2 ? Integer.MAX_VALUE : nums2[m2]);
        // 右中位数
        return (c1 + c2) * 0.5;
    }
}
