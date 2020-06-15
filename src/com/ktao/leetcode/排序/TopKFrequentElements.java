package com.ktao.leetcode.排序;

import java.util.*;

/**
 * 347.前 K 个高频元素
 * @author kongtao
 * @version 1.0
 * @description:
 * @date 2020/6/6
 **/
public class TopKFrequentElements {

    // 堆：Time: O(nlog(k)), Space: O(n)
    public List<Integer> topKFrequentMinHeap(int[] nums, int k){
        Map<Integer, Integer> freqMap = new HashMap<>();
        for (int num : nums) {
            freqMap.put(num, freqMap.getOrDefault(num, 0) + 1);
        }
        Queue<Map.Entry<Integer, Integer>> pq = new PriorityQueue<>((a, b) -> a.getValue() - b.getValue().intValue());
        for (Map.Entry<Integer, Integer> e : freqMap.entrySet()){
            pq.add(e);
            if (pq.size() > k) pq.poll();
        }
        List<Integer> result = new ArrayList<>();
        for (Map.Entry<Integer, Integer> e : pq) result.add(e.getKey());
        return result;
    }

    // 快速排序：Time(avg): O(nlogn), Time(worst): O(n^2), Space: O(n)
    public List<Integer> topKFrequentQuickSort(int[] nums, int k) {
        Map<Integer, Integer> freqMap = new HashMap<>();
        for (int num : nums) {
            freqMap.put(num, freqMap.getOrDefault(num, 0) + 1);
        }
        List<Map.Entry<Integer, Integer>> entries = new ArrayList<>(freqMap.entrySet());
        int low = 0, high = entries.size() - 1;
        while (low <= high){
            int p = partition(entries, low, high);
            if (p == k - 1) break;
            else if (p > k - 1) high = p - 1;
            else low = p + 1;
        }
        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < k; i++){
            result.add(entries.get(i).getKey());
        }
        return result;
    }

    private int partition(List<Map.Entry<Integer, Integer>> entries, int low, int high){
        int pivot = entries.get(low).getValue();
        int i = low, j = high;
        while (i < j){
            while (i < j && entries.get(j).getValue() < pivot) j--;
            if (i < j) Collections.swap(entries, i, j);
            while (i < j && entries.get(i).getValue() >= pivot) i++;
            if (i < j) Collections.swap(entries, i, j);
        }
        return i;
    }

        // 桶排序：Time: O(n), Space: O(n)
    public List<Integer> topKFrequentBucketSort(int[] nums, int k) {
        Map<Integer, Integer> freqMap = new HashMap<>();
        for (int num : nums) {
            freqMap.put(num, freqMap.getOrDefault(num, 0) + 1);
        }
        List<List<Integer>> buckets = new ArrayList<>(nums.length + 1);
        for (int i = 0; i <= nums.length; i++) buckets.add(new ArrayList<>());
        for (Map.Entry<Integer, Integer> e : freqMap.entrySet()){
            buckets.get(e.getValue()).add(e.getKey());
        }
        List<Integer> result = new ArrayList<>();
        for (int i = buckets.size() - 1; i >= 0 && k > 0; i--) {
            List<Integer> bucket = buckets.get(i);
            for (int j = 0; j < bucket.size() && k > 0; j++){
                result.add(bucket.get(j));
                k--;
            }
        }
        return result;
//        return result.stream().mapToInt(Integer::valueOf).toArray();
    }
}
