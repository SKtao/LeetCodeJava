package com.ktao.leetcode.搜索.记忆化搜索;

import java.util.HashMap;
import java.util.Map;

/**
 * 464. 我能赢吗
 * @version 1.0
 * @author: kongtao
 * @description:
 * @date: 2020/4/27 11:47 下午
 */
public class CanIWin {
    /**
     * 在 "100 game" 这个游戏中，两名玩家轮流选择从 1 到 10 的任意整数，累计整数和，先使得累计整数和达到 100 的玩家，即为胜者。
     *
     * 如果我们将游戏规则改为 “玩家不能重复使用整数” 呢？
     *
     * 例如，两个玩家可以轮流从公共整数池中抽取从 1 到 15 的整数（不放回），直到累计整数和 >= 100。
     *
     * 给定一个整数 maxChoosableInteger （整数池中可选择的最大数）和另一个整数 desiredTotal（累计和），判断先出手的玩家是否能稳赢（假设两位玩家游戏时都表现最佳）？
     *
     * 你可以假设 maxChoosableInteger 不会大于 20， desiredTotal 不会大于 300。
     *
     * 示例：
     *
     * 输入：
     * maxChoosableInteger = 10
     * desiredTotal = 11
     *
     * 输出：
     * false
     *
     * 解释：
     * 无论第一个玩家选择哪个整数，他都会失败。
     * 第一个玩家可以选择从 1 到 10 的整数。
     * 如果第一个玩家选择 1，那么第二个玩家只能选择从 2 到 10 的整数。
     * 第二个玩家可以通过选择整数 10（那么累积和为 11 >= desiredTotal），从而取得胜利.
     * 同样地，第一个玩家选择任意其他整数，第二个玩家都会赢。
     */
    public boolean canIWin(int maxChoosableInteger, int desiredTotal) {
        if (maxChoosableInteger >= desiredTotal) return true;
        // 若所有给定数字总和 < 目标值，则谁也不能赢，返回false
        if((1+maxChoosableInteger)*maxChoosableInteger/2 <desiredTotal) return false;
        // 保存每次选择后，第一个玩家的输赢状态
        Map<Integer, Boolean> usedNumsStatusMap = new HashMap<>();
        return canIWin(maxChoosableInteger, desiredTotal, usedNumsStatusMap, 0);
    }

    /**
     * @param maxChoosableInteger :最大选择数字
     * @param desiredTotal 累计和
     * @param usedNumsStatusMap 记忆化存储之前每次选择数字后，对应的输赢状态
     * @param usedStatus 按位来记录数组中的某个数字是否使用过
     * @return
     */
    // 思路：记忆化搜索
    private boolean canIWin(int maxChoosableInteger, int desiredTotal, Map<Integer, Boolean> usedNumsStatusMap, Integer usedStatus){
        // 由于递归调用，会存在重复计算，若已经计算过，则直接返回
        if (usedNumsStatusMap.containsKey(usedStatus)) {
            return usedNumsStatusMap.get(usedStatus);
        }
        for (int i = 1; i <= maxChoosableInteger; i++){
            // eg.每一位代表一个数是否遍历
            int cur = 1 << (i-1);
            // eg.usedStatus = 000...00011(1,2已选)  cur = 0000...0001000(3)
            if ((usedStatus & cur) != 0) continue; // 避免重复选择
            // 选择cur后的状态
            Integer nextUsedStatus = usedStatus | cur;
            // 本轮选择的玩家会赢的两种情况：
            // 1. i >= desiredTotal : 选择当前数字后，累计和超过指定值desiredTotal
            // 2. 上一轮未选i时，累计和超过desiredTotal - i (递归)
            // 递归最终状态回退到第一个玩家，若满足如上两种条件，则返回true，否则返回false
            if (i >= desiredTotal || !canIWin(maxChoosableInteger, desiredTotal - i, usedNumsStatusMap, nextUsedStatus)){
                usedNumsStatusMap.put(usedStatus, true);
                return true;
            }
        }
        usedNumsStatusMap.put(usedStatus, false);
        return false;
    }

    public static void main(String[] args) {
        CanIWin solution = new CanIWin();
        solution.canIWin(10, 40);
    }
}
