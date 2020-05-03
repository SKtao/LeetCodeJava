package com.ktao.leetcode.动态规划;

import java.util.Arrays;

/**
 * 72.编辑距离
 * @author kongtao
 * @version 1.0
 * @description: 【Hard】
 * @date 2020/4/19
 **/
public class EditDistance {
    /**
     * 给你两个单词 word1 和 word2，请你计算出将 word1 转换成 word2 所使用的最少操作数 。
     *
     * 你可以对一个单词进行如下三种操作：
     *
     * 插入一个字符
     * 删除一个字符
     * 替换一个字符
     *  
     * 示例 1：
     *
     * 输入：word1 = "horse", word2 = "ros"
     * 输出：3
     * 解释：
     * horse -> rorse (将 'h' 替换为 'r')
     * rorse -> rose (删除 'r')
     * rose -> ros (删除 'e')
     */
    public int minDistance(String word1, String word2) {
        int m = word1.length(), n = word2.length();
        int[][] dp = new int[m+1][n+1];
        // 初始化边界值
        for (int i = 0; i <= m; i++){
            Arrays.fill(dp[i], Integer.MAX_VALUE);
            dp[i][0] = i;
        }
        for (int j = 0; j <= n; j++){
            dp[0][j] = j;
        }
        for (int i = 0; i < m; i++){
            for (int j = 0; j < n; j++){
                char c1 = word1.charAt(i);
                char c2 = word2.charAt(j);
                if (c1 == c2){
                    dp[i+1][j+1] = dp[i][j];
                } else {
                    dp[i+1][j+1] = Math.min(dp[i][j+1], Math.min(dp[i+1][j], dp[i][j])) + 1;
                }
            }
        }
        return dp[m][n];
    }

    public static void main(String[] args) {

    }
}
