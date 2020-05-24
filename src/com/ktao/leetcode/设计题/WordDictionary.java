package com.ktao.leetcode.设计题;

/**
 * 211. 添加与搜索单词 - 数据结构设计
 * @author kongtao
 * @version 1.0
 * @description:
 * @date 2020/5/23
 * 思路：前缀树
 **/
public class WordDictionary {
    /**
     * 设计一个支持以下两种操作的数据结构：
     *
     * void addWord(word)
     * bool search(word)
     * search(word) 可以搜索文字或正则表达式字符串，字符串只包含字母 . 或 a-z 。 . 可以表示任何一个字母。
     *
     * 示例:
     *
     * addWord("bad")
     * addWord("dad")
     * addWord("mad")
     * search("pad") -> false
     * search("bad") -> true
     * search(".ad") -> true
     * search("b..") -> true
     * 说明:
     *
     * 你可以假设所有单词都是由小写字母 a-z 组成的。
     */
    class TrieNode{
        TrieNode[] children;
        boolean flag;

        public TrieNode(){
            children = new TrieNode[26];
            flag = false;
//            for (int i = 0; i < 26; i++) children[i] = null;
        }
    }
    private TrieNode root;

    public WordDictionary() {
        
    }

    public void addWord(String word) {

    }

    public boolean search(String word) {
        return true;
    }

}
