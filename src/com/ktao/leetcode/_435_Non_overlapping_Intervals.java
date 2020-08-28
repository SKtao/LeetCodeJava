package com.ktao.leetcode;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @author kongtao
 * @version 1.0
 * @description:
 * @date 2020/7/16
 **/
public class _435_Non_overlapping_Intervals {

    public int eraseOverlapIntervals(int[][] intervals) {
        if (intervals == null || intervals.length == 0) return 0;
        int count = 0;
        Arrays.sort(intervals, Comparator.comparingInt(a -> a[0]));
        int end = intervals[0][1];
        for (int i = 0; i < intervals.length; i++) {
            if (intervals[i][0] < end) {
                continue;
            }
            end = intervals[i][1];
            count++;
        }
        return intervals.length - count;
    }
}
