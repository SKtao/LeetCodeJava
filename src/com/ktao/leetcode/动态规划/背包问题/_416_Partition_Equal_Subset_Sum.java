package com.ktao.leetcode.动态规划.背包问题;

/**
 * 416. 分割等和子集
 * @version 1.0
 * @author: kongtao
 * @description:
 * @date: 2020/4/25 11:57 下午
 */
public class _416_Partition_Equal_Subset_Sum {
    /**
     * 给定一个只包含正整数的非空数组。是否可以将这个数组分割成两个子集，使得两个子集的元素和相等。
     *
     * 注意:
     *
     * 每个数组中的元素不会超过 100
     * 数组的大小不会超过 200
     * 示例 1:
     *
     * 输入: [1, 5, 11, 5]
     *
     * 输出: true
     *
     * 解释: 数组可以分割成 [1, 5, 5] 和 [11].
     *
     * 【01背包问题】
     */
    public boolean canPartition(int[] nums) {
        int sum = 0;
        for (int num : nums) sum += num;
        if (sum % 2 == 1) return false;
        sum /= 2;
        boolean[] dp = new boolean[sum + 1];
        dp[0] = true;
        for (int num : nums) {
            for (int j = sum; j >= num; j--){
                // 选num or 不选num
                dp[j] = dp[j] || dp[j - num];
            }
        }
        return dp[sum];
    }
}
