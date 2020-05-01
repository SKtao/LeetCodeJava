package com.ktao.leetcode.数组;

import java.util.Stack;

/**
 * 42.Trapping Rain Water
 * @author kongtao
 * @version 1.0
 * @description:
 * @date 2020/5/1
 **/
public class TrappingRainWater {
    /**
     * Given n non-negative integers representing an elevation map where the width of each bar is 1, compute how much water it is able to trap after raining.
     *
     *
     * The above elevation map is represented by array [0,1,0,2,1,0,1,3,2,1,2,1]. In this case, 6 units of rain water (blue section) are being trapped. Thanks Marcos for contributing this image!
     *
     * Example:
     *
     * Input: [0,1,0,2,1,0,1,3,2,1,2,1]
     * Output: 6
     */
    //思路： 单调栈(递减)
    public int trap(int[] height) {
        int N = height.length;
        int res = 0;
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < N; i++){
            while (!stack.isEmpty() && height[stack.peek()] < height[i]){
                int bottom = stack.pop();
                int h = Math.min(height[stack.peek()], height[i]) - bottom;
                int w = i - stack.peek() - 1;
                res += w * h;
            }
            stack.push(height[i]);
        }
        return res;
    }
}
