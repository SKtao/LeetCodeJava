package com.ktao.leetcode.数组.滑动窗口;

/**
 * @author kongtao
 * @version 1.0
 * @description:
 * @date 2020/5/31
 **/
public class SlidingWindowMaximum {
    /**
     * 给定一个数组 nums，有一个大小为 k 的滑动窗口从数组的最左侧移动到数组的最右侧。你只可以看到在滑动窗口内的 k 个数字。滑动窗口每次只向右移动一位。
     *
     * 返回滑动窗口中的最大值。
     *
     *  
     *
     * 进阶：
     *
     * 你能在线性时间复杂度内解决此题吗？
     *
     *  
     *
     * 示例:
     *
     * 输入: nums = [1,3,-1,-3,5,3,6,7], 和 k = 3
     * 输出: [3,3,5,5,6,7]
     * 解释:
     *
     *   滑动窗口的位置                最大值
     * ---------------               -----
     * [1  3  -1] -3  5  3  6  7       3
     *  1 [3  -1  -3] 5  3  6  7       3
     *  1  3 [-1  -3  5] 3  6  7       5
     *  1  3  -1 [-3  5  3] 6  7       5
     *  1  3  -1  -3 [5  3  6] 7       6
     *  1  3  -1  -3  5 [3  6  7]      7
     */
    public int[] maxSlidingWindow(int[] nums, int k) {
        int right = k - 1;
        int[] dp = new int[nums.length - right];
        for (int i = 0; i < k; i++){
            dp[0] = Math.max(dp[0], nums[i]);
        }
        for (int i = 1; i < dp.length; i++) {
            // 若上一个窗口最大值在最左端
            if (nums[i - 1] == dp[i - 1]){
                dp[i] = nums[i];
                for (int j = i + 1; j < i + k; j++){
                    dp[i] = Math.max(dp[i], nums[j]);
                }
            } else {
                dp[i] = Math.max(dp[i - 1], nums[i + k - 1]);
            }
        }
        return dp;
    }
}
