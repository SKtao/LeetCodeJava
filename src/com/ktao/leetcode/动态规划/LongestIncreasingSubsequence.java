package com.ktao.leetcode.动态规划;

/**
 * 300.最长上升子序列
 * @author kongtao
 * @version 1.0
 * @description: 【Middle】
 * @date 2020/4/19
 **/
public class LongestIncreasingSubsequence {
    /**
     * 给定一个无序的整数数组，找到其中最长上升子序列的长度。
     *
     * 示例:
     *
     * 输入: [10,9,2,5,3,7,101,18]
     * 输出: 4
     * 解释: 最长的上升子序列是 [2,3,7,101]，它的长度是 4。
     * 说明:
     *
     * 可能会有多种最长上升子序列的组合，你只需要输出对应的长度即可。
     * 你算法的时间复杂度应该为 O(n2) 。
     * 进阶: 你能将算法的时间复杂度降低到 O(n log n) 吗?
     *
     * [10,9,2,5,3,7,101,18]
     * dp: [1, 1, 1, 2, 2, 3, 4, 4]
     */
    public int lengthOfLIS(int[] nums) {
        int n = nums.length;
        int[] dp = new int[n];
        int maxLen = 0;
        for (int i = 0; i < n; i++){
            int len = 1;
            for (int j = 0; j < i; j++){
                if (nums[j] < nums[i]){
                    len = Math.max(len, dp[j] + 1);
                }
            }
            dp[i] = len;
            if (dp[i] > maxLen){
                maxLen = dp[i];
            }
        }
        return maxLen;
    }

    public static void main(String[] args) {

    }
}
