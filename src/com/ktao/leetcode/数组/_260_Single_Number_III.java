package com.ktao.leetcode.数组;

/**
 * @author kongtao
 * @version 1.0
 * @description:
 * @date 2020/6/14
 **/
public class _260_Single_Number_III {

    /**
     * 位运算
     * 0 ⊕ a = a
     * a ⊕ a = 0
     */
    public static int[] singleNumber(int[] nums) {
        // eg. 1 2 3 2 1 5
        int XOR = 0;
        // 得到 3 ^ 5
        for (int num : nums) {
            XOR ^= num;
        }
        // 对Xor后的值取反加1并按位与，找出最右侧的1（010）
        int Diff = XOR & (~XOR + 1);
        // 依据Diff对数据分组
        int[] res = new int[2];
        for (int num : nums) {
            if ((num & Diff) == 0) {
                res[0] ^= num;
            } else {
                res[1] ^= num;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[] nums = {1, 3, 1, 2, 2, 5};
        System.out.println(singleNumber(nums));
    }
}
