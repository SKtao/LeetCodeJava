package com.ktao.leetcode.动态规划;

/**
 * 221. 最大正方形
 * @author kongtao
 * @version 1.0
 * @description:
 * @date 2020/5/27
 **/
public class MaximalSquare {
    /**
     * 在一个由 0 和 1 组成的二维矩阵内，找到只包含 1 的最大正方形，并返回其面积。
     *
     * 示例:
     *
     * 输入:
     *
     * 1 0 1 0 0
     * 1 0 1 1 1
     * 1 1 1 1 1
     * 1 0 0 1 0
     *
     * 输出: 4
     */
    public int maximalSquare(char[][] matrix) {
        if (matrix == null || matrix.length == 0) return 0;
        int m = matrix.length;
        int n = matrix[0].length;
        int[][] dp = new int[m][n];
        int maxLen = 0;
        for (int i = 0; i < m; i++){
            for (int j = 0; j < n; j++){
                if (i == 0 || j == 0 || matrix[i][j] == '0'){
                    dp[i][j] = matrix[i][j] - '0';
                } else {
                    dp[i][j] = Math.min(Math.min(dp[i - 1][j - 1], dp[i - 1][j]), dp[i][j - 1]) + 1;
                }
                maxLen = Math.max(maxLen, dp[i][j]);
            }
        }
        return maxLen * maxLen;
    }
}
