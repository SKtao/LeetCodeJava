package com.ktao.leetcode.字符串;

import java.util.Stack;

/**
 * @author kongtao
 * @version 1.0
 * @description:
 * @date 2020/5/30
 **/
public class BasicCalculatorII {
    /**
     * 实现一个基本的计算器来计算一个简单的字符串表达式的值。
     *
     * 字符串表达式仅包含非负整数，+， - ，*，/ 四种运算符和空格  。 整数除法仅保留整数部分。
     *
     * 示例 1:
     *
     * 输入: "3+2*2"
     * 输出: 7
     * 示例 2:
     *
     * 输入: " 3/2 "
     * 输出: 1
     * 示例 3:
     *
     * 输入: " 3+5 / 2 "
     * 输出: 5
     * 说明：
     *
     * 你可以假设所给定的表达式都是有效的。
     * 请不要使用内置的库函数 eval。
     */
    public int calculate(String s) {
        // num: 保存当前数字，如：12是两个字符，需要进位累加
        int res = 0, num = 0;
        // 保存上一个符号，初始为 +
        char sign = '+';
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (Character.isDigit(c)) {
                // 记录当前数字。先减，防溢出
                num = num * 10 - '0' + c;
            }
            if ((!Character.isDigit(c) && c != ' ') || i == s.length() - 1 ) {
                // 判断上一个符号是什么
                switch (sign) {
                    // 当前符号前的数字直接压栈
                    case '+':
                        stack.push(num);
                        break;
                    // 当前符号前的数字取反压栈
                    case '-':
                        stack.push(-num);
                        break;
                    // 数字栈栈顶数字出栈，与当前符号前的数字相乘，结果值压栈
                    case '*':
                        stack.push(stack.pop() * num);
                        break;
                    // 数字栈栈顶数字出栈，除于当前符号前的数字，结果值压栈
                    case '/':
                        stack.push(stack.pop() / num);
                        break;
                }
                // 记录当前符号
                sign = c;
                // 数字清零
                num = 0;
            }
        }
        // 将栈内剩余数字累加，即为结果
        while (!stack.isEmpty()) {
            res += stack.pop();
        }
        return res;
    }
}
