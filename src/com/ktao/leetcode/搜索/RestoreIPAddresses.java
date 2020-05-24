package com.ktao.leetcode.搜索;

import java.util.ArrayList;
import java.util.List;

/**
 * 93. 复原IP地址
 * @author kongtao
 * @version 1.0
 * @description:
 * @date 2020/5/24
 **/
public class RestoreIPAddresses {
    /**
     * 给定一个只包含数字的字符串，复原它并返回所有可能的 IP 地址格式。
     *
     * 有效的 IP 地址正好由四个整数（每个整数位于 0 到 255 之间组成），整数之间用 '.' 分隔。
     * 示例:
     *
     * 输入: "25525511135"
     * 输出: ["255.255.11.135", "255.255.111.35"]
     */
    public List<String> restoreIpAddresses(String s) {
        List<String> res = new ArrayList<>();
        helper(res, s, 0, "", 0);
        return res;
    }

    private void helper(List<String> res, String ip, int idx, String cur, int count){
        if (count > 4) return;
        // 找到一个解
        if (count == 4 && idx == ip.length()){
            res.add(cur);
        }
        for (int i = 1; i < 4; i++){
            if (idx + i > ip.length()) return;
            String s = ip.substring(idx, idx + i);
            if (isIllegal(s, i)){
                return;
            }
            helper(res, ip, idx + i, cur + s + (count == 3 ? "" : "."), count + 1);
        }
    }
    // 是否非法
    private boolean isIllegal(String s, int i){
        if (s.startsWith("0") && s.length() > 1) return true;
        if (i == 3 && Integer.valueOf(s) >= 256) return true;
        return false;
    }
}
