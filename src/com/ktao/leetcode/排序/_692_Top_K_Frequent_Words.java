package com.ktao.leetcode.排序;

import java.util.*;

/**
 * @author kongtao
 * @version 1.0
 * @description:
 * @date 2020/6/7
 **/
public class _692_Top_K_Frequent_Words {
    public List<String> topKFrequent(String[] words, int k) {
        Map<String, Integer> map = new HashMap<>();
        for (String word : words){
            map.put(word, map.getOrDefault(word, 0) + 1);
        }
        PriorityQueue<Map.Entry<String, Integer>> maxHeap =
                new PriorityQueue<>((a, b) -> {
                    if (a.getValue() == b.getValue()){
                        return compare(a.getKey(), b.getKey());
                    }
                    return b.getValue() - a.getValue();
                });
        for (Map.Entry<String, Integer> entry : map.entrySet()){
            maxHeap.add(entry);
        }
        List<String> res = new ArrayList<>();
        for (int i = 1; i <= k; i++){
            res.add(maxHeap.poll().getKey());
        }
        return res;
    }

    private int compare(String a, String b){
        int len = Math.min(a.length(), b.length());
        for (int i = 0; i < len; i++){
            char c1 = a.charAt(i), c2 = b.charAt(i);
            if (c1 < c2) return -1;
            else if (c1 > c2) return 1;
            else continue;
        }
        return a.length() - b.length();
    }
}
