package com.ktao.leetcode;

import java.util.*;

/**
 * @author kongtao
 * @version 1.0
 * @description: LC 347.前K个高频元素
 * @date 2020/4/14
 **/
public class TopKFrequentElements {
    /**
     * 给定一个非空的整数数组，返回其中出现频率前 k 高的元素。
     *
     * 示例 1:
     *
     * 输入: nums = [1,1,1,2,2,3], k = 2
     * 输出: [1,2]
     * 示例 2:
     *
     * 输入: nums = [1], k = 1
     * 输出: [1]
     * 说明：
     *
     * 你可以假设给定的 k 总是合理的，且 1 ≤ k ≤ 数组中不相同的元素的个数。
     * 你的算法的时间复杂度必须优于 O(n log n) , n 是数组的大小。
     */
    // PriorityQueue: time: O(klogn) space : O(n)
    public List<Integer> topKFrequent1(int[] nums, int k) {
        Map<Integer,Integer> map = new HashMap<>();
        List<Integer> res = new ArrayList<>();
        for (int num : nums){
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        // 定义最大堆
        PriorityQueue<Map.Entry<Integer, Integer>> maxHeap =
                new PriorityQueue<>((a, b) -> b.getValue() - a.getValue());
        for (Map.Entry<Integer, Integer> entry : map.entrySet()){
            maxHeap.offer(entry);
        }
        while (--k >= 0){
            res.add(Objects.requireNonNull(maxHeap.poll()).getKey());
        }
        return res;
    }

    // TreeMap: time :O(klogn) space: O(n)
    public List<Integer> topKFrequent2(int[] nums, int k) {
        List<Integer> res = new ArrayList<>();
        Map<Integer, Integer> treeMap = new TreeMap<>((a, b) -> b - a);
        for (int num : nums){
            treeMap.put(num, treeMap.getOrDefault(num, 0) + 1);
        }
        for (Map.Entry<Integer, Integer> entry : treeMap.entrySet()){
            if (k <= 0) break;
            res.add(entry.getKey());
            k--;
        }
        return res;
    }

    // Bucket sort: time: O(n) space: O(n)
    public List<Integer> topKFrequent3(int[] nums, int k) {
        Map<Integer,Integer> map = new HashMap<>();
        List<Integer> res = new ArrayList<>();
        for (int num : nums){
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        //桶排序
        //将频率作为数组下标，对于出现频率不同的数字集合，存入对应的数组下标
        List<Integer>[] list = new List[nums.length + 1];
        for (int key : map.keySet()){
            // 获取出现的次数作为下标
            int value = map.get(key);
            if (list[value] == null){
                list[value] = new ArrayList<>();
            }
            list[value].add(key);
        }
        // 倒序遍历数组获取出现顺序从大到小的排列
        for (int i = list.length - 1; i >= 0 && res.size() < k; i--){
            if (list[i] == null) continue;
            res.addAll(list[i]);
        }
        return res;
    }

    public static void main(String[] args) {
        int[] nums = {1,1,1,2,2,3};
        int k = 3;

    }
}
