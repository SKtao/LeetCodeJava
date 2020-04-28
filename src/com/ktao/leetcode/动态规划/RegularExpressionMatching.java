package com.ktao.leetcode.动态规划;

/**
 * 10.正则表达式匹配
 * @version 1.0
 * @author: kongtao
 * @description:
 * @date: 2020/4/25 9:47 上午
 */
public class RegularExpressionMatching {
    /**
     * 给你一个字符串 s 和一个字符规律 p，请你来实现一个支持 '.' 和 '*' 的正则表达式匹配。
     *
     * '.' 匹配任意单个字符
     * '*' 匹配零个或多个前面的那一个元素
     * 所谓匹配，是要涵盖 整个 字符串 s的，而不是部分字符串。
     *
     * 说明:
     *
     * s 可能为空，且只包含从 a-z 的小写字母。
     * p 可能为空，且只包含从 a-z 的小写字母，以及字符 . 和 *。
     * 示例 1:
     *
     * 输入:
     * s = "aa"
     * p = "a"
     * 输出: false
     * 解释: "a" 无法匹配 "aa" 整个字符串。
     * 示例 2:
     *
     * 输入:
     * s = "aa"
     * p = "a*"
     * 输出: true
     * 解释: 因为 '*' 代表可以匹配零个或多个前面的那一个元素, 在这里前面的元素就是 'a'。因此，字符串 "aa" 可被视为 'a' 重复了一次。
     *
     *
     * boolean dp[i][j]：s[0-i] 与 p[0-j]是否匹配
     * dp[0][0] = true
     *
     * 1. p[i] = s[j]:  dp[i][j] = dp[i-1][j-1]
     * 2. p[j] = '.': dp[i][j] = dp[i-1][j-1]
     * 3. p[j] = '*':
     *     a. p[j-1] != s[i] : dp[i][j] = dp[i][j - 2]
     *     b. p[j-1] = s[i] or p[j-1] = '.' :
     *          dp[i][j] = dp[i][j-1] : a* => 一个a [a, a*]
     *          dp[i][j] = dp[i-1][j] : a* => 多个a [aaa, a*]
     *          dp[i][j] = dp[i][j-2] : a* => empty [a, aa*]
     *
     * 注意：下标越界问题
     */
    public static boolean isMatch(String s, String p) {
        int m = s.length(), n = p.length();
        boolean[][] dp = new boolean[m+1][n+1];
        dp[0][0] = true;
        // 预处理(p删除字符)
        for (int i = 1; i <= n; i++){
            if (p.charAt(i-1) == '*' && dp[0][i-2]){
                dp[0][i] = true;
            }
        }
        for (int i = 1; i <= m; i++){
            for (int j = 1; j <= n; j++){
                if (s.charAt(i-1) == p.charAt(j-1) || p.charAt(j-1) == '.'){
                    dp[i][j] = dp[i-1][j-1];
                } else if (p.charAt(j-1) == '*'){
                    if (p.charAt(j - 2) != s.charAt(i-1) && p.charAt(j-2) != '.'){
                        dp[i][j] = dp[i][j-2];
                    } else {
                        dp[i][j] = (dp[i][j-1] || dp[i-1][j] || dp[i][j-2]);
                    }
                }
            }
        }
        return dp[m][n];
    }

    public static void main(String[] args) {
        System.out.println(isMatch("aab", "c*a*b"));
    }
}
