package com.ktao.leetcode.排序;

/**
 * 215. 数组中的第K个最大元素
 * @author kongtao
 * @version 1.0
 * @description:
 * @date 2020/5/22
 **/
public class KthLargestElementInAnArray {
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
     * 说明:
     *
     * 你可以假设 k 总是有效的，且 1 ≤ k ≤ 数组的长度。
     */
    public int findKthLargest(int[] nums, int k) {
        int targetIdx = nums.length - k;
        int left = 0, right = nums.length - 1;
        while (true){
            int index = partition(nums, left, right);
            if (index == targetIdx) return nums[index];
            else if (index < targetIdx){
                left = index + 1;
            } else {
                right = index - 1;
            }
        }
    }

    private int partition(int[] nums, int left, int right) {
        int v = nums[left];
        int j = left;
        for (int i=left+1; i<=right; i++) {
            if (nums[i] < v) {
                j++;
                swap(nums, i, j);
            }
        }
        swap(nums, left, j);
        return j;
    }
    private void swap(int[] nums, int a, int b) {
        int temp = nums[a];
        nums[a] = nums[b];
        nums[b] = temp;
    }
}
