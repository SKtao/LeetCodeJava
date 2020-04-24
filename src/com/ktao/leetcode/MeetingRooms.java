package com.ktao.leetcode;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @author kongtao
 * @version 1.0
 * @description: 252. 会议室
 * @date 2020/4/14
 * 类似题：{@link MeetingRoomsII}
 **/
public class MeetingRooms {
    /**
     * 给定一个会议时间安排的数组，每个会议时间都会包括开始和结束的时间 [[s1,e1],[s2,e2],...] (si < ei)，请你判断一个人是否能够参加这里面的全部会议。
     * <p>
     * 示例 1:
     * <p>
     * 输入: [[0,30],[5,10],[15,20]]
     * 输出: false
     * 示例 2:
     * <p>
     * 输入: [[7,10],[2,4]]
     * 输出: true
     */
    public boolean canAttendMeetings(int[][] intervals) {
        if (intervals == null || intervals.length == 0) return true;
        // 按开始时间排序
        Arrays.sort(intervals, Comparator.comparingInt(i -> i[0]));
        int end = intervals[0][1];
        for (int i = 1; i < intervals.length; i++){
            int start = intervals[i][0];
            // 若下一个会议开始时间 < 上一个会议的结束时间，则返回false
            if (start < end) return false;
            // 更新上一个会议的结束时间
            end = intervals[i][1];
        }
        return true;
    }

    public static void main(String[] args) {

    }
}
