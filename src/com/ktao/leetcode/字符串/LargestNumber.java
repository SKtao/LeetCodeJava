package com.ktao.leetcode.字符串;

import java.util.Arrays;
import java.util.Comparator;

/**
 * 179. 最大数
 * @author kongtao
 * @version 1.0
 * @description:
 * @date 2020/5/19
 **/
public class LargestNumber {
    /**
     * 给定一组非负整数，重新排列它们的顺序使之组成一个最大的整数。
     *
     * 示例 1:
     *
     * 输入: [10,2]
     * 输出: 210
     * 示例 2:
     *
     * 输入: [3,30,34,5,9]
     * 输出: 9534330
     * 说明: 输出结果可能非常大，所以你需要返回一个字符串而不是整数。
     */
    public String largestNumber(int[] nums) {
        if (nums == null || nums.length == 0){
            return "";
        }
        String[] numStrs = new String[nums.length];
        for (int i = 0; i < nums.length; i++){
            numStrs[i] = String.valueOf(nums[i]);
        }
        Comparator<String> cmp = new Comparator<String>(){
            @Override
            public int compare(String str1, String str2){
                String s1 = str1 + str2;
                String s2 = str2 + str1;
                return s2.compareTo(s1);
            }
        };
        Arrays.sort(numStrs, cmp);
        if (numStrs[0].equals("0")) return "0";
        StringBuilder sb = new StringBuilder();
        for (String str : numStrs){
            sb.append(str);
        }
        return sb.toString();
    }
}
