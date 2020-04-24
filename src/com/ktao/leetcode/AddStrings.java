package com.ktao.leetcode;

/**
 * @author kongtao
 * @version 1.0
 * @description: 415.字符串相加
 * @date 2020/4/16
 **/
public class AddStrings {
    /**
     * 给定两个字符串形式的非负整数 num1 和num2 ，计算它们的和。
     *
     * 注意：
     *
     * num1 和num2 的长度都小于 5100.
     * num1 和num2 都只包含数字 0-9.
     * num1 和num2 都不包含任何前导零。
     * 你不能使用任何內建 BigInteger 库， 也不能直接将输入的字符串转换为整数形式。
     */
    public String addStrings(String num1, String num2) {
        StringBuilder res = new StringBuilder();
        int i = num1.length() - 1, j = num2.length() - 1, carry = 0;
        while (i >= 0 || j >= 0){
            int a = (i >= 0) ? num1.charAt(i) - '0' : 0;
            int b = (j >= 0) ? num2.charAt(j) - '0' : 0;
            int sum = a + b + carry;
            carry = sum / 10;
            res.append(sum % 10);
            i--;
            j--;
        }
        if (carry == 1) res.append(carry);
        return res.reverse().toString();
    }

    public static void main(String[] args) {
        String num1 = "5", num2 = "0";
        AddStrings solution = new AddStrings();
        System.out.println(solution.addStrings(num1, num2));
    }
}
