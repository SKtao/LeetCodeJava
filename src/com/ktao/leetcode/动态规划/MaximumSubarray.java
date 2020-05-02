package com.ktao.leetcode.动态规划;

/**
 * 53. Maximum Subarray
 * @author kongtao
 * @version 1.0
 * @description:
 * @date 2020/5/2
 **/
public class MaximumSubarray {
    /**
     * Given an integer array nums, find the contiguous subarray (containing at least one number) which has the largest sum and return its sum.
     *
     * Example:
     *
     * Input: [-2,1,-3,4,-1,2,1,-5,4],
     * Output: 6
     * Explanation: [4,-1,2,1] has the largest sum = 6.
     * Follow up:
     *
     * If you have figured out the O(n) solution, try coding another solution using the divide and conquer approach, which is more subtle.
     */

    /**
     * 动态规划的是首先对数组进行遍历，当前最大连续子序列和为 cuSum，结果为 maxSum
     * 如果 cuSum > 0，则说明 cuSum 对结果有增益效果，则 cuSum 保留并加上当前遍历数字
     * 如果 cuSum <= 0，则说明 cuSum 对结果无增益效果，需要舍弃，则 cuSum 直接更新为当前遍历数字
     * 每次比较 cuSum 和 maxSum的大小，将最大值置为maxSum，遍历结束返回结果
     * 时间复杂度：O(n)
     */
    public int maxSubArray(int[] nums) {
        int maxSum = 0, curSum = 0;
        for (int num : nums){
            curSum += num;
            if (curSum < 0){
                curSum = num;
            }
            maxSum = Math.max(maxSum, curSum);
        }
        return maxSum;
    }
}
