package com.ktao.leetcode.设计题;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 225. 用队列实现栈
 * @author kongtao
 * @version 1.0
 * @description:
 * @date 2020/5/30
 **/
public class MyStack {
    /**
     * 使用队列实现栈的下列操作：
     *
     * push(x) -- 元素 x 入栈
     * pop() -- 移除栈顶元素
     * top() -- 获取栈顶元素
     * empty() -- 返回栈是否为空
     * 注意:
     *
     * 你只能使用队列的基本操作-- 也就是 push to back, peek/pop from front, size, 和 is empty 这些操作是合法的。
     * 你所使用的语言也许不支持队列。 你可以使用 list 或者 deque（双端队列）来模拟一个队列 , 只要是标准的队列操作即可。
     * 你可以假设所有操作都是有效的（例如, 对一个空的栈不会调用 pop 或者 top 操作）。
     *
     * 思路：队列先进先出，栈先进后出。因此每次队列插入元素的之后，将之前队列里面所有的元素逐一压出，再逐一压入，这样就可以保证队列里的元素是倒着插进去的，和栈统一
     */
    private Queue<Integer> queue;

    /** Initialize your data structure here. */
    public MyStack() {
        queue = new LinkedList<>();
    }

    /** Push element x onto stack. */
    public void push(int x) {
        queue.offer(x);
        if (queue.size() > 1){
            for (int i = 1; i < queue.size(); i++) {
                queue.offer(queue.poll());
            }
        }
    }

    /** Removes the element on top of the stack and returns that element. */
    public int pop() {
        return queue.poll();
    }

    /** Get the top element. */
    public int top() {
        return queue.peek();
    }

    /** Returns whether the stack is empty. */
    public boolean empty() {
        return queue.isEmpty();
    }
}