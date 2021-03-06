package com.ktao.leetcode.字符串;

/**
 * @author kongtao
 * @version 1.0
 * @description:
 * @date 2020/5/24
 **/
public class ValidNumber {
    /**
     * 验证给定的字符串是否可以解释为十进制数字。
     *
     * 例如:
     *
     * "0" => true
     * " 0.1 " => true
     * "abc" => false
     * "1 a" => false
     * "2e10" => true
     * " -90e3   " => true
     * " 1e" => false
     * "e3" => false
     * " 6e-1" => true
     * " 99e2.5 " => false
     * "53.5e93" => true
     * " --6 " => false
     * "-+3" => false
     * "95a54e53" => false
     *
     * 说明: 我们有意将问题陈述地比较模糊。在实现代码之前，你应当事先思考所有可能的情况。这里给出一份可能存在于有效十进制数字中的字符列表：
     *
     * 数字 0-9
     * 指数 - "e"
     * 正/负号 - "+"/"-"
     * 小数点 - "."
     */
    public boolean isNumber(String s) {
        if (s == null || s.length() == 0) return false;
        int i = 0;
        int n = s.length();
        // 过滤头部空字符
        while (i < n && Character.isWhitespace(s.charAt(i))) i++;
        if (i < n && (s.charAt(i) == '+' || s.charAt(i) == '-')) i++;
        boolean isDigits = false;
        // 过滤数字部分
        while (i < n && Character.isDigit(s.charAt(i))){
            i++;
            isDigits = true;
        }
        // 若存在'.'
        if (i < n && s.charAt(i) == '.'){
            i++;
            // 过滤数字部分
            while(i < n && Character.isDigit(s.charAt(i))){
                isDigits = true;
                i++;
            }
        }
        // 若存在'e'
        if (i < n && s.charAt(i) == 'e' && isDigits){
            i++;
            isDigits = false;
            // 过滤e后的+、-
            if(i < n && (s.charAt(i) == '+' || s.charAt(i) == '-')) i++;
            // 过滤数字
            while (i < n && Character.isDigit(s.charAt(i))){
                i++;
                isDigits = true;
            }
        }
        // 过滤尾部空字符
        while (i < n && Character.isWhitespace(s.charAt(i))) i++;
        // isDigits为true，并且过滤到了字符串尾部，则表明数字有效
        return isDigits && (i == s.length());
    }
}
