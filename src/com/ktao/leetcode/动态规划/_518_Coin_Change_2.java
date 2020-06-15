package com.ktao.leetcode.动态规划;

/**
 * @author kongtao
 * @version 1.0
 * @description:
 * @date 2020/6/7
 **/
public class _518_Coin_Change_2 {
    /**
     * 给定不同面额的硬币和一个总金额。写出函数来计算可以凑成总金额的硬币组合数。假设每一种面额的硬币有无限个。 
     *
     * 示例 1:
     *
     * 输入: amount = 5, coins = [1, 2, 5]
     * 输出: 4
     * 解释: 有四种方式可以凑成总金额:
     * 5=5
     * 5=2+2+1
     * 5=2+1+1+1
     * 5=1+1+1+1+1
     */
    // 多重背包问题
    public int change(int amount, int[] coins) {
        int[] dp = new int[amount + 1];
        // 初始化：数额0的拼凑方法数为1
        dp[0] = 1;
        for (int i = 0; i < coins.length; i++){
            for (int j = coins[i]; j <= amount; j++){
                dp[j] += dp[j - coins[i]];
            }
        }
        return dp[amount];
    }
}
