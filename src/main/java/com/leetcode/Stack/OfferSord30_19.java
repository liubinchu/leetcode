package com.leetcode.Stack;

import java.util.Stack;

/**
 * @author liubi
 * @date 2018-11-30 10:59
 **/
public class OfferSord30_19 {
    /**
     * 一开始的思路： 认为 按照顺序/或者在state 中保存所有 入栈过的顺序 那么 这样子 就涉及到排序
     * 即使state 使用链表 那么 当新元素入栈时 查找其在有序state中的位置 也许 O（n） 题目要求 O(1)
     * 看了解析之后 发现一个 误区： state 中 不需要 保存 所有 入站元素 只需保存 比当前最小元素小的元素 就行 state 因此 就是有序的
     * 比如 按照以下顺序入栈 10 100 1000 1， 那么 最小栈 是 1 ,10. 第一次 出栈 1 第二次出 1000 第三次100 第四次 10
     * 因为 数据栈的FILO 特性 两次最小元素之间的元素1 10 始终不会成为 最小元素 因此 最小栈不需要保存所有数据栈中的元素
     */

/*        private Stack<Integer> dataStack = new Stack<>();
        private Stack<Integer> state = new Stack<>();
        public void push(int node) {
            if(state.empty()||state.peek()>node){
                state.push(node);
            }
            dataStack.push(node);
        }

        public int pop() {
            int res =dataStack.pop();
            if(res == state.peek()){
                state.pop();
            }
            return res;
        }

        public int top() {
            return dataStack.peek();
        }

        public int min() {
            return state.peek();
        }*/

    private Stack<Integer> dataStack = new Stack<>();
    private Stack<Integer> state = new Stack<>();  // 用以记录每个元素入栈时的 当前最小元素

    public void push(int node) {
        if (state.empty()) {
            state.push(node);
        } else {
            state.push(Math.min(state.peek(), node));
        }
        dataStack.push(node);
    }

    public void pop() {
        state.pop();
        dataStack.pop();
    }

    public int top() {
        return dataStack.peek();
    }

    public int min() {
        return state.peek();
    }

    public static void main(String[] args) {
        OfferSord30_19 solution = new OfferSord30_19();
    }
}
