package com.ktao.leetcode.动态规划;

/**
 * @author kongtao
 * @version 1.0
 * @description:
 * @date 2020/6/14
 **/
public class _312_Burst_Balloons {
    /**
     * 定义方法 dp，使其返回开区间 (left, right) 中所能得到的最大金币数。对于基础情况 (即 left + 1 == right)，这时候区间内没有整数，也没有气球需要加进去，因此 dp[left][right] = 0。随后在区间中加入气球，把问题分割成左右两部分来处理，找到最大金币数。
     *
     * 在添加第 i 个气球后能得到的最大金币数为：
     *
     * nums[left] * nums[i] * nums[right] + dp(left, i) + dp(i, right)
     * 其中 nums[left] * nums[i] * nums[right] 为加入第 i 个气球所能得到的金币数，dp(left, i) + dp(i, right) 为左右两部分分别能得到的最大金币数。
     */
    public int maxCoins(int[] nums) {

        // reframe the problem
        int n = nums.length + 2;
        int[] new_nums = new int[n];

        for(int i = 0; i < nums.length; i++){
            new_nums[i+1] = nums[i];
        }

        new_nums[0] = new_nums[n - 1] = 1;

        // cache the results of dp
        int[][] memo = new int[n][n];

        // find the maximum number of coins obtained from adding all balloons from (0, len(nums) - 1)
        return dp(memo, new_nums, 0, n - 1);
    }

    public int dp(int[][] memo, int[] nums, int left, int right) {
        // no more balloons can be added
        if (left + 1 == right) return 0;

        // we've already seen this, return from cache
        if (memo[left][right] > 0) return memo[left][right];

        // add each balloon on the interval and return the maximum score
        int ans = 0;
        for (int i = left + 1; i < right; ++i)
            ans = Math.max(ans, nums[left] * nums[i] * nums[right]
                    + dp(memo, nums, left, i) + dp(memo, nums, i, right));
        // add to the cache
        memo[left][right] = ans;
        return ans;
    }
}
