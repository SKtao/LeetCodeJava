package com.ktao.leetcode.图;

import java.util.*;

/**
 * 269.火星词典
 * @author kongtao
 * @version 1.0
 * @description: 【Hard】
 * @date 2020/4/18
 **/
public class AlienDictionary {
    /**
     * 现有一种使用字母的全新语言，这门语言的字母顺序与英语顺序不同。
     * 假设，您并不知道其中字母之间的先后顺序。但是，会收到词典中获得一个 不为空的 单词列表。因为是从词典中获得的，所以该单词列表内的单词已经 按这门新语言的字母顺序进行了排序。
     * 您需要根据这个输入的列表，还原出此语言中已知的字母顺序。
     * 示例 1：
     *
     * 输入:
     * [
     *   "wrt",
     *   "wrf",
     *   "er",
     *   "ett",
     *   "rftt"
     * ]
     * 输出: "wertf"
     * 示例 2：
     *
     * 输入:
     * [
     *   "z",
     *   "x"
     * ]
     * 输出: "zx"
     * 示例 3：
     *
     * 输入:
     * [
     *   "z",
     *   "x",
     *   "z"
     * ]
     * 输出: "" 
     * 解释: 此顺序是非法的，因此返回 ""。
     */
    // BFS
    public String alienOrder(String[] words) {
        int[] indegree = new int[26];
        Map<Character, Set<Character>> graph = new HashMap<>();
        // 构建图
        buildGraph(graph, words, indegree);
        // BFS
        return bfs(graph, indegree);
    }

    private void buildGraph(Map<Character, Set<Character>> graph, String[] words, int[] indegree){
        for (String word : words){
            for (char c : word.toCharArray()){
                graph.putIfAbsent(c, new HashSet<>());
            }
        }

        for (int i = 1; i < words.length; i++){
            String first = words[i - 1];
            String second = words[i];
            int len = Math.min(first.length(), second.length());
            int j = 0;
            for (; j < len; j++){
                if (first.charAt(j) != second.charAt(j)){
                    char from = first.charAt(j);
                    char to = second.charAt(j);
                    if (!graph.get(from).contains(to)){
                        graph.get(from).add(to);
                        // 入度++
                        indegree[to - 'a']++;
                    }
                    break;
                }
            }
            if (j == len && first.length() > second.length()){
                graph.clear();
                return;
            }
        }
    }

    private String bfs(Map<Character, Set<Character>> graph, int[] indegree){
        StringBuilder sb = new StringBuilder();
        int totalChars = graph.size();
        Queue<Character> queue = new LinkedList<>();;
        for (char c : graph.keySet()){
            if (indegree[c - 'a'] == 0){
                sb.append(c);
                queue.offer(c);
            }
        }
        while (!queue.isEmpty()){
            char from = queue.poll();
            if (graph.get(from) == null || graph.get(from).size() == 0) continue;
            for (char to : graph.get(from)){
                indegree[to - 'a']--;
                if (indegree[to - 'a'] == 0){
                    queue.offer(to);
                    sb.append(to);
                }
            }
        }
        System.out.println(sb.length() + "," + totalChars);
        return sb.length() == totalChars ? sb.toString() : "";
    }

    public static void main(String[] args) {

    }
}
