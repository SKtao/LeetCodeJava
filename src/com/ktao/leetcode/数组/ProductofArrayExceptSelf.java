package com.ktao.leetcode.数组;

import java.util.Arrays;

/**
 * @author kongtao
 * @version 1.0
 * @description:
 * @date 2020/5/31
 **/
public class ProductofArrayExceptSelf {
    public int[] productExceptSelf(int[] nums) {
        int[] res = Arrays.copyOf(nums, nums.length);
        for (int i = 1; i < nums.length; i++){
            res[i] = nums[i] * res[i - 1];
        }
        int right = 1;
        for (int i = nums.length - 1; i >= 0; i--){
            res[i] = (i > 0) ? right * res[i - 1] : right;
            right *= nums[i];
        }
        return res;
    }
}
