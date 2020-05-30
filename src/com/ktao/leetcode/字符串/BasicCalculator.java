package com.ktao.leetcode.字符串;

import java.util.Stack;

/**
 * 224. 基本计算器
 * @author kongtao
 * @version 1.0
 * @description:
 * @date 2020/5/30
 **/
public class BasicCalculator {
    /**
     * 实现一个基本的计算器来计算一个简单的字符串表达式的值。
     *
     * 字符串表达式可以包含左括号 ( ，右括号 )，加号 + ，减号 -，非负整数和空格  。
     *
     * 示例 1:
     *
     * 输入: "1 + 1"
     * 输出: 2
     * 示例 2:
     *
     * 输入: " 2-1 + 2 "
     * 输出: 3
     * 示例 3:
     *
     * 输入: "(1+(4+5+2)-3)+(6+8)"
     * 输出: 23
     * 说明：
     *
     * 你可以假设所给定的表达式都是有效的。
     * 请不要使用内置的库函数 eval。
     */
    public static int calculate(String s) {
        int res = 0;
        Stack<Integer> stack = new Stack<>();
        int operator = 1;
        int num = 0;
        if (s == null || s.length() == 0) return res;
        for (int i = 0; i < s.length(); i++){
            char ch = s.charAt(i);
            if (ch == '+' || ch == '-'){
                res += num * operator;
                num = 0;
                operator = (ch == '+') ? 1 : -1;
            } else if (ch == '('){
                stack.push(res);
                stack.push(operator);
                res = 0; operator = 1; num = 0;
            } else if (ch == ')'){
                res = (res + (num * operator)) * stack.pop() + stack.pop();
                num = 0;
            } else if (ch != ' '){
                num = num * 10 - '0' + ch;
            }
        }
        res += num * operator;
        return res;
    }

}
