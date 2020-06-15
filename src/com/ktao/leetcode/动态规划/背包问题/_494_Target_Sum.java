package com.ktao.leetcode.动态规划.背包问题;

/**
 * 494. 目标和
 * @version 1.0
 * @author: kongtao
 * @description: 【mid】
 * @date: 2020/4/26 10:29 下午
 */
public class _494_Target_Sum {
    /**
     * 给定一个非负整数数组，a1, a2, ..., an, 和一个目标数，S。现在你有两个符号 + 和 -。对于数组中的任意一个整数，你都可以从 + 或 -中选择一个符号添加在前面。
     *
     * 返回可以使最终数组和为目标数 S 的所有添加符号的方法数。
     *
     * 示例 1:
     *
     * 输入: nums: [1, 1, 1, 1, 1], S: 3
     * 输出: 5
     * 解释:
     *
     * -1+1+1+1+1 = 3
     * +1-1+1+1+1 = 3
     * +1+1-1+1+1 = 3
     * +1+1+1-1+1 = 3
     * +1+1+1+1-1 = 3
     *
     * 一共有5种方法让最终目标和为3。
     * 注意:
     *
     * 数组非空，且长度不会超过20。
     * 初始的数组的和不会超过1000。
     * 保证返回的最终结果能被32位整数存下。
     *
     *
     * 思路：sum(正数) = P, sum(负数) = N, P-N = sum, P+N = target  => P = (sum + target) / 2;
     * 问题转化为找子集的和为(sum+target)/2的子集总数。
     * 01背包问题：dp[i][j]= dp[i-1][j] + dp[i-1][j-nums[i]]
     */
    public int findTargetSumWays(int[] nums, int S) {
        int sum = 0;
        for (int num : nums) sum += num;
        if (sum < S || (sum + S) % 2 == 1) return 0;
        sum = (sum + S) / 2;
        int[] dp = new int[sum + 1];
        dp[0] = 1;
        for (int num : nums){
            for  (int j = sum; j >= num; j--){
                dp[j] += dp[j - num];
            }
        }
        return dp[sum];
    }
}
