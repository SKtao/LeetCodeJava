package com.ktao.leetcode.搜索.组合;

/**
 * 377.组合总和 Ⅳ
 * @version 1.0
 * @author: kongtao
 * @description:
 * @date: 2020/4/25 5:33 下午
 */
public class CombinationSumVI {
    /**
     *给定一个由正整数组成且不存在重复数字的数组，找出和为给定目标正整数的组合的个数。
     *
     * 示例:
     *
     * nums = [1, 2, 3]
     * target = 4
     *
     * 所有可能的组合为：
     * (1, 1, 1, 1)
     * (1, 1, 2)
     * (1, 2, 1)
     * (1, 3)
     * (2, 1, 1)
     * (2, 2)
     * (3, 1)
     *
     * 请注意，顺序不同的序列被视作不同的组合。
     *
     * 因此输出为 7。
     */
    // 注意：递归超时

    // 动态规划: dp[i]表示和为i的组合的个数, 遍历nums的各个元素x，若i>x，则dp[i]+=dp[i-x]。
    public int combinationSum4(int[] nums, int target) {
        int[] dp = new int[target + 1];
        dp[0] = 1;
        for (int i = 1; i <= target; i++){
            for (int num : nums){
                if (num <= i){
                    dp[i] += dp[i - num];
                }
            }
        }
        return dp[target];
    }

    public static void main(String[] args) {
        CombinationSumVI solution = new CombinationSumVI();
        int[] nums = {2,1,3};
        int target = 35;
        System.out.println(solution.combinationSum4(nums, target));
    }
}
