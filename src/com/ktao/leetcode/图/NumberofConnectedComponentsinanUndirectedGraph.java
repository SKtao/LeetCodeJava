package com.ktao.leetcode.图;

/**
 * 323.无向图中连通分量的数目
 * @author kongtao
 * @version 1.0
 * @description: 【Middle】
 * @date 2020/4/17
 **/
public class NumberofConnectedComponentsinanUndirectedGraph {
    /**
     * 给定编号从 0 到 n-1 的 n 个节点和一个无向边列表（每条边都是一对节点），请编写一个函数来计算无向图中连通分量的数目。
     *
     * 示例 1:
     *
     * 输入: n = 5 和 edges = [[0, 1], [1, 2], [3, 4]]
     *
     *      0          3
     *      |          |
     *      1 --- 2    4
     *
     * 输出: 2
     * 示例 2:
     *
     * 输入: n = 5 和 edges = [[0, 1], [1, 2], [2, 3], [3, 4]]
     *
     *      0           4
     *      |           |
     *      1 --- 2 --- 3
     *
     * 输出:  1
     * 注意:
     * 你可以假设在 edges 中不会出现重复的边。而且由于所以的边都是无向边，[0, 1] 与 [1, 0]  相同，所以它们不会同时在 edges 中出现
     */
    // 并查集
    public int countComponents(int n, int[][] edges) {
        int[] parents = new int[n];
        for (int i = 0; i < n; i++) parents[i] = -1;
        for (int[] edge : edges){
            int x = find(parents, edge[0]);
            int y = find(parents, edge[1]);
            if (x == y) continue;
            parents[x] = y;
        }
        int count = 0;
        for (int i = 0; i < n; i++){
            if (parents[i] == -1) count++;
        }
        return count;
    }

    // 查找父节点
    private int find(int[] parent, int x){
        while (parent[x] != -1) x = parent[x];
        return x;
    }


    public static void main(String[] args) {

    }
}
