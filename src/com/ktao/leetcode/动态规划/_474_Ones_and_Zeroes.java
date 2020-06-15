package com.ktao.leetcode.动态规划;

/**
 * @author kongtao
 * @version 1.0
 * @description:
 * @date 2020/6/7
 **/
public class _474_Ones_and_Zeroes {
    public static int findMaxForm(String[] strs, int m, int n) {
        int[][] dp = new int[m + 1][n + 1];
        for (String str : strs){
            int zeroCount = 0, oneCount = 0;
            // 记录该字符串中0和1的个数
            for (char c : str.toCharArray()){
                if (c == '0') zeroCount++;
                else oneCount++;
            }
            // ⚠️：从后往前遍历
            for (int i = m; i >= zeroCount; i--){
                for (int j = n; j >= oneCount; j--){
                    dp[i][j] = Math.max(dp[i][j], dp[i - zeroCount][j - oneCount] + 1);
                }
            }
        }
        return dp[m][n];
    }

    public static void main(String[] args) {
        String[] strs = {"10","0001","111001","1","0"};
        int m = 5, n = 3;
        System.out.println(findMaxForm(strs, m, n));
    }
}
