package com.ktao.leetcode.图;

import java.util.HashSet;
import java.util.Set;

/**
 * 128. 最长连续序列
 * @author kongtao
 * @version 1.0
 * @description:
 * @date 2020/5/26
 **/
public class LongestConsecutiveSequence {
    /**
     * 给定一个未排序的整数数组，找出最长连续序列的长度。
     *
     * 要求算法的时间复杂度为 O(n)。
     *
     * 示例:
     *
     * 输入: [100, 4, 200, 1, 3, 2]
     * 输出: 4
     * 解释: 最长连续序列是 [1, 2, 3, 4]。它的长度为 4。
     */
    public int longestConsecutive(int[] nums) {
        Set<Integer> numSet = new HashSet<>();
        for (int num : nums) numSet.add(num);
        int res = 0;
        for (int num : nums){
            if (!numSet.contains(num - 1)){
                int tmp = 1;
                while (numSet.contains(num + 1)){
                    tmp++;
                    num++;
                }
                res = Math.max(res, tmp);
            }
        }
        return res;
    }
}
