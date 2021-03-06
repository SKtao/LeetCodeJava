package com.ktao.leetcode.贪心算法;

import java.util.Arrays;

/**
 * 135. 分发糖果
 * @author kongtao
 * @version 1.0
 * @description:
 * @date 2020/5/17
 **/
public class Candy {
    /**
     * 老师想给孩子们分发糖果，有 N 个孩子站成了一条直线，老师会根据每个孩子的表现，预先给他们评分。
     *
     * 你需要按照以下要求，帮助老师给这些孩子分发糖果：
     *
     * 每个孩子至少分配到 1 个糖果。
     * 相邻的孩子中，评分高的孩子必须获得更多的糖果。
     * 那么这样下来，老师至少需要准备多少颗糖果呢？
     *
     * 示例 1:
     *
     * 输入: [1,0,2]
     * 输出: 5
     * 解释: 你可以分别给这三个孩子分发 2、1、2 颗糖果。
     * 示例 2:
     *
     * 输入: [1,2,2]
     * 输出: 4
     * 解释: 你可以分别给这三个孩子分发 1、2、1 颗糖果。
     *      第三个孩子只得到 1 颗糖果，这已满足上述两个条件。
     */
    public int candy(int[] ratings) {
        int[] candies = new int[ratings.length];
        // 初始化：每个孩子至少一个糖果
        Arrays.fill(candies, 1);
        // 从前往后遍历
        for (int i = 1; i < ratings.length; i++){
            // 当前孩子评分比前一个孩子高
            if (ratings[i] > ratings[i-1]){
                // 当前孩子的糖果比前一个孩子糖果多分一个
                candies[i] = candies[i-1] + 1;
            }
        }
        // 从后往前遍历
        for (int j = ratings.length - 2; j >= 0; j--){
            // 当前孩子评分比后一个高
            if (ratings[j] > ratings[j+1]){
                // 当前孩子的糖果比后一个孩子糖果多分一个
                candies[j] = Math.max(candies[j], candies[j+1]+1);
            }
        }
        int total = 0;
        for (int num : candies) total += num;
        return total;
    }
}
