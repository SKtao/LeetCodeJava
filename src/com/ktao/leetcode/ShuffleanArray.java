package com.ktao.leetcode;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * 384.打乱数组
 * @author kongtao
 * @version 1.0
 * @description: 【Middle】
 * @date 2020/4/19
 **/
public class ShuffleanArray {
    /**
     *
     打乱一个没有重复元素的数组。

     示例:

     // 以数字集合 1, 2 和 3 初始化数组。
     int[] nums = {1,2,3};
     Solution solution = new Solution(nums);

     // 打乱数组 [1,2,3] 并返回结果。任何 [1,2,3]的排列返回的概率应该相同。
     solution.shuffle();

     // 重设数组到它的初始状态[1,2,3]。
     solution.reset();

     // 随机返回数组[1,2,3]打乱后的结果。
     solution.shuffle();
     */
    private int[] array;
    private int[] original;

    private Random rand = new Random();

    public ShuffleanArray(int[] nums) {
        array = nums;
        original = nums.clone();
    }

    /** Resets the array to its original configuration and return it. */
    public int[] reset() {
        array = original;
        original = original.clone();
        return array;
    }

    // 暴力法：O(n^2)
    public int[] shuffle1() {
        List<Integer> aux = getArrayCopy();
        for (int i = 0; i < array.length; i++){
            int removeIdx = rand.nextInt(aux.size());
            array[i] = aux.get(removeIdx);
            aux.remove(removeIdx);
        }
        return array;
    }

    private List<Integer> getArrayCopy() {
        List<Integer> asList = new ArrayList<Integer>();
        for (int i = 0; i < array.length; i++) {
            asList.add(array[i]);
        }
        return asList;
    }

    // Fisher-Yates 洗牌算法: O(n)
    public int[] shuffle2() {
        for (int i = 0; i < array.length; i++) {
            swapAt(i, randRange(i, array.length));
        }
        return array;
    }

    private int randRange(int min, int max) {
        return rand.nextInt(max - min) + min;
    }

    private void swapAt(int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }

    public static void main(String[] args) {

    }
}
