package com.ktao.leetcode.搜索;

import java.util.*;

/**
 * @author kongtao
 * @version 1.0
 * @description:
 * @date 2020/5/18
 **/
public class WordBreakII {

    public List<String> wordBreak(String s, List<String> wordDict) {
        List<String> res;
        Set<String> set = new HashSet<>(wordDict);
        Map<String, List<String>> used = new HashMap<>();
        res = helper(s, set, used);
        return res;
    }

    private List<String> helper(String s, Set<String> set, Map<String, List<String>> used) {
        if (used.containsKey(s)) return used.get(s);
        if (s.isEmpty()) return null;
        List<String> res = new ArrayList<>();
        for (int i = 1; i <= s.length(); i++){
            String str = s.substring(0, i);
            if (set.contains(str)){
                List<String> partRes = helper(s.substring(i), set, used);
                if (null == partRes) res.add(str);
                else {
                    for (String partS : partRes){
                        res.add(str + " " + partS);
                    }
                }
            }
        }
        used.put(s, res);
        return res;
    }
}
