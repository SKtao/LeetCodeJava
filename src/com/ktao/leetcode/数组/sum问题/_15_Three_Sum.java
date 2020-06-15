package com.ktao.leetcode.数组.sum问题;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 15.3Sum
 * @version 1.0
 * @author: kongtao
 * @description:
 * @date: 2020/4/24 7:20 下午
 */
public class _15_Three_Sum {
    /**
     * 给你一个包含 n 个整数的数组 nums，判断 nums 中是否存在三个元素 a，b，c ，使得 a + b + c = 0 ？请你找出所有满足条件且不重复的三元组。
     *
     * 注意：答案中不可以包含重复的三元组。
     *
     * 示例：
     *
     * 给定数组 nums = [-1, 0, 1, 2, -1, -4]，
     *
     * 满足要求的三元组集合为：
     * [
     *   [-1, 0, 1],
     *   [-1, -1, 2]
     * ]
     */
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        // 排序: n*log(n)
        Arrays.sort(nums);
        // 遍历：O(n^2)
        for (int i = 0; i < nums.length - 2; i++){
            // 去重
            if (i > 0 && nums[i] == nums[i-1]) continue;;
            int j = i + 1, k = nums.length - 1;
            while (j < k){
                int sum = nums[i] + nums[j] + nums[k];
                if (sum == 0){
                    res.add(Arrays.asList(nums[i], nums[j] , nums[k]));
                    j++;
                    k--;
                    // 去重
                    while (j < k && nums[j] == nums[j-1]) j++;
                    while (j < k && nums[k] == nums[k+1]) k--;
                } else if (sum < 0){
                    j++;
                } else {
                    k--;
                }
            }
        }
        return res;
    }
}
