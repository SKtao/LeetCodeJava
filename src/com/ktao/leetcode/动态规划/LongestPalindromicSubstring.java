package com.ktao.leetcode.动态规划;

/**
 * 5.最长回文子串
 * @author kongtao
 * @version 1.0
 * @description: 【Middle】
 * @date 2020/4/18
 **/
public class LongestPalindromicSubstring {
    /**
     * 给定一个字符串 s，找到 s 中最长的回文子串。你可以假设 s 的最大长度为 1000。
     *
     * 示例 1：
     *
     * 输入: "babad"
     * 输出: "bab"
     * 注意: "aba" 也是一个有效答案。
     * 示例 2：
     *
     * 输入: "cbbd"
     * 输出: "bb"
     */
    // DP
    public String longestPalindrome1(String s) {
        if (s == null || s.length() == 1) return s;
        String res = "";
        int maxLen = 0;
        boolean[][] dp = new boolean[s.length()][s.length()];
        for (int j = 0; j < s.length(); j++){
            for (int i = 0; i <= j; i++){
                dp[i][j] = s.charAt(i) == s.charAt(j) && ((j - i <= 2) || dp[i + 1][j - 1]);
                if (dp[i][j]){
                    if (j - i + 1 > maxLen){
                        maxLen = j - i + 1;
                        res = s.substring(i, j + 1);
                    }
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {

    }
}
