package com.ktao.leetcode.数学;

import java.util.HashMap;
import java.util.Map;

/**
 * 149. 直线上最多的点数
 * @author kongtao
 * @version 1.0
 * @description:
 * @date 2020/5/18
 **/
public class MaxPointsOnALine {
    /**
     * 给定一个二维平面，平面上有 n 个点，求最多有多少个点在同一条直线上。
     *
     * 示例 1:
     *
     * 输入: [[1,1],[2,2],[3,3]]
     * 输出: 3
     * 解释:
     * ^
     * |
     * |        o
     * |     o
     * |  o  
     * +------------->
     * 0  1  2  3  4
     * 示例 2:
     *
     * 输入: [[1,1],[3,2],[5,3],[4,1],[2,3],[1,4]]
     * 输出: 4
     * 解释:
     * ^
     * |
     * |  o
     * |     o        o
     * |        o
     * |  o        o
     * +------------------->
     * 0  1  2  3  4  5  6
     */

    /**
     * 思路：固定一个点，找其他点和这个点组成直线，统计其斜率
     * 求斜率：
     * 1.用最大约数方法(gcd), 把他化成最简形式, 3/6 == 2/4 == 1/2
     * 2.除数(不太精确, 速度快!)
     */
    public int maxPoints(int[][] points) {
        int n = points.length;
        if (n <= 2) return n;
        int res = 0;
        for (int i = 0; i < n - 1; i++){
            Map<String, Integer> slope = new HashMap<>();
            // 重合点的个数
            int repeatCount = 0;
            // 以当前节点为准，同一线上最多点的个数
            int curMax = 0;
            for (int j = i + 1; j < n; j++){
                int dy = points[i][1] - points[j][1];
                int dx = points[i][0] - points[j][0];
                // 重合
                if (dx == 0 && dy == 0) {
                    repeatCount++;
                    continue;
                }
                // 最大公约数
                int g = gcd(dy, dx);
                if (g != 0){
                    dx /= g;
                    dy /= g;
                }
                String slopRatio = dy + "/" + dx;
                slope.put(slopRatio, slope.getOrDefault(slopRatio, 0) + 1);
                curMax = Math.max(curMax, slope.get(slopRatio));
            }
            res = Math.max(res, repeatCount + curMax + 1);
        }
        return res;
    }

    /**
     * 最大公约数
     * @param dy
     * @param dx
     * @return
     */
    private int gcd(int dy, int dx) {
        if (dx == 0) return dy;
        else return gcd(dx, dy % dx);
    }
}
