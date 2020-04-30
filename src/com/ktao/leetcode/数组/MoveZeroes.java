package com.ktao.leetcode.数组;

/**
 * 283. 移动零
 * @version 1.0
 * @author: kongtao
 * @description:
 * @date: 2020/4/30 9:23 下午
 */
public class MoveZeroes {
    /**
     * 给定一个数组 nums，编写一个函数将所有 0 移动到数组的末尾，同时保持非零元素的相对顺序。
     *
     * 示例:
     *
     * 输入: [0,1,0,3,12]
     * 输出: [1,3,12,0,0]
     * 说明:
     *
     * 必须在原数组上操作，不能拷贝额外的数组。
     * 尽量减少操作次数.
     */
    public void moveZeroes(int[] nums) {
        if (nums == null || nums.length <= 1) return;
        for (int lastNonZeroFoundAt = 0, cur = 0; cur < nums.length; cur++){
            if (nums[cur] != 0){
                swap(nums, lastNonZeroFoundAt++, cur);
            }
        }
    }

    private void swap(int[] nums, int i , int j){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
