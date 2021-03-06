package com.ktao.leetcode.动态规划;

import java.util.Arrays;

/**
 * 123. 买卖股票的最佳时机 III
 * @author kongtao
 * @version 1.0
 * @description:
 * @date 2020/5/16
 **/
public class _123_BestTimetoBuyandSellStockIII {
    /**
     * 给定一个数组，它的第 i 个元素是一支给定的股票在第 i 天的价格。
     *
     * 设计一个算法来计算你所能获取的最大利润。你最多可以完成 两笔 交易。
     *
     * 注意: 你不能同时参与多笔交易（你必须在再次购买前出售掉之前的股票）。
     *
     * 示例 1:
     *
     * 输入: [3,3,5,0,0,3,1,4]
     * 输出: 6
     * 解释: 在第 4 天（股票价格 = 0）的时候买入，在第 6 天（股票价格 = 3）的时候卖出，这笔交易所能获得利润 = 3-0 = 3 。
     *      随后，在第 7 天（股票价格 = 1）的时候买入，在第 8 天 （股票价格 = 4）的时候卖出，这笔交易所能获得利润 = 4-1 = 3 。
     * 示例 2:
     *
     * 输入: [1,2,3,4,5]
     * 输出: 4
     * 解释: 在第 1 天（股票价格 = 1）的时候买入，在第 5 天 （股票价格 = 5）的时候卖出, 这笔交易所能获得利润 = 5-1 = 4 。  
     *      注意你不能在第 1 天和第 2 天接连购买股票，之后再将它们卖出。  
     *      因为这样属于同时参与了多笔交易，你必须在再次购买前出售掉之前的股票。
     * 示例 3:
     *
     * 输入: [7,6,4,3,1]
     * 输出: 0
     * 解释: 在这个情况下, 没有交易完成, 所以最大利润为 0。
     */
    public static int maxProfit(int[] prices) {
        // 每次交易买入后的利润
        int[] dpBuy = new int[2];
        // 每次交易卖出后的利润
        int[] dpSell = new int[2];
        Arrays.fill(dpBuy, Integer.MIN_VALUE);
        // 遍历每一支股票，两次交易对每一次股票都可能进行买入和卖出
        for (int i = 0; i < prices.length; i++){
            for (int j = 0; j < 2; j++){
                // 本次交易之前的交易利润
                int pre = (j == 0) ? 0 : dpSell[j - 1];
                // 本次交易进行买入prices[i]的利润(买入：- prices[i])
                dpBuy[j] = Math.max(dpBuy[j], pre - prices[i]);
                // 本次交易进行卖出prices[i]的利润(卖出：+ prices[i])
                dpSell[j] = Math.max(dpSell[j], dpBuy[j] + prices[i]);
            }
        }
        return dpSell[1];
    }

    public static void main(String[] args) {
        int[] prices = {3, 3, 5, 0, 0, 3, 1, 4};
        System.out.println(maxProfit(prices));
    }
}
