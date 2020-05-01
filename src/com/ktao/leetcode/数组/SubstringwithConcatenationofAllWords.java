package com.ktao.leetcode.数组;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 30. 串联所有单词的子串
 * @author kongtao
 * @version 1.0
 * @description:
 * @date 2020/5/1
 **/
public class SubstringwithConcatenationofAllWords {
    /**
     * 给定一个字符串 s 和一些长度相同的单词 words。找出 s 中恰好可以由 words 中所有单词串联形成的子串的起始位置。
     *
     * 注意子串要与 words 中的单词完全匹配，中间不能有其他字符，但不需要考虑 words 中单词串联的顺序。
     *
     * 示例 1：
     *
     * 输入：
     *   s = "barfoothefoobarman",
     *   words = ["foo","bar"]
     * 输出：[0,9]
     * 解释：
     * 从索引 0 和 9 开始的子串分别是 "barfoo" 和 "foobar" 。
     * 输出的顺序不重要, [9,0] 也是有效答案。
     * 示例 2：
     *
     * 输入：
     *   s = "wordgoodgoodgoodbestword",
     *   words = ["word","good","best","word"]
     * 输出：[]
     */
    public List<Integer> findSubstring(String s, String[] words) {
        List<Integer> res = new ArrayList<>();
        if (null == words || words.length == 0) return res;
        int wordNum = words.length, wordLen = words[0].length();
        Map<String, Integer> map = new HashMap<>();
        // 记录单词数量
        for (String word : words){
            map.put(word, map.getOrDefault(word, 0) + 1);
        }
        // 遍历字符串
        for (int i = 0; i < s.length() - wordLen * wordNum + 1; i++){
            // 获取指定长度的子串
            String subStr = s.substring(i, i + wordLen * wordNum);
            Map<String, Integer> tmp = new HashMap<>();
            // 判断子串是否由字典所有单词组成
            for (int j = 0; j < wordLen * wordNum; j+= wordLen){
                String word = subStr.substring(j, j + wordLen);
                tmp.put(word, tmp.getOrDefault(word, 0) + 1);
            }
            // 添加满足条件的子串起始位置
            if (map.equals(tmp)) {
                res.add(i);
            }
        }
        return res;
    }
}
