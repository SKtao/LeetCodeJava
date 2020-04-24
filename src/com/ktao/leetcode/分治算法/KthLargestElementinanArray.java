package com.ktao.leetcode.分治算法;

/**
 * 215.数组中的第K个最大元素
 * @author kongtao
 * @version 1.0
 * @description: 【Middle】
 * @date 2020/4/19
 **/
public class KthLargestElementinanArray {
    /**
     * 在未排序的数组中找到第 k 个最大的元素。请注意，你需要找的是数组排序后的第 k 个最大的元素，而不是第 k 个不同的元素。
     *
     * 示例 1:
     *
     * 输入: [3,2,1,5,6,4] 和 k = 2
     * 输出: 5
     * 示例 2:
     *
     * 输入: [3,2,3,1,2,4,5,5,6] 和 k = 4
     * 输出: 4
     */
    // Quick Select思想
    // Time(avg): O(n), Time(worst): O(n^2), Space: O(1)
    public int findKthLargest(int[] nums, int k) {
        int low = 0, high = nums.length - 1;
        while (low <= high){
            int p = partition(nums, low, high);
            if (p == k - 1) return nums[p];
            else if (p > k - 1) high = p - 1;
            else low = p + 1;
        }
        return -1;
    }

    void swap(int[] nums, int i , int j){
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }

    int partition(int[] nums, int low ,int high){
        int pivot = nums[low], i = low , j = high;
        while (i < j){
            while (i < j && nums[j] < pivot) --j;
            if (i < j) swap(nums, i, j);
            while (i < j && nums[i] >= pivot) ++i;
            if (i < j) swap(nums, i, j);
        }
        return i;
    }

    public static void main(String[] args) {

    }
}
