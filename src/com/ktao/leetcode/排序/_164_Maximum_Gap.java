package com.ktao.leetcode.排序;

import java.util.Arrays;

/**
 * 164. Maximum Gap
 * @author kongtao
 * @version 1.0
 * @description:
 * @date 2020/6/13
 **/
public class _164_Maximum_Gap {
    /**
     * 给定一个无序的数组，找出数组在排序之后，相邻元素之间最大的差值。
     *
     * 如果数组元素个数小于 2，则返回 0。
     *
     * 示例 1:
     *
     * 输入: [3,6,9,1]
     * 输出: 3
     * 解释: 排序后的数组是 [1,3,6,9], 其中相邻元素 (3,6) 和 (6,9) 之间都存在最大差值 3。
     * 示例 2:
     *
     * 输入: [10]
     * 输出: 0
     * 解释: 数组元素个数小于 2，因此返回 0。
     * 说明:
     *
     * 你可以假设数组中所有元素都是非负整数，且数值在 32 位有符号整数范围内。
     * 请尝试在线性时间复杂度和空间复杂度的条件下解决此问题。
     */

    // 思路：
    // 遇到这类问题肯定先想到的是要给数组排序，但是题目要求是要线性的时间和空间，那么只能用桶排序或者基排序。
    // 这里用桶排序 Bucket Sort 来做，首先找出数组的最大值和最小值，然后要确定每个桶的容量，即为 (最大值 - 最小值) / 个数 + 1，
    // 在确定桶的个数，即为 (最大值 - 最小值) / 桶的容量 + 1，然后需要在每个桶中找出局部最大值和最小值，而最大间距的两个数不会在
    // 同一个桶中，而是一个桶的最小值和另一个桶的最大值之间的间距，这是因为所有的数字要尽量平均分配到每个桶中，而不是都拥挤在一个桶中，
    // 这样保证了最大值和最小值一定不会在同一个桶中

    // 桶排序  Time: O(N), Space: O(N)
    public int maximumGap(int[] nums) {
        if (nums.length <= 1) return 0;
        int max = Integer.MIN_VALUE, min = Integer.MAX_VALUE, N = nums.length;
        // 寻找最大值和最小值
        for (int num : nums) {
            max = Math.max(max, num);
            min = Math.min(min, num);
        }
        // 桶容量
        int size = (max - min) / N + 1;
        // 桶个数
        int count = (max - min) / size + 1;

        int[] minBucket = new int[count], maxBucket = new int[count];
        Arrays.fill(minBucket, Integer.MAX_VALUE);
        Arrays.fill(maxBucket, Integer.MIN_VALUE);

        for (int num : nums) {
            int idx = (num - min) / size;
            minBucket[idx] = Math.min(minBucket[idx], num);
            maxBucket[idx] = Math.max(maxBucket[idx], num);
        }
        int res = 0;
        int preIdx = 0;
        for (int i = 1; i < count; i++){
            if (minBucket[i] == Integer.MAX_VALUE || maxBucket[i] == Integer.MIN_VALUE) continue;
            res = Math.max(res, minBucket[i] - maxBucket[preIdx]);
            preIdx = i;
        }
        return res;
    }
}
