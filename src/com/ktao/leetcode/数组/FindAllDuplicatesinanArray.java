package com.ktao.leetcode.数组;

import java.util.ArrayList;
import java.util.List;

/**
 * 442. 数组中重复的数据
 * @author kongtao
 * @version 1.0
 * @description:
 * @date 2020/4/28
 **/
public class FindAllDuplicatesinanArray {
    /**
     * 给定一个整数数组 a，其中1 ≤ a[i] ≤ n （n为数组长度）, 其中有些元素出现两次而其他元素出现一次。
     *
     * 找到所有出现两次的元素。
     *
     * 你可以不用到任何额外空间并在O(n)时间复杂度内解决这个问题吗？
     *
     * 示例：
     *
     * 输入:
     * [4,3,2,7,8,2,3,1]
     *
     * 输出:
     * [2,3]
     */

    // [4,3,2,7,8,2,3,1] => [4,3,2,-7,8,2,3,1] => [4,3,-2,-7,8,2,3,1] => [4,-3,-2,-7,8,2,3,1]
    // => [4,-3,-2,-7,8,2,3,-1] => [4,3,-2,-7,8,2,3,-1] => [4,3,2,-7,8,2,3,-1] => [-4,3,2,-7,8,2,3,-1]
    // 遍历过程中，2和3这俩元素被操作了两次，因此这两个数为重复出现两次的结果
    public static List<Integer> findDuplicates(int[] nums) {
        List<Integer> res = new ArrayList<>();
        for (int num : nums){
            int index = Math.abs(num) - 1;
            if (nums[index] < 0){
                res.add(index + 1);
                continue;
            }
            nums[index] = -nums[index];
        }
        return res;
    }

    public static void main(String[] args) {
        int[] nums = {4,3,2,7,8,2,3,1};
        List<Integer> res = findDuplicates(nums);
        res.forEach(System.out::println);
    }
}
