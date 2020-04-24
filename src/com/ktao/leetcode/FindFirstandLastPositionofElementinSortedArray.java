package com.ktao.leetcode;

/**
 * @author kongtao
 * @version 1.0
 * @description:
 * @date 2020/4/15
 **/
public class FindFirstandLastPositionofElementinSortedArray {
    /**
     * 给定一个按照升序排列的整数数组 nums，和一个目标值 target。找出给定目标值在数组中的开始位置和结束位置。
     *
     * 你的算法时间复杂度必须是 O(log n) 级别。
     *
     * 如果数组中不存在目标值，返回 [-1, -1]。
     *
     * 示例 1:
     *
     * 输入: nums = [5,7,7,8,8,10], target = 8
     * 输出: [3,4]
     * 示例 2:
     *
     * 输入: nums = [5,7,7,8,8,10], target = 6
     * 输出: [-1,-1]
     */
    public int[] searchRange(int[] nums, int target) {
        int[] pos = {-1, -1};
        if (nums == null || nums.length == 0) return pos;
        int left = 0, right = nums.length - 1;
        while (left <= right){
            int mid = left + (right - left) / 2;
            if (nums[mid] == target){
                pos[0] = mid;
                pos[1] = mid;
                while (pos[0] >= 1 && nums[pos[0] - 1] == target) {
                    pos[0]--;
                }
                while (pos[1] < nums.length - 1&& nums[pos[1]+1] == target){
                    pos[1]++;
                }
                return pos;
            } else  if (nums[mid] < target){
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return pos;
    }

    public static void main(String[] args) {
        int[] nums = {5,7,7,8,8,10};
        int target = 9;
        FindFirstandLastPositionofElementinSortedArray solution = new FindFirstandLastPositionofElementinSortedArray();
        int[] res = solution.searchRange(nums,target);
        System.out.println(res[0] + "," + res[1]);
    }
}
