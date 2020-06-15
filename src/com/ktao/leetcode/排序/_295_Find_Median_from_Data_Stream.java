package com.ktao.leetcode.排序;

import java.util.ArrayList;
import java.util.List;

/**
 * @author kongtao
 * @version 1.0
 * @description:
 * @date 2020/6/14
 **/
public class _295_Find_Median_from_Data_Stream {
    class MedianFinder {
        private List<Integer> datas;
        /** initialize your data structure here. */
        public MedianFinder() {
            datas = new ArrayList<>();
        }

        public void addNum(int num) {
            if (datas.isEmpty()) {
                datas.add(num);
                return;
            }
            int i = 0;
            while (i < datas.size() && datas.get(i) < num) i++;
            datas.add(i, num);
        }

        public double findMedian() {
            if (datas.isEmpty()) return 0;
            int mid = datas.size() / 2;
            if (datas.size() % 2 == 1) return datas.get(mid);
            return (datas.get(mid) + datas.get(mid - 1)) / 2.00;
        }
    }
}
