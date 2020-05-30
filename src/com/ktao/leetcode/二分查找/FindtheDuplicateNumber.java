package com.ktao.leetcode.二分查找;

/**
 * 287. 寻找重复数
 * @author kongtao
 * @version 1.0
 * @description:
 * @date 2020/5/27
 **/
public class FindtheDuplicateNumber {
    /**
     * 给定一个包含 n + 1 个整数的数组 nums，其数字都在 1 到 n 之间（包括 1 和 n），可知至少存在一个重复的整数。假设只有一个重复的整数，找出这个重复的数。
     *
     * 示例 1:
     *
     * 输入: [1,3,4,2,2]
     * 输出: 2
     * 示例 2:
     *
     * 输入: [3,1,3,4,2]
     * 输出: 3
     * 说明：
     *
     * 不能更改原数组（假设数组是只读的）。
     * 只能使用额外的 O(1) 的空间。
     * 时间复杂度小于 O(n2) 。
     * 数组中只有一个重复的数字，但它可能不止重复出现一次。
     */

    /**
     * 二分查找
     * Time: O(nlog(n)), Space: O(1)
     * @param nums
     * @return
     */
    public int findDuplicate1(int[] nums) {
        int low = 1, high = nums.length - 1;
        while (low < high){
            int mid = (low +high) / 2;
            int count = 0;
            // 记录小于mid的元素个数
            for (int num : nums){
                if (num <= mid) count++;
            }
            // 重复元素已超过半数
            if (count > mid){
                high = mid;
            } else {
                low = mid + 1;
            }
        }
        return low;
    }

    /**
     * 快慢指针
     * Time: O(n), Space: O(1)
     * @param nums
     * @return
     */
    public int findDuplicate2(int[] nums) {
        int slow = nums[0];
        int fast = nums[nums[0]];
        while (slow != fast){
            slow = nums[slow];
            fast = nums[nums[fast]];
        }
        int p = 0;
        while (slow != p){
            slow = nums[slow];
            p = nums[p];
        }
        return slow;
    }
}
