package com.ktao.leetcode;

import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedList;

/**
 * @author kongtao
 * @version 1.0
 * @description: 56.合并区间
 * @date 2020/4/14
 * 类似题：{@link MeetingRooms} {@link MeetingRoomsII}
 **/
public class MergeIntervals {
    /**
     * 给出一个区间的集合，请合并所有重叠的区间。
     *
     * 示例 1:
     *
     * 输入: [[1,3],[2,6],[8,10],[15,18]]
     * 输出: [[1,6],[8,10],[15,18]]
     * 解释: 区间 [1,3] 和 [2,6] 重叠, 将它们合并为 [1,6].
     * 示例 2:
     *
     * 输入: [[1,4],[4,5]]
     * 输出: [[1,5]]
     * 解释: 区间 [1,4] 和 [4,5] 可被视为重叠区间。
     */

    public int[][] merge(int[][] intervals) {
        if (null == intervals || intervals.length == 0) return intervals;
        // 按区间左边界进行排序
        Arrays.sort(intervals, Comparator.comparingInt(i -> i[0]));
        LinkedList<int[]> list = new LinkedList<>();
        list.add(intervals[0]);
        for (int i = 1; i < intervals.length; i++){
            int[] cur = intervals[i];
            // 当前区间的左边界 < 上一个区间的右边界(区间有重叠，进行合并)
            if (cur[0] <= list.getLast()[1]){
                // 合并后的右边界
                int end = Math.max(cur[1], list.getLast()[1]);
                // 合并后的左边界
                int start = list.getLast()[0];
                // 删除上一个区间(已与当前区间合并)
                list.removeLast();
                // 插入合并的新区间
                list.addLast(new int[]{start, end});
            } else {
                // 直接插入当前区间
                list.addLast(cur);
            }
        }
        return list.toArray(new int[0][2]);
    }

    public static void main(String[] args) {

    }
}
