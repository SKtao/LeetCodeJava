package com.ktao.leetcode.搜索.组合;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 90.子集II
 * @version 1.0
 * @author: kongtao
 * @description:
 * @date: 2020/4/25 6:04 下午
 */
public class SubsetsII {
    /**
     * 给定一个可能包含重复元素的整数数组 nums，返回该数组所有可能的子集（幂集）。
     *
     * 说明：解集不能包含重复的子集。
     *
     * 示例:
     *
     * 输入: [1,2,2]
     * 输出:
     * [
     *   [2],
     *   [1],
     *   [1,2,2],
     *   [2,2],
     *   [1,2],
     *   []
     * ]
     */
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList<>();
        res.add(new ArrayList<>());
        boolean[] visited = new boolean[nums.length];
        helper(res, new ArrayList<>(), nums, 0, visited);
        return res;
    }

    private void helper(List<List<Integer>> res, List<Integer> list, int[] nums, int start, boolean[] visited){
        for (int i = start; i < nums.length; i++){
            if (i >= 1 && nums[i] == nums[i-1] && !visited[i-1]) continue;
            list.add(nums[i]);
            visited[i] = true;
            res.add(new ArrayList<>(list));
            helper(res, list, nums, i+1, visited);
            list.remove(list.size()-1);
            visited[i] = false;
        }
    }
}
