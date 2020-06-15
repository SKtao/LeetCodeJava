package com.ktao.leetcode.搜索;

import java.util.*;

/**
 * @author kongtao
 * @version 1.0
 * @description:
 * @date 2020/6/7
 **/
public class _332_Reconstruct_Itinerary {

    public List<String> findItinerary(List<List<String>> tickets) {
        List<String> res = new LinkedList<>();
        if (tickets == null || tickets.size() == 0) return res;
        Map<String, PriorityQueue<String>> graph = new HashMap<>();
        // 构建邻接表
        for (List<String> pair : tickets){
            // 优先级队列，保证每次优先选择字典序靠前的机场
            PriorityQueue<String> neighbors = graph.computeIfAbsent(pair.get(0), k -> new PriorityQueue<>());
            neighbors.add(pair.get(1));
        }
        // 深度搜索
        dfs(graph, "JFK", res);
        return res;
    }

    private void dfs(Map<String, PriorityQueue<String>> graph, String start, List<String> res){
        PriorityQueue<String> neighbors = graph.get(start);
        while (neighbors != null && neighbors.size() > 0){
            String next = neighbors.poll();
            dfs(graph, next, res);

        }
        // 逆序插入
        res.add(0, start);
    }
}
