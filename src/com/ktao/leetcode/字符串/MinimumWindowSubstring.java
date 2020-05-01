package com.ktao.leetcode.字符串;

import java.util.HashMap;
import java.util.Map;

/**
 * 76. Minimum Window Substring
 * @author kongtao
 * @version 1.0
 * @description:
 * @date 2020/5/1
 **/
public class MinimumWindowSubstring {
    /**
     * Given a string S and a string T, find the minimum window in S which will contain all the characters in T in complexity O(n).
     *
     * Example:
     *
     * Input: S = "ADOBECODEBANC", T = "ABC"
     * Output: "BANC"
     * Note:
     *
     * If there is no such window in S that covers all characters in T, return the empty string "".
     * If there is such window, you are guaranteed that there will always be only one unique minimum window in S.
     */
    public String minWindow(String s, String t) {
        // corner case
        if (s == null || t.isEmpty() || s.length() < t.length()) return "";
        // create hashmap to store String t
        Map<Character, Integer> map = new HashMap<>();
        for (char c : t.toCharArray()){
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        // sliding window on String s
        int start = 0, end = 0;
        int index = 0;
        int minLen = Integer.MAX_VALUE;
        int counter = 0;
        while (end < s.length()){
            char c = s.charAt(end);
            if (map.containsKey(c)){
                map.put(c, map.get(c) - 1);
                // 已经匹配完一个字符
                if (map.get(c) == 0) counter++;
            }
            end++;
            // 找到一个解
            while (counter == map.size()){
                if (minLen > end - start){
                    minLen = end - start;
                    index = start;
                }
                // 回溯
                char tempC = s.charAt(start);
                if (map.containsKey(tempC)){
                    map.put(tempC, map.get(tempC) + 1);
                    if (map.get(tempC) > 0) counter--;
                }
                start++;
            }
        }
        // return
        return minLen == Integer.MAX_VALUE ? "" : s.substring(index, index + minLen);
    }
}
