package com.ktao.leetcode.搜索;

import java.util.ArrayList;
import java.util.List;

/**
 * 17. 电话号码的字母组合
 * @version 1.0
 * @author: kongtao
 * @description:
 * @date: 2020/4/27 8:56 上午
 */
public class LetterCombinationsofaPhoneNumber {
    /**
     * 给定一个仅包含数字 2-9 的字符串，返回所有它能表示的字母组合。
     *
     * 给出数字到字母的映射如下（与电话按键相同）。注意 1 不对应任何字母。
     *
     * https://img-blog.csdn.net/20180412170108590?watermark/2/text/aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L1NjYXJsZXR0X0d1YW4=/font/5a6L5L2T/fontsize/400/fill/I0JBQkFCMA==/dissolve/70

     * 示例:
     *
     * 输入："23"
     * 输出：["ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"].
     */
    public List<String> letterCombinations(String digits) {
        List<String> res = new ArrayList<>();
        if (null == digits || digits.length() == 0) return res;
        String[] numMap = {"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
        helper(res, digits, "", numMap);
        return res;
    }

    private void helper(List<String> res, String digits, String cur, String[] numMap){
        if (cur.length() == digits.length()){
            res.add(cur);
            return;
        }
        for (char c : numMap[digits.charAt(cur.length()) - '0'].toCharArray()){
            helper(res, digits, cur + c, numMap);
        }
    }
}
