package com.ktao.leetcode.动态规划;

import java.util.Stack;

/**
 * 32.Longest Valid Parentheses
 * @author kongtao
 * @version 1.0
 * @description:
 * @date 2020/5/2
 **/
public class LongestValidParentheses {
    /**
     * Given a string containing just the characters '(' and ')', find the length of the longest valid (well-formed) parentheses substring.
     * <p>
     * Example 1:
     * <p>
     * Input: "(()"
     * Output: 2
     * Explanation: The longest valid parentheses substring is "()"
     * Example 2:
     * <p>
     * Input: ")()())"
     * Output: 4
     * Explanation: The longest valid parentheses substring is "()()"
     */
    // Solution 1：stack
    public int longestValidParentheses1(String s) {
        Stack<Integer> stack = new Stack<>();
        int res = 0;
        int start = -1;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                stack.push(i);
            } else {
                // 更新起始点 "())()"
                if (stack.isEmpty()) {
                    start = i;
                } else {
                    stack.pop();
                    // "()()"
                    if (stack.isEmpty()) {
                        res = Math.max(res, i - start);
                        // "(())
                    } else {
                        res = Math.max(res, i - stack.peek());
                    }
                }
            }
        }
        return res;
    }
    /**
     * Solution2：Dynamic Program
     *
     * 1. s[i] = ')' and s[i-1] = '(' : .....()
     *    dp[i] = dp[i-2] + 2
     * 2. s[i] = ')' and s[i-1] = ')' :  ....))
     *    if s[i - dp[i-1] - 1] = '(' : ..(....))
     *    dp[i] = dp[i-1] + dp[i - dp[i-1]-2] + 2
     */
    public int longestValidParentheses2(String s) {
        int maxans = 0;
        int dp[] = new int[s.length()];
        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i) == ')') {
                if (s.charAt(i - 1) == '(') {
                    dp[i] = (i >= 2 ? dp[i - 2] : 0) + 2;
                } else if (i - dp[i - 1] > 0 && s.charAt(i - dp[i - 1] - 1) == '(') {
                    dp[i] = dp[i - 1] + ((i - dp[i - 1]) >= 2 ? dp[i - dp[i - 1] - 2] : 0) + 2;
                }
                maxans = Math.max(maxans, dp[i]);
            }
        }
        return maxans;
    }
}