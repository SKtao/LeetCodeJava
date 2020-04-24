package com.ktao.leetcode.图;

/**
 * 302.包含全部黑色像素的最小矩形
 * @author kongtao
 * @version 1.0
 * @description: 【Hard】
 * @date 2020/4/13
 **/
public class SmallestRectangleEnclosingBlackPixels {

    /**
     * 图片在计算机处理中往往是使用二维矩阵来表示的。
     * 假设，这里我们用的是一张黑白的图片，那么 0 代表白色像素，1 代表黑色像素。
     * 其中黑色的像素他们相互连接，也就是说，图片中只会有一片连在一块儿的黑色像素（像素点是水平或竖直方向连接的）。
     * 那么，给出某一个黑色像素点 (x, y) 的位置，你是否可以找出包含全部黑色像素的最小矩形（与坐标轴对齐）的面积呢？
     * 示例:
     *
     * 输入:
     * [
     *   "0010",
     *   "0110",
     *   "0100"
     * ]
     * 和 x = 0, y = 2
     *
     * 输出: 6
     */
    private int top, bottom, left, right;
    public int minArea(char[][] image, int x, int y) {
        if(image.length == 0 || image[0].length == 0) return 0;
        top = bottom = x;
        left = right = y;
        dfs(image, x, y);
        return (right - left) * (bottom - top);
    }
    private void dfs(char[][] image, int x, int y){
        if(x < 0 || y < 0 || x >= image.length || y >= image[0].length ||
                image[x][y] == '0')
            return;
        image[x][y] = '0'; // mark visited black pixel as white
        top = Math.min(top, x);
        bottom = Math.max(bottom, x + 1);
        left = Math.min(left, y);
        right = Math.max(right, y + 1);
        dfs(image, x + 1, y);
        dfs(image, x - 1, y);
        dfs(image, x, y - 1);
        dfs(image, x, y + 1);
    }

    public static void main(String[] args) {

    }
}
