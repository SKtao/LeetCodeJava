package com.ktao.leetcode.搜索.排列;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @version 1.0
 * @author: kongtao
 * @description:
 * @date: 2020/4/25 11:00 上午
 */
public class PermutationsII {
    /**
     * 给定一个可包含重复数字的序列，返回所有不重复的全排列。
     *
     * 示例:
     *
     * 输入: [1,1,2]
     * 输出:
     * [
     *   [1,1,2],
     *   [1,2,1],
     *   [2,1,1]
     * ]
     */
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        boolean[] visited = new boolean[nums.length];
        // 1.排序
        Arrays.sort(nums);
        helper(nums, new ArrayList<>(), res, visited);
        return res;
    }

    private void helper(int[] nums, List<Integer> list, List<List<Integer>> res, boolean[] visited) {
        if (list.size() == nums.length){
            res.add(new ArrayList<>(list));
            return;
        }
        for (int i = 0; i < nums.length; i++){
            if (visited[i]) continue;
            // 去重
            if (i >= 1 && nums[i] == nums[i-1] && !visited[i-1]) continue;;
            list.add(nums[i]);
            visited[i] = true;
            helper(nums, list, res, visited);
            list.remove(list.size()-1);
            visited[i] = false;
        }
    }
}
