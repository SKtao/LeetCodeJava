package com.ktao.leetcode.动态规划;

import java.util.Arrays;

/**
 * @author kongtao
 * @version 1.0
 * @description: 279. 完全平方数
 * @date 2020/4/17
 **/
public class PerfectSquares {
    /**
     * 给定正整数 n，找到若干个完全平方数（比如 1, 4, 9, 16, ...）使得它们的和等于 n。你需要让组成和的完全平方数的个数最少。
     *
     * 示例 1:
     *
     * 输入: n = 12
     * 输出: 3
     * 解释: 12 = 4 + 4 + 4.
     * 示例 2:
     *
     * 输入: n = 13
     * 输出: 2
     * 解释: 13 = 4 + 9.
     */
    // 解法1：DP(动态规划)
    // 复杂度：time：O(n * sqrt(n)) space: O(n)
    public int numSquares(int n) {
        int[] dp = new int[n+1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;
        int maxSquareIndex = (int) Math.sqrt(n) + 1;
        int[] squareNums = new int[maxSquareIndex];
        for (int i = 1; i < maxSquareIndex; i++){
            squareNums[i] = i * i;
        }
        for (int i = 1; i <= n; i++){
            for (int s = 1; s < maxSquareIndex; s++){
                if (i < squareNums[s]) break;
                dp[i] = Math.min(dp[i], dp[i - squareNums[s]] + 1);
            }
        }
        return dp[n];
    }

    public static void main(String[] args) {
        PerfectSquares solution = new PerfectSquares();
        System.out.println(solution.numSquares(12));
    }
}
