package com.ktao.leetcode.数组;

import java.util.ArrayList;
import java.util.List;

/**
 * @author kongtao
 * @version 1.0
 * @description:
 * @date 2020/5/29
 **/
public class SummaryRanges {
    /**
     * 给定一个无重复元素的有序整数数组，返回数组区间范围的汇总。
     *
     * 示例 1:
     *
     * 输入: [0,1,2,4,5,7]
     * 输出: ["0->2","4->5","7"]
     * 解释: 0,1,2 可组成一个连续的区间; 4,5 可组成一个连续的区间。
     * 示例 2:
     *
     * 输入: [0,2,3,4,6,8,9]
     * 输出: ["0","2->4","6","8->9"]
     * 解释: 2,3,4 可组成一个连续的区间; 8,9 可组成一个连续的区间。
     */
    public List<String> summaryRanges(int[] nums) {
        if (nums == null || nums.length == 0) return new ArrayList<>();
        List<String> res = new ArrayList<>();
        for (int i = 0, j = 0; j < nums.length; j++){
            if (j < nums.length - 1 && nums[j + 1] == nums[j] + 1) continue;
            if (i == j) res.add(nums[i] + "");
            else res.add(nums[i] + "->" + nums[j]);
            i = j + 1;
        }
        return res;
    }
}
