package com.ktao.leetcode.图;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 301.删除无效的括号
 * @author kongtao
 * @version 1.0
 * @description: 【Hard】
 * @date 2020/4/13
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
        int l = 0, r = 0;
        for (char ch : s.toCharArray()){
            if (ch == '(') l++;
            if (l == 0 && ch ==')') r++;
            if (l != 0 && ch == ')') l--;
        }
        List<String> res = new ArrayList<>();
        dfs(res, s, 0, l, r);
        return res;
    }

    private void dfs(List<String> res, String s, int start, int l, int r) {
        // 合法解
        if (l == 0 && r == 0 && isValid(s)) {
            res.add(s);
            return;
        }
        for (int i = start; i < s.length(); i++){
            // 去重
            if (i != start && s.charAt(i) == s.charAt(i - 1)) continue;
            if (s.charAt(i) == '(' || s.charAt(i) == ')'){
                StringBuilder cur = new StringBuilder(s);
                cur.deleteCharAt(i);
                // 删除 (
                if (r > 0) dfs(res, cur.toString(), i, l, r - 1);
                // 删除 )
                else if (l > 0) dfs(res, cur.toString(), i, l - 1, r);
            }
        }
    }

    // 判断求出的字符串是否合法，这里采用提示中的方法
    private boolean isValid(String s) {
        if (s.equals("")) return true;
        if (s.charAt(0) == ')') return false;
        int left = 0;
        int right = 0;
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (ch == '(') {
                left++;
            } else if (ch == ')') {
                if (left > 0) {
                    left--;
                } else {
                    right++;
                }
            }
            if (right > 0) return false;
        }
        if (left != 0) return false;
        return true;
    }

    public static void main(String[] args) {
        String s = "()())()";
        RemoveInvalidParentheses solution = new RemoveInvalidParentheses();
        List<String> res = solution.removeInvalidParentheses(s);
        System.out.println(Arrays.toString(res.toArray(new String[0])));

    }

}
