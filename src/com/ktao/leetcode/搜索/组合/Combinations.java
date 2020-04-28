package com.ktao.leetcode.搜索.组合;

import java.util.ArrayList;
import java.util.List;

/**
 * 77. 组合
 * @version 1.0
 * @author: kongtao
 * @description:
 * @date: 2020/4/25 5:49 下午
 */
public class Combinations {
    /**
     * 给定两个整数 n 和 k，返回 1 ... n 中所有可能的 k 个数的组合。
     *
     * 示例:
     *
     * 输入: n = 4, k = 2
     * 输出:
     * [
     *   [2,4],
     *   [3,4],
     *   [2,3],
     *   [1,2],
     *   [1,3],
     *   [1,4],
     * ]
     */
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> res = new ArrayList<>();
        helper(res, new ArrayList<>(), 1, n, k);
        return res;
    }

    private void helper(List<List<Integer>> res, List<Integer> list, int start, int n , int k){
        if (list.size() == k){
            res.add(new ArrayList<>(list));
            return;
        }
        for (int i = start; i <= n; i++){
            list.add(i);
            helper(res, list, i+1, n, k);
            list.remove(list.size() - 1);
        }
    }
}
