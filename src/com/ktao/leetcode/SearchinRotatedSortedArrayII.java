package com.ktao.leetcode;

/**
 * @author kongtao
 * @version 1.0
 * @description: 81.搜索旋转排序数组II
 * @date 2020/4/15
 **/
public class SearchinRotatedSortedArrayII {
    /**
     * 假设按照升序排序的数组在预先未知的某个点上进行了旋转。
     *
     * ( 例如，数组 [0,0,1,2,2,5,6] 可能变为 [2,5,6,0,0,1,2] )。
     *
     * 编写一个函数来判断给定的目标值是否存在于数组中。若存在返回 true，否则返回 false。
     *
     * 示例 1:
     *
     * 输入: nums = [2,5,6,0,0,1,2], target = 0
     * 输出: true
     * 示例 2:
     *
     * 输入: nums = [2,5,6,0,0,1,2], target = 3
     * 输出: false
     */
    public boolean search(int[] nums, int target) {
        int left = 0, right = nums.length - 1;
        while (left <= right){
            int mid = (left + right) / 2;
            if (nums[mid] == target){
                return true;
            }
            if (nums[left] == nums[mid]){
                left++;
                continue;
            }
            if (nums[left] < nums[mid]){
                if (nums[left] <= target && target < nums[mid]){
                    right = mid - 1;
                } else{
                    left = mid + 1;
                }
            }else{
                if (nums[mid] < target && target <= nums[right]){
                    left = mid + 1;
                } else{
                    right = mid - 1;
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int[] nums = {4,4,6,7,0,1,2};
        int target = 5;
        SearchinRotatedSortedArrayII solution = new SearchinRotatedSortedArrayII();
        System.out.println(solution.search(nums, target));
    }
}
