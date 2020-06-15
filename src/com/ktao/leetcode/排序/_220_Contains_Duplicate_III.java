package com.ktao.leetcode.排序;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @author kongtao
 * @version 1.0
 * @description:
 * @date 2020/6/13
 **/
public class _220_Contains_Duplicate_III {

    // Get the ID of the bucket from element value x and bucket width w
    // In Java, `-3 / 5 = 0` and but we need `-3 / 5 = -1`.
    private static long getID(long x, long w) {
        return x < 0 ? (x + 1) / w - 1 : x / w;
    }
    // 桶排序
    public static boolean containsNearbyAlmostDuplicate1(int[] nums, int k, int t) {
        if (t < 0) return false;
        // Map定义桶
        Map<Long, Long> d = new HashMap<>();
        // w：桶容量 = t + 1
        long w = (long)t + 1;
        for (int i = 0; i < nums.length; ++i) {
            // 分配的桶id
            long m = getID(nums[i], w);
            // check if bucket m is empty, each bucket may contain at most one element
            // 若分配到的桶已存在该元素，则肯定符合要求
            if (d.containsKey(m))
                return true;
            // 校验前后相邻桶是否存在符合要求的元素： [x-t, x+t] ~ [x−t,x+t]
            if (d.containsKey(m - 1) && Math.abs(nums[i] - d.get(m - 1)) < w)
                return true;
            if (d.containsKey(m + 1) && Math.abs(nums[i] - d.get(m + 1)) < w)
                return true;
            // 该元素入桶
            d.put(m, (long)nums[i]);
            // i >= k：移动窗口，需要将i - k的元素从桶中移除
            if (i >= k) d.remove(getID(nums[i - k], w));
        }
        return false;
    }

    public static void main(String[] args) {
        int[] nums = {-1,2147483647};
        int k = 1, t = 2147483647;
        System.out.println(containsNearbyAlmostDuplicate1(nums, k, t));
    }
}
