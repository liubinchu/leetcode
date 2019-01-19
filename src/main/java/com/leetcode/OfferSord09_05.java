package com.leetcode;

import java.util.Stack;

/**
 * @author liubi
 * @date 2018-11-20 21:11
 **/

public class OfferSord09_05 {
    /*
    Stack<Integer> stack1 = new Stack<Integer>();
    Stack<Integer> stack2 = new Stack<Integer>();
    public void push(int node) {
        stack1.push(node);
    }
    public int pop() {
        while(!stack1.isEmpty()){
            stack2.push(stack1.pop());
        }
        int result = stack2.pop();
        while(!stack2.isEmpty()){
            stack1.push(stack2.pop());
        }
        return result;
    }
    */

    /**
     *  相比于之前的算法, 两个栈之间元素的交换次数减少
     */
    private Stack<Integer> stack1 = new Stack<Integer>();
    private Stack<Integer> stack2 = new Stack<Integer>();

    public void push(int node) {
        while(!stack2.isEmpty()){
            stack1.push(stack2.pop());
        }
        stack1.push(node);
    }

    public int pop() {
        while(!stack1.isEmpty()){
            stack2.push(stack1.pop());
        }
        return stack2.pop();
    }
    public static void main(String[] args) {
        OfferSord09_05 solution = new OfferSord09_05();
    }
}
