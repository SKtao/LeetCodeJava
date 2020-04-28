package com.ktao.leetcode.动态规划;

/**
 * 44. 通配符匹配
 * @version 1.0
 * @author: kongtao
 * @description:
 * @date: 2020/4/25 10:24 上午
 * 相似题：{@link RegularExpressionMatching}
 */
public class WildcardMatching {
    /**
     * 给定一个字符串 (s) 和一个字符模式 (p) ，实现一个支持 '?' 和 '*' 的通配符匹配。
     *
     * '?' 可以匹配任何单个字符。
     * '*' 可以匹配任意字符串（包括空字符串）。
     * 两个字符串完全匹配才算匹配成功。
     *
     * 说明:
     *
     * s 可能为空，且只包含从 a-z 的小写字母。
     * p 可能为空，且只包含从 a-z 的小写字母，以及字符 ? 和 *。
     * 示例 1:
     *
     * 输入:
     * s = "aa"
     * p = "a"
     * 输出: false
     * 解释: "a" 无法匹配 "aa" 整个字符串。
     *
     * boolean dp[i][j]：s[0-i] 与 p[0-j]是否匹配
     * dp[0][0] = true
     *
     * 1. p[i] = s[j]:  dp[i][j] = dp[i-1][j-1]
     * 2. p[j] = '.': dp[i][j] = dp[i-1][j-1]
     * 3. p[j] = '*':
     *      dp[i][j] = dp[i][j-1] : a* => 一个a [a, a*]
     *      dp[i][j] = dp[i-1][j] : a* => 多个a [aaa, a*]
     *      dp[i][j] = dp[i-1][j-1] : a* => aa [aac, aa*]
     *
     * 注意：下标越界问题
     */
    public boolean isMatch(String s, String p) {
        int m = s.length();
        int n = p.length();
        boolean[][] dp = new boolean[m+1][n+1];
        dp[0][0] = true;
        for (int i = 1; i <= n; i++){
            if (p.charAt(i-1) == '*'){
                dp[0][i] = dp[0][i-1];
            }
        }
        for (int i = 1; i <= m; i++){
            for (int j = 1; j <= n; j++){
                if (s.charAt(i - 1) == p.charAt(j-1) || p.charAt(j-1) == '?'){
                    dp[i][j] = dp[i-1][j-1];
                } else if (p.charAt(j-1) == '*'){
                    dp[i][j] = dp[i][j-1] || dp[i-1][j-1] || dp[i-1][j];
                }
            }
        }
        return dp[m][n];
    }

    public static void main(String[] args) {

    }
}
