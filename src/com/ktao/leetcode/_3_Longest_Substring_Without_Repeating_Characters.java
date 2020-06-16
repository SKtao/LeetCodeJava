package com.ktao.leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * 3.无重复字符的最长子串
 * @author kongtao
 * @version 1.0
 * @description:
 * @date 2020/6/15
 **/
public class _3_Longest_Substring_Without_Repeating_Characters {
    /**
     * 给定一个字符串，请你找出其中不含有重复字符的 最长子串的长度
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
