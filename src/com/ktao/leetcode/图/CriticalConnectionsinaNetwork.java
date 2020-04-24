package com.ktao.leetcode.图;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 1192.查找集群内的「关键连接」
 * @author kongtao
 * @version 1.0
 * @description: 【Hard】
 * @date 2020/4/18
 **/
public class CriticalConnectionsinaNetwork {
    /**
     * 力扣数据中心有 n 台服务器，分别按从 0 到 n-1 的方式进行了编号。
     *
     * 它们之间以「服务器到服务器」点对点的形式相互连接组成了一个内部集群，其中连接 connections 是无向的。
     *
     * 从形式上讲，connections[i] = [a, b] 表示服务器 a 和 b 之间形成连接。任何服务器都可以直接或者间接地通过网络到达任何其他服务器。
     *
     * 「关键连接」是在该集群中的重要连接，也就是说，假如我们将它移除，便会导致某些服务器无法访问其他服务器。
     *
     * 请你以任意顺序返回该集群内的所有 「关键连接」。
     *
     * 示例 1：
     *
     * 输入：n = 4, connections = [[0,1],[1,2],[2,0],[1,3]]
     * 输出：[[1,3]]
     * 解释：[[3,1]] 也是正确的。
     */
    List<List<Integer>> res = new ArrayList<>(); // 返回结果
    int[] deepArray; // 深度数组
    List<Integer>[] graph; // 无向图
    public List<List<Integer>> criticalConnections(int n, List<List<Integer>> connections) {
        deepArray = new int[n]; Arrays.fill(deepArray, -1); // 初始化深度数组
        graph = new ArrayList[n];
        for (int i = 0; i < n; i++){
            graph[i] = new ArrayList<>();
        }
        // 构建路径图
        for (List<Integer> connection: connections){
            graph[connection.get(0)].add(connection.get(1));
            graph[connection.get(1)].add(connection.get(0));
        }
        // dfs
        dfs(0, 0, 0);
        return res;
    }

    // current为当前节点
    // previous为前节点
    // deep为当前深度
    // 返回值为当前节点所有dfs路径终点的最小深度
    private int dfs(int current, int previous, int deep) {
        deepArray[current] = deep; // 将当前深度存入深度数组
        int result = Integer.MAX_VALUE;  // 返回值
        for (int i : graph[current]) { // 遍历当前节点能走的所有节点
            if (i == previous) continue;  // 不能走回头路
            int endDeep; // dfs终点深度
            // 深度为-1的点没走过，可以dfs
            if (deepArray[i] == -1) {
                endDeep = dfs(i, current, deep + 1);
                // 如果深度大于当前深度，说明当前点不在闭环上
                // 当前点与下一节点i之间的连线为答案之一
                if (endDeep > deep) {
                    res.add(Arrays.asList(current, i));
                }
            } else {
                // i节点深度不为-1，说明已经走过，i节点为dfs终点
                endDeep = deepArray[i];
            }
            // 更新最小深度
            result = Math.min(result, endDeep);
        }
        // 返回最小深度
        return result;
    }

    public static void main(String[] args) {

    }
}
