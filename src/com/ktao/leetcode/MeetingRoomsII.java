package com.ktao.leetcode;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * @author kongtao
 * @version 1.0
 * @description: 253.会议室 II
 * @date 2020/4/14
 * 类似题：{@link MeetingRooms}
 **/
public class MeetingRoomsII {
    /**
     * 给定一个会议时间安排的数组，每个会议时间都会包括开始和结束的时间 [[s1,e1],[s2,e2],...] (si < ei)，为避免会议冲突，同时要考虑充分利用会议室资源，请你计算至少需要多少间会议室，才能满足这些会议安排。
     *
     * 示例 1:
     *
     * 输入: [[0, 30],[5, 10],[15, 20]]
     * 输出: 2
     * 示例 2:
     *
     * 输入: [[7,10],[2,4]]
     * 输出: 1
     */
    public int minMeetingRooms(int[][] intervals) {
        if (intervals == null || intervals.length == 0) return 0;
        // 按结束时间排序
        PriorityQueue<Integer> queue = new PriorityQueue<>();
        // 按开始时间排序
        Arrays.sort(intervals, Comparator.comparingInt(i -> i[0]));
        queue.add(intervals[0][1]);
        for (int i = 1; i < intervals.length; i++){
            Integer last = queue.peek(); //最早结束的
            if (last <= intervals[i][0]){ // 最早结束的可以腾出会议室
                queue.poll();
                queue.add(intervals[i][1]); //修改该会议室的结束时间
            } else { //最早结束的都来不及腾出会议室
                queue.add(intervals[i][1]); //需要一个新的会议室
            }
        }
        return queue.size();
    }

    public static void main(String[] args) {

    }
}
