package com.ktao.leetcode.图;

import java.util.*;

/**
 * 261.以图判树
 * @author kongtao
 * @version 1.0
 * @description: 【Middle】
 * @date 2020/4/16
 **/
public class GraphValidTree {
    /**
     * 给定从 0 到 n-1 标号的 n 个结点，和一个无向边列表（每条边以结点对来表示），请编写一个函数用来判断这些边是否能够形成一个合法有效的树结构。
     *
     * 示例 1：
     *
     * 输入: n = 5, 边列表 edges = [[0,1], [0,2], [0,3], [1,4]]
     * 输出: true
     * 示例 2:
     *
     * 输入: n = 5, 边列表 edges = [[0,1], [1,2], [2,3], [1,3], [1,4]]
     * 输出: false
     */
    //解法1：DFS(**)
    public boolean validTree1(int n, int[][] edges) {
        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < n; i++){
            graph.add(new ArrayList<>());
        }
        // 构建图（邻接表形式）
        for (int i = 0; i < edges.length; i++){
            graph.get(edges[i][0]).add(edges[i][1]);
            graph.get(edges[i][1]).add(edges[i][0]);
        }
        // 访问判定数组
        boolean[] visited = new boolean[n];
        // 从0开始搜索，若成环返回false
        if (!helper(graph, visited, 0, -1)) return false;
        // 判断是否为单连通分量
        for (boolean visit : visited){
            if (!visit) return false;
        }
        return true;
    }
    private boolean helper(List<List<Integer>> graph, boolean[] visited, int cur, int pre) {
        if (visited[cur]) return false;
        visited[cur] = true;
        for (Integer node : graph.get(cur)){
            // 过滤相邻节点的重复访问
            if (node != pre){
                if (!helper(graph, visited, node, cur)) return false;
            }
        }
        return true;
    }

    //解法2：BFS(**)
    public boolean validTree2(int n, int[][] edges) {
        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < n; i++){
            graph.add(new ArrayList<>());
        }
        // 构建图（邻接表形式）
        for (int i = 0; i < edges.length; i++){
            graph.get(edges[i][0]).add(edges[i][1]);
            graph.get(edges[i][1]).add(edges[i][0]);
        }
        Set<Integer> visited = new HashSet<>();
        Queue<Integer> queue = new LinkedList<>();
        queue.add(0);
        visited.add(0);
        while (!queue.isEmpty()){
            int cur = queue.poll();
            for (Integer next : graph.get(cur)){
                if (visited.contains(next)) return false;
                queue.add(next);
                visited.add(next);
                graph.get(next).remove(graph.get(next).indexOf(cur));
            }
        }
        return visited.size() == n;
    }

    //解法3：并差集(***)
    public boolean validTree3(int n, int[][] edges) {
        int[] parents = new int[n];
        for (int i = 0; i < n; i++) parents[i] = -1;
        for (int[] edge : edges){
            int x = find(parents, edge[0]);
            int y = find(parents, edge[1]);
            if (x == y) return false;
            parents[x] = y;
        }
        return edges.length == n - 1;
    }

    private int find(int[] parent, int x){
        while (parent[x] != -1) x = parent[x];
        return x;
    }

    public static void main(String[] args) {
        GraphValidTree solution = new GraphValidTree();
        int[][] edges = {{0,1},{0,2},{0,3},{1,4}};
        System.out.println(solution.validTree1(5, edges));
        System.out.println(solution.validTree2(5, edges));
        System.out.println(solution.validTree3(5, edges));
    }
}
