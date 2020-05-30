package com.ktao.leetcode.设计题;

import java.util.Stack;

/**
 * 232. 用栈实现队列
 * @author kongtao
 * @version 1.0
 * @description:
 * @date 2020/5/30
 **/
public class MyQueue {

    /**
     * 使用栈实现队列的下列操作：
     *
     * push(x) -- 将一个元素放入队列的尾部。
     * pop() -- 从队列首部移除元素。
     * peek() -- 返回队列首部的元素。
     * empty() -- 返回队列是否为空。
     * 示例:
     *
     * MyQueue queue = new MyQueue();
     *
     * queue.push(1);
     * queue.push(2);
     * queue.peek();  // 返回 1
     * queue.pop();   // 返回 1
     * queue.empty(); // 返回 false
     *
     *
     * 思路：采用两个栈s1, s2，其中一个s2作为辅助栈。每次向s1中压入元素的时候：
     *
     * 1、先把s1中的元素都压到s2中
     *
     * 2、再将这个元素压到s1中，然后再将s2中的元素都压回来。
     *
     * 这样就可以保证s1中所有的元素是倒着压入的，由于栈先进后出，从而实现了队列的先进先出。
     */
    private Stack<Integer> stack1;

    private Stack<Integer> stack2;

    /** Initialize your data structure here. */
    public MyQueue() {
        stack1 = new Stack<>();
        stack2 = new Stack<>();
    }

    /** Push element x to the back of queue. */
    public void push(int x) {
        while (!stack1.isEmpty()){
            stack2.push(stack1.pop());
        }
        stack1.push(x);
        while (!stack2.isEmpty()){
            stack1.push(stack2.pop());
        }
    }

    /** Removes the element from in front of queue and returns that element. */
    public int pop() {
        return stack1.pop();
    }

    /** Get the front element. */
    public int peek() {
        return stack1.peek();
    }

    /** Returns whether the queue is empty. */
    public boolean empty() {
        return stack1.isEmpty();
    }
}
