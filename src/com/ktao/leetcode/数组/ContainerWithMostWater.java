package com.ktao.leetcode.数组;

/**
 * 11. 盛最多水的容器
 * @version 1.0
 * @author: kongtao
 * @description:
 * @date: 2020/4/30 5:39 下午
 */
public class ContainerWithMostWater {
    /**
     * 给你 n 个非负整数 a1，a2，...，an，每个数代表坐标中的一个点 (i, ai) 。在坐标内画 n 条垂直线，垂直线 i 的两个端点分别为 (i, ai) 和 (i, 0)。找出其中的两条线，使得它们与 x 轴共同构成的容器可以容纳最多的水。
     *
     * 说明：你不能倾斜容器，且 n 的值至少为 2。
     * 图中垂直线代表输入数组 [1,8,6,2,5,4,8,3,7]。在此情况下，容器能够容纳水（表示为蓝色部分）的最大值为 49。
     * 示例：
     *
     * 输入：[1,8,6,2,5,4,8,3,7]
     * 输出：49
     */
    public int maxArea(int[] height) {
        int left = 0, right = height.length - 1;
        int maxArea = Integer.MIN_VALUE;
        while (left < right){
            int curArea = Math.min(height[left] , height[right]) * (right - left);
            maxArea = Math.max(maxArea, curArea);
            if (height[left] <= height[right]){
                left++;
            } else {
                right--;
            }
        }
        return maxArea;
    }
}

