package com.ktao.leetcode;

/**
 * @author kongtao
 * @version 1.0
 * @description:
 * @date 2020/7/13
 **/
public class _388_Longest_Absolute_File_Path {

    public static int lengthLongestPath(String input) {
        if (input.length() == 0) {
            return 0;
        }
        int res = 0;
        int[] sum = new int[input.length() + 1];

        for (String s : input.split("\n")) {
            int level = s.lastIndexOf("\t") + 2;
            int len = s.length() - (level - 1);
            if (s.contains(".")) {
                res = Math.max(res, sum[level - 1] + len);
            } else {
                sum[level] = sum[level - 1] + len + 1;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        String str = "dir\n\tsubdir1\n\t\tfile1.ext\n\t\tsubsubdir1\n\tsubdir2";
        System.out.println(lengthLongestPath(str));
    }
}
