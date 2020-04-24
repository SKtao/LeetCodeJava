package com.ktao.leetcode.图;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 994.腐烂的橘子
 * @author kongtao
 * @version 1.0
 * @description: 【Middle】
 * @date 2020/4/18
 **/
public class RottingOranges {
    /**
     * 在给定的网格中，每个单元格可以有以下三个值之一：
     *
     * 值 0 代表空单元格；
     * 值 1 代表新鲜橘子；
     * 值 2 代表腐烂的橘子。
     * 每分钟，任何与腐烂的橘子（在 4 个正方向上）相邻的新鲜橘子都会腐烂。
     *
     * 返回直到单元格中没有新鲜橘子为止所必须经过的最小分钟数。如果不可能，返回 -1。
     */
    int[] dx = {0, 1, 0, -1};
    int[] dy = {1, 0, -1, 0};
    public int orangesRotting(int[][] grid) {
        if (grid == null || grid.length == 0) return 0;
        int m = grid.length;
        int n = grid[0].length;

        Queue<int[]> queue = new LinkedList<>();
        // 记录腐烂橘子的个数
        int count = 0;
        for (int i = 0; i < m; i++){
            for (int j = 0; j < n; j++){
                // 腐烂橘子入队列
                if (grid[i][j] == 2){
                    queue.offer(new int[]{i, j});
                } else if (grid[i][j] == 1){
                    count++;
                }
            }
        }
        if (count == 0) return 0;
        int res = 0;
        while (!queue.isEmpty()){
            res++;
            int size = queue.size();
            for (int i = 0; i < size; i++){
                int[] point = queue.poll();
                // 搜索4个方向
                for (int k = 0; k < 4; k++){
                    int x = point[0] + dx[k];
                    int y = point[1] + dy[k];
                    if (x < 0 || y < 0 || x >= m || y >= n || grid[x][y] == 0 || grid[x][y] == 2) continue;
                    grid[x][y] = 2;
                    queue.offer(new int[]{x, y});
                    count--;
                }
            }
        }
        if (count != 0) return -1;
        return res - 1;
    }
}
