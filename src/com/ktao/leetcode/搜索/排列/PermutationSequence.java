package com.ktao.leetcode.搜索.排列;

import java.util.ArrayList;
import java.util.List;

/**
 * 60. 第k个排列
 * @author kongtao
 * @version 1.0
 * @description:
 * @date 2020/5/24
 **/
public class PermutationSequence {
    /**
     * 给出集合 [1,2,3,…,n]，其所有元素共有 n! 种排列。
     *
     * 按大小顺序列出所有排列情况，并一一标记，当 n = 3 时, 所有排列如下：
     *
     * "123"
     * "132"
     * "213"
     * "231"
     * "312"
     * "321"
     * 给定 n 和 k，返回第 k 个排列。
     *
     * 说明：
     *
     * 给定 n 的范围是 [1, 9]。
     * 给定 k 的范围是[1,  n!]。
     * 示例 1:
     *
     * 输入: n = 3, k = 3
     * 输出: "213"
     * 示例 2:
     *
     * 输入: n = 4, k = 9
     * 输出: "2314"
     */
    public String getPermutation(int n, int k) {
        List<String> numbers = new ArrayList<>();
        for (int i = 1; i <= n; i++) numbers.add(String.valueOf(i));
        int[] fac = new int[n + 1];
        fac[0] = 1; fac[1] = 1;
        for (int i = 2; i <= n; i++) fac[i] = fac[i - 1] * i;
        StringBuilder sb = new StringBuilder();
        while (n > 0){
            int c = (k - 1) / fac[n - 1];
            sb.append(numbers.get(c));
            numbers.remove(c);
            k = k - c * fac[n - 1];
            n--;
        }
        return sb.toString();
    }
}
