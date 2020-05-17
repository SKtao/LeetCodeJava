package com.ktao.leetcode.字符串.回文;

/**
 * 680. 验证回文字符串 Ⅱ
 * @author kongtao
 * @version 1.0
 * @description:
 * @date 2020/5/16
 **/
public class ValidPalindromeII {
    /**
     * 给定一个非空字符串 s，最多删除一个字符。判断是否能成为回文字符串。
     *
     * 示例 1:
     *
     * 输入: "aba"
     * 输出: True
     * 示例 2:
     *
     * 输入: "abca"
     * 输出: True
     * 解释: 你可以删除c字符。
     * 注意:
     *
     * 字符串只包含从 a-z 的小写字母。字符串的最大长度是50000。
     */

    public boolean validPalindrome(String s) {
        int i = 0, j = s.length() - 1;
        while (i <= j){
            if (s.charAt(i) == s.charAt(j)) {
                i++;j--;
            }
            else {
                return helper(s, i + 1, j) || helper(s, i, j - 1);
            }
        }
        return true;
    }

    private boolean helper(String s, int i, int j){
        while (i <= j){
            if (s.charAt(i) == s.charAt(j)) {
                i++; j--;
            } else {
                return false;
            }
        }
        return true;
    }
}
