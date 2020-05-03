package com.ktao.leetcode.数组;

import java.util.Stack;

/**
 * @author kongtao
 * @version 1.0
 * @description:
 * @date 2020/5/3
 **/
public class LargestRectangleinHistogram {
    /**
     * Given n non-negative integers representing the histogram's bar height where the width of each bar is 1,
     * find the area of largest rectangle in the histogram.
     * <p>
     * Example:
     * <p>
     * Input: [2,1,5,6,2,3]
     * Output: 10
     */
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

    public static void main(String[] args) {
        int[] heights = {3,2,1};
        System.out.println(largestRectangleArea(heights));
    }
}
