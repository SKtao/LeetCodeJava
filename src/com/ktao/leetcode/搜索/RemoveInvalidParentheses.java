package com.ktao.leetcode.搜索;

import java.util.ArrayList;
import java.util.List;

/**
 * 301.删除无效的括号
 * @author kongtao
 * @version 1.0
 * @description:
 * @date 2020/6/6
 **/
public class RemoveInvalidParentheses {
    /**
     * 删除最小数量的无效括号，使得输入的字符串有效，返回所有可能的结果。
     *
     * 说明: 输入可能包含了除 ( 和 ) 以外的字符。
     *
     * 示例 1:
     *
     * 输入: "()())()"
     * 输出: ["()()()", "(())()"]
     * 示例 2:
     *
     * 输入: "(a)())()"
     * 输出: ["(a)()()", "(a())()"]
     * 示例 3:
     *
     * 输入: ")("
     * 输出: [""]
     */
    public List<String> removeInvalidParentheses(String s) {
        int leftCount = 0, rightCount = 0;
        // 计算分别需要删除的左右括号数目
        for (char ch : s.toCharArray()) {
            if (ch == '(') leftCount++;
            else if (ch == ')'){
                if (leftCount == 0) {
                    rightCount++;
                } else {
                    leftCount--;
                }
            }
        }
        List<String> res = new ArrayList<>();
        dfs(s, 0, leftCount, rightCount, res);
        return res;
    }

    private void dfs(String s, int start, int leftCount, int rightCount, List<String> res) {
        if (leftCount == 0 && rightCount == 0){
            if (isValid(s)){
                res.add(s);
                return;
            }
        }
        for (int i = start; i < s.length(); i++){
            // 去重 + 过滤非括号字符
            if (i != start && s.charAt(i) == s.charAt(i - 1) || (s.charAt(i) != '(' && s.charAt(i) != ')')) continue;

            StringBuilder cur = new StringBuilder(s);
            // 删除当前字符
            cur.deleteCharAt(i);
            // 删除）
            if (rightCount > 0) dfs(cur.toString(), i, leftCount, rightCount - 1, res);
            // 删除(
            else if (leftCount > 0) dfs(cur.toString(), i, leftCount - 1, rightCount, res);
        }
    }

    // 判断是否合法
    private boolean isValid(String s){
        int count = 0;
        for (char ch : s.toCharArray()){
            if (ch == '(') count++;
            if (ch == ')') count--;
            if (count < 0) return false;
        }
        return count == 0;
    }
}
