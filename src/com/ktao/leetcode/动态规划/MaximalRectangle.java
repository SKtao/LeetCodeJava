package com.ktao.leetcode.动态规划;

import com.ktao.leetcode.数组.LargestRectangleinHistogram;

import java.util.Stack;

/**
 * 85. Maximal Rectangle
 * @author kongtao
 * @version 1.0
 * @description:
 * @date 2020/5/2
 * 84题的变形：{@link LargestRectangleinHistogram}
 **/
public class MaximalRectangle {
    /**
     * Given a 2D binary matrix filled with 0's and 1's, find the largest rectangle containing only 1's and return its area.
     *
     * Example:
     *
     * Input:
     * [
     *   ["1","0","1","0","0"],
     *   ["1","0","1","1","1"],
     *   ["1","1","1","1","1"],
     *   ["1","0","0","1","0"]
     * ]
     * Output: 6
     */
    public int maximalRectangle(char[][] matrix) {
        if (matrix == null || matrix.length == 0) return 0;
        int[] heights = new int[matrix[0].length];
        int maxArea = 0;
        for (int i = 0; i < matrix.length; i++){
            for (int j = 0; j < matrix[0].length; j++){
                if (matrix[i][j] == '1'){
                    heights[j]++;
                } else {
                    heights[j] = 0;
                }
            }
            maxArea = Math.max(maxArea, largestRectangleArea(heights));
        }
        return maxArea;
    }

    public static int largestRectangleArea(int[] heights){
        Stack<Integer> stack = new Stack<>();
        int max = 0;
        // 添加-1便于处理左边界
        stack.push(-1);
        for(int i = 0; i < heights.length; i++){
            // 1. 栈中值不等于 -1 且 栈顶元素对应的高度 大于 正在遍历的元素的高度
            while(stack.peek() != -1 && heights[stack.peek()] > heights[i]){
                max = Math.max(max,heights[stack.pop()] * (i - stack.peek() - 1));
            }
            // 2. 栈中值不等于 -1 且 栈顶元素对应的高度  == 正在遍历的元素的高度
            // 直接把当前栈顶弹栈即可
            if(stack.peek() != -1 && heights[stack.peek()] == heights[i]){
                stack.pop();
            }
            stack.push(i);
        }
        // 遍历完了，但是没计算完
        while(stack.peek() != -1){
            max = Math.max(max,heights[stack.pop()] * (heights.length - stack.peek() - 1));
        }
        return max;
    }
}
