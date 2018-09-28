package com.leetcode;

import java.util.Stack;

// another way :https://blog.csdn.net/Regemc/article/details/79796341
// some tricks in that way
public class leetcode_155 {

    class MinStack {
        private Stack<Integer> data;
        private int min;

        /** initialize your data structure here. */
        public MinStack() {
            data = new Stack<Integer>();
            min = Integer.MAX_VALUE;
        }

        public void push(int x) {
            if(x<min) min = x;
            data.push(x);
        }

        public void pop() {
            int popElement = data.pop();
            if(popElement == min) {
                int temp = Integer.MAX_VALUE;
                for(int element : data){
                    if(element < temp) temp = element;
                }
                min = temp;
            }
        }

        public int top() {
            return data.peek();
        }

        public int getMin() {
            return min;
        }
    }
}
