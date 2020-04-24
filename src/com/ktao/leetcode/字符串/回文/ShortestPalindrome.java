package com.ktao.leetcode.字符串.回文;

/**
 * 214.最短回文串
 * @version 1.0
 * @author: kongtao
 * @description:
 * @date: 2020/4/24 11:06 下午
 */
public class ShortestPalindrome {
    /**
     * 给定一个字符串 s，你可以通过在字符串前面添加字符将其转换为回文串。找到并返回可以用这种方式转换的最短回文串。
     *
     * 示例 1:
     *
     * 输入: "aacecaaa"
     * 输出: "aaacecaaa"
     * 示例 2:
     *
     * 输入: "abcd"
     * 输出: "dcbabcd"
     */
    public static String shortestPalindrome(String s) {
        int i = 0, j = s.length() - 1;
        while (j >= 0) {
            if (s.charAt(i) == s.charAt(j)) {
                i++;
            }
            j--;
        }
        //此时代表整个字符串是回文串
        if (i == s.length()) {
            return s;
        }
        //后缀
        String suffix = s.substring(i);
        //后缀倒置
        String reverse = new StringBuilder(suffix).reverse().toString();
        //递归 s[0,i),寻找开头开始的最长回文串，将其余部分加到开头和结尾
        return reverse + shortestPalindrome(s.substring(0, i)) + suffix;
    }

    public static void main(String[] args) {
        System.out.println(shortestPalindrome("aacecaaa"));
        System.out.println(shortestPalindrome("aabba"));
    }
}
