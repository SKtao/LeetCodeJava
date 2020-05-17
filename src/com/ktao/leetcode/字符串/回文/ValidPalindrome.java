package com.ktao.leetcode.字符串.回文;

/**
 * 125. 验证回文串
 * @author kongtao
 * @version 1.0
 * @description:
 * @date 2020/5/16
 **/
public class ValidPalindrome {
    /**
     * 给定一个字符串，验证它是否是回文串，只考虑字母和数字字符，可以忽略字母的大小写。
     *
     * 说明：本题中，我们将空字符串定义为有效的回文串。
     *
     * 示例 1:
     *
     * 输入: "A man, a plan, a canal: Panama"
     * 输出: true
     * 示例 2:
     *
     * 输入: "race a car"
     * 输出: false
     */

    // 注意下标越界
    public boolean isPalindrome(String s) {
        if (s.isEmpty() || s.length() <= 1) return true;
        int i = 0, j = s.length() - 1;
        while (i <= j){
            while (i <= j && !Character.isLetterOrDigit(s.charAt(i))) i++;
            while (i <= j && !Character.isLetterOrDigit(s.charAt(j))) j--;
            if (i <= j && Character.toUpperCase(s.charAt(i)) != Character.toUpperCase(s.charAt(j))){
                return false;
            }
            i++;j--;
        }
        return true;
    }
}
