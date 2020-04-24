package com.ktao.leetcode;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @author kongtao
 * @version 1.0
 * @description:
 * @date 2020/4/14
 **/
public class NonOverlappingIntervals {
    /**
     * 给定一个区间的集合，找到需要移除区间的最小数量，使剩余区间互不重叠。
     *
     * 注意:
     *
     * 可以认为区间的终点总是大于它的起点。
     * 区间 [1,2] 和 [2,3] 的边界相互“接触”，但没有相互重叠。
     * 示例 1:
     * 输入: [ [1,2], [2,3], [3,4], [1,3] ]
     *
     * 输出: 1
     *
     * 解释: 移除 [1,3] 后，剩下的区间没有重叠。
     * 示例 2:
     * 输入: [ [1,2], [1,2], [1,2] ]
     *
     * 输出: 2
     *
     * 解释: 你需要移除两个 [1,2] 来使剩下的区间没有重叠。
     * 示例 3:
     * 输入: [ [1,2], [2,3] ]
     *
     * 输出: 0
     */
    public int eraseOverlapIntervals(int[][] intervals) {
        if (intervals.length == 0) return 0;
        // 按 end 升序排序
        Arrays.sort(intervals, Comparator.comparingInt(a -> a[1]));
        // 至少有一个区间不相交
        int count = 1;
        // 排序后，第一个区间就是 x
        int end = intervals[0][1];
        for (int[] interval : intervals) {
            int start = interval[0];
            if (start >= end) {
                // 找到下一个选择的区间了
                count++;
                end = interval[1];
            }
        }
        return intervals.length - count;
    }

    public static void main(String[] args) {
        NonOverlappingIntervals solution = new NonOverlappingIntervals();
        int[][] intervals = {{1,2}, {2,3}, {4,6}};
        System.out.println(solution.eraseOverlapIntervals(intervals));
    }
}
