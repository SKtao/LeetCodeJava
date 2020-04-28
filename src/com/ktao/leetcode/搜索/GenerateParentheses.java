package com.ktao.leetcode.搜索;

import java.util.ArrayList;
import java.util.List;

/**
 * 22.括号生成
 * @version 1.0
 * @author: kongtao
 * @description:
 * @date: 2020/4/27 9:08 上午
 */
public class GenerateParentheses {
    /**
     * 数字 n 代表生成括号的对数，请你设计一个函数，用于能够生成所有可能的并且 有效的 括号组合。
     *
     * 示例：
     *
     * 输入：n = 3
     * 输出：[
     *        "((()))",
     *        "(()())",
     *        "(())()",
     *        "()(())",
     *        "()()()"
     *      ]
     */

    public static List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList<>();
        if (n == 0) return res;
        helper(res,"", 1, 1, n);
        return res;
    }

    private static void helper(List<String> res, String cur, int left, int right, int n){
        if (cur.length() == 2 * n){
            res.add(cur);
            return;
        }
        if (left <= n){
            helper(res, cur + "(", left + 1, right, n);
        }
        if (right < left){
            helper(res, cur + ")", left, right + 1, n);
        }
    }

    public static void main(String[] args) {
        List<String> res = generateParenthesis(3);
        System.out.println("JUST TEST");
    }

}
