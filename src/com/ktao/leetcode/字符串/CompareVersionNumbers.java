package com.ktao.leetcode.字符串;

/**
 * 165. 比较版本号
 * @author kongtao
 * @version 1.0
 * @description:
 * @date 2020/5/19
 **/
public class CompareVersionNumbers {
    /**
     * 比较两个版本号 version1 和 version2。
     * 如果 version1 > version2 返回 1，如果 version1 < version2 返回 -1， 除此之外返回 0。
     *
     * 你可以假设版本字符串非空，并且只包含数字和 . 字符。
     *
     *  . 字符不代表小数点，而是用于分隔数字序列。
     *
     * 例如，2.5 不是“两个半”，也不是“差一半到三”，而是第二版中的第五个小版本。
     *
     * 你可以假设版本号的每一级的默认修订版号为 0。例如，版本号 3.4 的第一级（大版本）和第二级（小版本）修订号分别为 3 和 4。其第三级和第四级修订号均为 0。
     *  
     *
     * 示例 1:
     *
     * 输入: version1 = "0.1", version2 = "1.1"
     * 输出: -1
     * 示例 2:
     *
     * 输入: version1 = "1.0.1", version2 = "1"
     * 输出: 1
     * 示例 3:
     *
     * 输入: version1 = "7.5.2.4", version2 = "7.5.3"
     * 输出: -1
     * 示例 4：
     *
     * 输入：version1 = "1.01", version2 = "1.001"
     * 输出：0
     * 解释：忽略前导零，“01” 和 “001” 表示相同的数字 “1”。
     */
    public int compareVersion(String version1, String version2) {
        int p1 = 0, p2 = 0;
        int maxLen = Math.max(version1.length(), version2.length());
        while (p1 < maxLen || p2 < maxLen){
            int v1 = 0, v2 = 0;
            while (p1 < version1.length() && version1.charAt(p1) != '.'){
                v1 = v1 * 10 + version1.charAt(p1) - '0';
                p1++;
            }
            while (p2 < version2.length() && version2.charAt(p2) != '.'){
                v2 = v2 * 10 + version2.charAt(p2)  - '0';
                p2++;
            }
            if (v1 > v2) return 1;
            else if (v1 < v2) return -1;
            p1++;
            p2++;
        }
        return 0;
    }
}
