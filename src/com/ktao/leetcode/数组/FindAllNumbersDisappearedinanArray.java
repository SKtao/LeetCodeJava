package com.ktao.leetcode.数组;

import java.util.ArrayList;
import java.util.List;

/**
 * 448. 找到所有数组中消失的数字
 * @author kongtao
 * @version 1.0
 * @description:
 * @date 2020/4/28
 **/
public class FindAllNumbersDisappearedinanArray {
    /**
     * 给定一个范围在  1 ≤ a[i] ≤ n ( n = 数组大小 ) 的 整型数组，数组中的元素一些出现了两次，另一些只出现一次。
     *
     * 找到所有在 [1, n] 范围之间没有出现在数组中的数字。
     *
     * 您能在不使用额外空间且时间复杂度为O(n)的情况下完成这个任务吗? 你可以假定返回的数组不算在额外空间内。
     *
     * 示例:
     *
     * 输入:
     * [4,3,2,7,8,2,3,1]
     *
     * 输出:
     * [5,6]
     *
     *
     * 题目要求不能开辟额外空间，所以我们利用数组的下标，用数组本身来进行标记。既然给定的数组长度为n，数组中元素nums[i]都是介于1-n之间的，
     * 我们可以利用下标为nums[i]处的元素的正负性，来标记nums[i]是否出现过。
     * 1. 遍历整个数组，对于nums[i]，如果nums[abs(nums[i])-1]为正，就将nums[abs(nums[i])-1]置为负，说明nums[i]出现过了。
     *    之所以加绝对值号，是因为nums[i]可能是负的，已经标记过其他的数。
     * 2. 遍历整个数组，nums[i]为正数，i+1就是缺失元素。
     */
    public List<Integer> findDisappearedNumbers(int[] nums) {
        List<Integer> res = new ArrayList<>();
        for (int num : nums){
            int index = Math.abs(num) - 1;
            if (nums[index] < 0) continue;
            nums[index] = -1 * nums[index];
        }
        for (int i = 0; i < nums.length; i++){
            if (nums[i] <= 0) continue;
            res.add(i+1);
        }
        return res;
    }
}
