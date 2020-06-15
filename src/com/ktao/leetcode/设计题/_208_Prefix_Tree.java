package com.ktao.leetcode.设计题;

/**
 * @author kongtao
 * @version 1.0
 * @description:
 * @date 2020/6/13
 **/
class TrieNode{
    private TrieNode[] links;
    private final int R = 26;
    private boolean isEnd;

    public TrieNode(){
        links = new TrieNode[R];
    }

    public boolean containsKey(char ch){
        return links[ch - 'a'] != null;
    }

    public TrieNode get(char ch){
        return links[ch - 'a'];
    }

    public void put(char ch, TrieNode node){
        links[ch - 'a'] = node;
    }

    public boolean isEnd(){
        return isEnd;
    }

    public void setEnd(){
        isEnd = true;
    }
}
public class _208_Prefix_Tree {

    private TrieNode root;

    public _208_Prefix_Tree(){
        root = new TrieNode();
    }

    public void insert(String word){
        TrieNode node = root;
        for (char ch : word.toCharArray()) {
            if (!node.containsKey(ch)){
                node.put(ch, new TrieNode());
            }
            node = node.get(ch);
        }
        node.setEnd();
    }

    public boolean search(String word) {
        TrieNode node = root;
        for (char ch : word.toCharArray()){
            if (!node.containsKey(ch)){
                return false;
            }
            node = node.get(ch);
        }
        return node.isEnd();
    }

    public boolean startsWith(String prefix) {
        TrieNode node = root;
        for (char ch : prefix.toCharArray()){
            if (!node.containsKey(ch)){
                return false;
            }
            node = node.get(ch);
        }
        return true;
    }
}
