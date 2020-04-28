package com.ktao.leetcode.搜索;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author kongtao
 * @version 1.0
 * @description:
 * @date 2020/4/28
 **/
public class JumpGameIII {
    /**
     * 这里有一个非负整数数组 arr，你最开始位于该数组的起始下标 start 处。当你位于下标 i 处时，你可以跳到 i + arr[i] 或者 i - arr[i]。
     *
     * 请你判断自己是否能够跳到对应元素值为 0 的 任意 下标处。
     *
     * 注意，不管是什么情况下，你都无法跳到数组之外。
     * 示例 1：
     *
     * 输入：arr = [4,2,3,0,3,1,2], start = 5
     * 输出：true
     * 解释：
     * 到达值为 0 的下标 3 有以下可能方案：
     * 下标 5 -> 下标 4 -> 下标 1 -> 下标 3
     * 下标 5 -> 下标 6 -> 下标 4 -> 下标 1 -> 下标 3
     * 示例 2：
     *
     * 输入：arr = [4,2,3,0,3,1,2], start = 0
     * 输出：true
     * 解释：
     * 到达值为 0 的下标 3 有以下可能方案：
     * 下标 0 -> 下标 4 -> 下标 1 -> 下标 3
     */
    // BFS+剪枝
    public static boolean canReach(int[] arr, int start) {
        int len = arr.length;
        Queue<Integer> queue = new LinkedList<>();
        queue.add(start);
        boolean[] visited = new boolean[len];
        while (!queue.isEmpty()){
            Integer curPos = queue.poll();
            visited[curPos] = true;
            if (arr[curPos] == 0) return true;
            int nextPos1 = curPos + arr[curPos];
            int nextPos2 = curPos - arr[curPos];
            if (nextPos1 < len && !visited[nextPos1]) {
                queue.offer(nextPos1);
            }
            if (nextPos2 >= 0 && !visited[nextPos2]){
                queue.offer(nextPos2);
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int[] arr = {3,0,2,1,2};
        canReach(arr, 2);
    }
}
