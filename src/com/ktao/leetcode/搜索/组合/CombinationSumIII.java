package com.ktao.leetcode.搜索.组合;

import java.util.ArrayList;
import java.util.List;

/**
 * 216. 组合总和 III
 * @version 1.0
 * @author: kongtao
 * @description:
 * @date: 2020/4/25 4:16 下午
 */
public class CombinationSumIII {

    /**
     * 找出所有相加之和为 n 的 k 个数的组合。组合中只允许含有 1 - 9 的正整数，并且每种组合中不存在重复的数字。
     *
     * 说明：
     *
     * 所有数字都是正整数。
     * 解集不能包含重复的组合。 
     * 示例 1:
     *
     * 输入: k = 3, n = 7
     * 输出: [[1,2,4]]
     * 示例 2:
     *
     * 输入: k = 3, n = 9
     * 输出: [[1,2,6], [1,3,5], [2,3,4]]
     */
    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> res = new ArrayList<>();
        helper(res, new ArrayList<>(), 1, k, n);
        return res;
    }

    private void helper(List<List<Integer>> res, List<Integer> list, int start, int k, int n){
        if (list.size() == k && n == 0){
            res.add(new ArrayList<>(list));
            return;
        }
        if (list.size() >= k) return;
        for (int i = start; i <= 9; i++){
            list.add(i);
            helper(res, list, i+1, k, n - i);
            list.remove(list.size()-1);
        }
    }
}
