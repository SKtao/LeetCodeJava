package com.ktao.leetcode.字符串;

import java.util.HashMap;
import java.util.Map;

/**
 * 3. 无重复字符的最长子串
 * @version 1.0
 * @author: kongtao
 * @description:
 * @date: 2020/4/24 8:24 下午
 */
public class LongestSubstringWithoutRepeatingCharacters {
    /**
     * 给定一个字符串，请你找出其中不含有重复字符的 最长子串 的长度。
     *
     * 示例 1:
     *
     * 输入: "abcabcbb"
     * 输出: 3
     * 解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
     * 示例 2:
     *
     * 输入: "bbbbb"
     * 输出: 1
     * 解释: 因为无重复字符的最长子串是 "b"，所以其长度为 1。
     */
    public int lengthOfLongestSubstring(String s) {
        Map<Character, Integer> map = new HashMap<>();
        int left = 0;
        int maxLen = 0;
        for (int right = 0; right < s.length(); right++){
            if (map.containsKey(s.charAt(right))){
                left = Math.max(left, map.get(s.charAt(right)) + 1);
            }
            maxLen = Math.max(maxLen, right - left + 1);
            map.put(s.charAt(right), right);

        }
        return maxLen;
    }
}
