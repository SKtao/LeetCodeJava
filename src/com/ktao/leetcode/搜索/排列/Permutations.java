package com.ktao.leetcode.搜索.排列;

import java.util.ArrayList;
import java.util.List;

/**
 * 46.全排列
 * @version 1.0
 * @author: kongtao
 * @description:
 * @date: 2020/4/25 10:40 上午
 */
public class Permutations {
    /**
     * 给定一个 没有重复 数字的序列，返回其所有可能的全排列。
     *
     * 示例:
     *
     * 输入: [1,2,3]
     * 输出:
     * [
     *   [1,2,3],
     *   [1,3,2],
     *   [2,1,3],
     *   [2,3,1],
     *   [3,1,2],
     *   [3,2,1]
     * ]
     */
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        boolean[] visited = new boolean[nums.length];
        helper(nums,  new ArrayList<>(), res, visited);
        return res;
    }

    private void helper(int[] nums, List<Integer> list, List<List<Integer>> res, boolean[] visited) {
        if (list.size() == nums.length){
            res.add(new ArrayList<>(list));
            return;
        }
        for (int i = 0; i < nums.length; i++){
            if (visited[i]) continue;
            list.add(nums[i]);
            visited[i] = true;
            helper(nums,  list, res, visited);
            list.remove(list.size()-1);
            visited[i] = false;
        }
    }

    public static void main(String[] args) {
        int[] nums = {1,2,3};
        Permutations solution = new Permutations();
        solution.permute(nums);
    }
}
