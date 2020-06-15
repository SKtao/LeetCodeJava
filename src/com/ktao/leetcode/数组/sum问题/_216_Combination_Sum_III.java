package com.ktao.leetcode.数组.sum问题;

import java.util.ArrayList;
import java.util.List;

/**
 * @author kongtao
 * @version 1.0
 * @description: LC: 216.组合总和 III
 * @date 2020/4/13
 **/
public class _216_Combination_Sum_III {
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
    public List<List<Integer>> combinationSum3(int k, int n){
        List<List<Integer>> res = new ArrayList<>();
        combine(res, new ArrayList<>(), 1,  k, n);
        return res;
    }

    private void combine(List<List<Integer>> res, List<Integer> list, int start, int k, int n) {
        // 找到一个解
        if (k == 0 && n == 0) {
            res.add(new ArrayList<>(list));
            return;
        }
        // 注意：每次遍历的起点递增，避免出现重复的序列
        for (int i = start; i <= 9; i++){
            list.add(i);
            // 递归
            combine(res, list, i+1, --k, n - i);
            // 回溯
            list.remove(list.size() - 1);
            k++;
        }
    }

    public static void main(String[] args) {
        _216_Combination_Sum_III sumIII = new _216_Combination_Sum_III();
        int k = 3;
        int n = 9;
        List<List<Integer>> res = sumIII.combinationSum3(k, n);
    }
}
