package com.ktao.leetcode.搜索;

import java.util.ArrayList;
import java.util.List;

/**
 * 212. 单词搜索 II
 * @author kongtao
 * @version 1.0
 * @description:
 * @date 2020/5/23
 **/
public class WordSearchII {
    /**
     * 给定一个二维网格 board 和一个字典中的单词列表 words，找出所有同时在二维网格和字典中出现的单词。
     *
     * 单词必须按照字母顺序，通过相邻的单元格内的字母构成，其中“相邻”单元格是那些水平相邻或垂直相邻的单元格。同一个单元格内的字母在一个单词中不允许被重复使用。
     *
     * 示例:
     *
     * 输入:
     * words = ["oath","pea","eat","rain"] and board =
     * [
     *   ['o','a','a','n'],
     *   ['e','t','a','e'],
     *   ['i','h','k','r'],
     *   ['i','f','l','v']
     * ]
     *
     * 输出: ["eat","oath"]
     * 说明:
     * 你可以假设所有输入都由小写字母 a-z 组成。
     *
     * 提示:
     *
     * 你需要优化回溯算法以通过更大数据量的测试。你能否早点停止回溯？
     * 如果当前单词不存在于所有单词的前缀中，则可以立即停止回溯。什么样的数据结构可以有效地执行这样的操作？散列表是否可行？为什么？ 前缀树如何？如果你想学习如何实现一个基本的前缀树，请先查看这个问题： 实现Trie（前缀树）。
     */
    public List<String> findWords(char[][] board, String[] words) {
        List<String> res = new ArrayList<>();
        for (String word : words){
            if (exist(board, word)){
                res.add(word);
            }
        }
        return res;
    }

    private boolean exist(char[][] board, String word) {
        int rows = board.length;
        if (rows == 0) return false;
        int cols = board[0].length;
        for (int i = 0; i < rows; i++){
            for (int j = 0; j < cols; j++){
                if (exist(board, i, j, word, 0)){
                    return true;
                }
            }
        }
        return false;
    }

    private boolean exist(char[][] board, int row, int col, String word, int index){
        if (row < 0 || row >= board.length || col < 0 || col >= board[0].length){
            return false;
        }
        if (board[row][col] != word.charAt(index)) return false;
        if (index == word.length() - 1) return true;
        char temp = board[row][col];
        board[row][col] = '$';
        if (exist(board, row + 1, col, word, index + 1)
                || exist(board, row - 1, col, word, index + 1)
                || exist(board, row, col + 1, word, index + 1)
                || exist(board, row, col - 1, word, index + 1)){
            board[row][col] = temp;
            return true;
        }
        board[row][col] = temp;
        return false;
    }
}
