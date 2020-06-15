package com.ktao.leetcode.数组;

import java.util.*;

/**
 * @author kongtao
 * @version 1.0
 * @description:
 * @date 2020/6/11
 **/
public class _187_Repeated_DNA_Sequences {
    /**
     * 位运算：https://leetcode-cn.com/problems/repeated-dna-sequences/solution/xiang-xi-tong-su-de-si-lu-fen-xi-duo-jie-fa-by-4-7/
     */
    public List<String> findRepeatedDnaSequences(String s) {
        if (s == null || s.length() < 10) {
            return new ArrayList<>();
        }
        Map<Character, Integer> map = new HashMap<>();
        map.put('A', 0);
        map.put('C', 1);
        map.put('G', 2);
        map.put('T', 3);
        char[] array = s.toCharArray();
        int key = 0;
        Set<Integer> set = new HashSet<>();
        Set<String> res = new HashSet<>();
        for (int i = 0; i < 10; i++){
            key = key << 2 | map.get(array[i]);
        }
        set.add(key);
        for (int i = 10; i < array.length; i++){
            key = (key << 2 | map.get(array[i])) & 0xfffff;
            if (set.contains(key)) res.add(s.substring(i - 9, i + 1));
            else set.add(key);
        }
        return new ArrayList<>(res);
    }
}
