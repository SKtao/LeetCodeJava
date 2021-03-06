package com.ktao.leetcode.搜索;

import java.util.*;

/**
 * 127. 单词接龙
 * @author kongtao
 * @version 1.0
 * @description:
 * @date 2020/5/16
 **/
public class WordLadder {
    /**
     * 给定两个单词（beginWord 和 endWord）和一个字典，找到从 beginWord 到 endWord 的最短转换序列的长度。转换需遵循如下规则：
     *
     * 每次转换只能改变一个字母。
     * 转换过程中的中间单词必须是字典中的单词。
     * 说明:
     *
     * 如果不存在这样的转换序列，返回 0。
     * 所有单词具有相同的长度。
     * 所有单词只由小写字母组成。
     * 字典中不存在重复的单词。
     * 你可以假设 beginWord 和 endWord 是非空的，且二者不相同。
     * 示例 1:
     *
     * 输入:
     * beginWord = "hit",
     * endWord = "cog",
     * wordList = ["hot","dot","dog","lot","log","cog"]
     *
     * 输出: 5
     *
     * 解释: 一个最短转换序列是 "hit" -> "hot" -> "dot" -> "dog" -> "cog",
     *      返回它的长度 5。
     * 示例 2:
     *
     * 输入:
     * beginWord = "hit"
     * endWord = "cog"
     * wordList = ["hot","dot","dog","lot","log"]
     *
     * 输出: 0
     */
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        if (beginWord.length() != endWord.length()) return 0;
        Set<String> dict = new HashSet<>();
        for (String word : wordList) dict.add(word);

        Queue<String> queue = new LinkedList<>();
        queue.offer(beginWord);
        int level = 0;

        while (!queue.isEmpty()){
            level++;
            int size = queue.size();
            for (int i = 0; i < size; i++){
                String cur = queue.poll();
                if (cur.equals(endWord)) return level;
                StringBuilder sb = new StringBuilder(cur);
                for (int j = 0; j < cur.length(); j++){
                    for (char c = 'a'; c <= 'z'; c++){
                        if (cur.charAt(j) == c) continue;
                        sb.setCharAt(j, c);
                        if (dict.contains(sb.toString())){
                            queue.offer(sb.toString());
                            dict.remove(sb.toString());
                        }
                    }
                    // 回溯
                    sb.setCharAt(j, cur.charAt(j));
                }
            }
        }
        return 0;
    }
}
