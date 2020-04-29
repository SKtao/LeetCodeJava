package com.ktao.leetcode.数组;

/**
 * 41. 缺失的第一个正数
 * @author kongtao
 * @version 1.0
 * @description:
 * @date 2020/4/28
 **/
public class FirstMissingPositive {
    /**
     * 给你一个未排序的整数数组，请你找出其中没有出现的最小的正整数。
     * 示例 1:
     *
     * 输入: [1,2,0]
     * 输出: 3
     * 示例 2:
     *
     * 输入: [3,4,-1,1]
     * 输出: 2
     * 示例 3:
     *
     * 输入: [7,8,9,11,12]
     * 输出: 1
     */
    public int firstMissingPositive(int[] nums) {
        for (int i = 0; i < nums.length; i++){
            while (nums[i] != i+1 && nums[i] > 0 && nums[i] <= nums.length && nums[i] != nums[nums[i] - 1]){
                swap(nums, i, nums[i] - 1);
            }
        }
        for (int i = 0; i < nums.length; i++){
            if (nums[i] != i + 1) return i + 1;
        }
        return nums.length + 1;
    }

    private void swap(int[] nums, int i, int j){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
