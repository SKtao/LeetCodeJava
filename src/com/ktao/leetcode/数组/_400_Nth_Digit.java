package com.ktao.leetcode.数组;

/**
 * @author kongtao
 * @version 1.0
 * @description:
 * @date 2020/6/10
 **/
public class _400_Nth_Digit {
    public static int findNthDigit(int n) {
        long digtis = 1, p = 9;

        while (n - digtis * p > 0){
            n -= digtis * p;
            digtis++;
            p *= 10;
        }

        long number = (int)Math.pow(10, digtis - 1) + (int)(n / digtis);
        int idx = n % (int)digtis;
        // 若idx为0，则表示在第digits位
        if (idx == 0) {
            number--;
            idx = (int)digtis;
        }
        for (int i = idx; i < digtis; i++) number /= 10;
        return (int)number % 10;
    }

    public static void main(String[] args) {
        System.out.println(findNthDigit(15));
    }
}
