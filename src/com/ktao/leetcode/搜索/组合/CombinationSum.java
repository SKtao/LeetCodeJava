package com.ktao.leetcode.搜索.组合;

import java.util.ArrayList;
import java.util.List;

/**
 * 39. 组合总和
 * @version 1.0
 * @author: kongtao
 * @description:
 * @date: 2020/4/25 4:01 下午
 */
public class CombinationSum {
    /**
     * 给定一个无重复元素的数组 candidates 和一个目标数 target ，找出 candidates 中所有可以使数字和为 target 的组合。
     *
     * candidates 中的数字可以无限制重复被选取。
     *
     * 说明：
     *
     * 所有数字（包括 target）都是正整数。
     * 解集不能包含重复的组合。 
     * 示例 1:
     *
     * 输入: candidates = [2,3,6,7], target = 7,
     * 所求解集为:
     * [
     *   [7],
     *   [2,2,3]
     * ]
     * 示例 2:
     *
     * 输入: candidates = [2,3,5], target = 8,
     * 所求解集为:
     * [
     *   [2,2,2,2],
     *   [2,3,3],
     *   [3,5]
     * ]
     */
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        helper(res, 0, new ArrayList<>(), candidates, target);
        return res;
    }

    private void helper(List<List<Integer>> res, int start, List<Integer> list, int[] candidates, int target){
        if (target < 0) return;
        if (target == 0){
            res.add(new ArrayList<>(list));
            return;
        }
        for (int i = start; i < candidates.length; i++){
            list.add(candidates[i]);
            helper(res, start ,list, candidates, target - candidates[i]);
            list.remove(list.size() - 1);
            // ！！！star+1
            start +=1;
        }
    }
}
