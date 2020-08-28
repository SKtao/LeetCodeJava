package com.ktao.leetcode;

import java.util.PriorityQueue;

/**
 * @author kongtao
 * @version 1.0
 * @description:
 * @date 2020/7/15
 **/
public class _407_Trapping_Rain_Water_II {
    /**
     * 给你一个 m x n 的矩阵，其中的值均为非负整数，代表二维高度图每个单元的高度，请计算图中形状最多能接多少体积的雨水。
     *
     * 示例：
     *
     * 给出如下 3x6 的高度图:
     * [
     *   [1,4,3,1,3,2],
     *   [3,2,1,3,2,4],
     *   [2,3,3,2,3,1]
     * ]
     *
     * 返回 4 。
     */
    private int[][] dirs = {{0,1}, {0, -1}, {1,0}, {-1, 0}};
    class Cell implements Comparable<Cell> {
        int row;
        int col;
        int height;
        public Cell(int r, int c, int h) {
            row = r;
            col = c;
            height = h;
        }
        public int compareTo(Cell otherCell) {
            if (this.height == otherCell.height) return 0;
            if (this.height > otherCell.height) return 1;
            return -1;
        }
    }
    public int trapRainWater(int[][] heightMap) {
        if (heightMap.length < 1) return 0;
        int m = heightMap.length, n = heightMap[0].length;
        PriorityQueue<Cell> heap = new PriorityQueue<>();
        boolean[][] visited = new boolean[m][n];

        for (int i = 0; i < n; i++) {
            visited[0][i] = true;
            visited[m - 1][i] = true;
            heap.offer(new Cell(0, i, heightMap[0][i]));
            heap.offer(new Cell(m - 1, i, heightMap[m - 1][i]));
        }
        for (int i = 0; i < m; i++) {
            visited[i][0] = true;
            visited[i][n - 1] = true;
            heap.offer(new Cell(i, 0, heightMap[i][0]));
            heap.offer(new Cell(i, n - 1, heightMap[i][n - 1]));
        }
        int res = 0;
        while (!heap.isEmpty()) {
            Cell cur = heap.poll();
            int row = cur.row, col = cur.col, h = cur.height;
            for (int[] d : dirs) {
                int r = d[0] + row;
                int c = d[1] + col;
                if (r > 0 && r < m - 1 && c > 0 && c < n - 1 && !visited[r][c]) {
                    visited[r][c] = true;
                    res += Math.max(0, h - heightMap[r][c]);
                    heap.offer(new Cell(r, c, Math.max(h, heightMap[r][c])));
                }
            }
        }
        return res;
    }
}
