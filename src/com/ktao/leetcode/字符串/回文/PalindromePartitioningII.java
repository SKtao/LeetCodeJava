package com.ktao.leetcode.字符串.回文;

import java.util.Arrays;

/**
 * 132. 分割回文串 II
 * @author kongtao
 * @version 1.0
 * @description:
 * @date 2020/5/16
 **/
public class PalindromePartitioningII {
    /**
     * 给定一个字符串 s，将 s 分割成一些子串，使每个子串都是回文串。
     *
     * 返回符合要求的最少分割次数。
     *
     * 示例:
     *
     * 输入: "aab"
     * 输出: 1
     * 解释: 进行一次分割就可将 s 分割成 ["aa","b"] 这样两个回文子串。
     */
    public int minCut(String s) {
        boolean[][] dp = new boolean[s.length()][s.length()];
        int[] minCut = new int[s.length()];
        for (int i = 0; i < s.length(); i++) minCut[i] = i;
        for (int i = 1; i < s.length(); i++) {
            for (int j = 0; j <= i; j++) {
                if (s.charAt(j) == s.charAt(i) && (j + 1 > i - 1 || dp[j + 1][i - 1])) {
                    dp[j][i] = true;
                    if (j == 0) minCut[i] = 0;
                    else minCut[i] = Math.min(minCut[i], minCut[j - 1] + 1);
                }
            }
        }
        return minCut[s.length() - 1];
    }

}
