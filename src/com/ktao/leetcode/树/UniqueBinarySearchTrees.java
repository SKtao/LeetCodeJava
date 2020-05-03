package com.ktao.leetcode.树;

/**
 * 96. Unique Binary Search Trees
 * @author kongtao
 * @version 1.0
 * @description:
 * @date 2020/5/3
 **/
public class UniqueBinarySearchTrees {
    /**
     * Given n, how many structurally unique BST's (binary search trees) that store values 1 ... n?
     *
     * Example:
     *
     * Input: 3
     * Output: 5
     * Explanation:
     * Given n = 3, there are a total of 5 unique BST's:
     *
     *    1         3     3      2      1
     *     \       /     /      / \      \
     *      3     2     1      1   3      2
     *     /     /       \                 \
     *    2     1         2                 3
     */
    // 递归
    public int numTrees1(int n) {
        int num = 0;
        if (n <= 1) return 1;
        for (int i = 0; i < n; i++){
            num += numTrees1(i) * numTrees1(n - 1 - i);
        }
        return num;
    }

    // dp
    public int numTrees2(int n){
        int[] dp = new int[n+1];
        dp[0] = 1; dp[1] = 1;
        for (int i = 2; i <= n; i++){
            for (int j = 1; j <= i; j++){
                dp[i] += dp[j - 1] * dp[i - j];
            }
        }
        return dp[n];
    }
}
