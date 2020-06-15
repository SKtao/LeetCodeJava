package com.ktao.leetcode.数组.sum问题;

import java.util.Arrays;

/**
 * 16.最接近的三数之和
 * @version 1.0
 * @author: kongtao
 * @description:
 * @date: 2020/4/24 7:53 下午
 */
public class _16_Three_Sum_Closest {
    /**
     * 给定一个包括 n 个整数的数组 nums 和 一个目标值 target。找出 nums 中的三个整数，使得它们的和与 target 最接近。返回这三个数的和。假定每组输入只存在唯一答案。
     *
     * 例如，给定数组 nums = [-1，2，1，-4], 和 target = 1.
     *
     * 与 target 最接近的三个数的和为 2. (-1 + 2 + 1 = 2).
     */

    // O(n^2)
    public int threeSumClosest(int[] nums, int target) {
        if (nums == null && nums.length == 0){
            return 0;
        }
        int closeSum = Integer.MAX_VALUE;
        Arrays.sort(nums);
        int res = 0;
        for (int i = 0; i < nums.length - 2; i++){
            int j = i + 1, k = nums.length - 1;
            while (j < k){
                int sum = nums[i] + nums[j] + nums[k];
                if (target == sum) return target;
                if (Math.abs(target - sum) < closeSum){
                    res = sum;
                }
                closeSum = Math.min(closeSum, Math.abs(target - sum));
                if (sum < target){
                    j++;
                } else {
                    k--;
                }
            }
        }
        return res;
    }
}
