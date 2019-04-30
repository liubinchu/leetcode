package com.leetcode;

import java.util.LinkedList;
import java.util.Objects;


/**
 * @author liubi
 * @date 2019-04-30 10:55
 **/
public class leetcode_32_1 {
    class Pair<K,V>{
        private K key;
        public K getKey() { return key; }
        private V value;
        public V getValue() { return value; }
        public Pair(K key,V value) {
            this.key = key;
            this.value = value;
        }
    }
    public int longestValidParentheses(String s) {
        LinkedList<Pair<Character, Integer>> stack = new LinkedList<>();
        for(int i=0;i<s.length();i++){
            Pair<Character,Integer> current = new Pair<>(s.charAt(i),i);
            Pair<Character,Integer> peek = stack.peek();
            if(peek!=null&&(peek.getKey().equals('(')&&current.getKey().equals(')'))){
                stack.pop();
            }
            else {
                stack.push(current);
            }
        }
        if(stack.isEmpty()){
            return s.length();
        }
        else {
            int maxLen = Integer.MIN_VALUE;
            int index1 = s.length();
            while (!stack.isEmpty()){
                Pair<Character,Integer> peek = stack.pop();
                int index2 = peek.getValue();
                if(index1-index2-1>maxLen){
                    maxLen = index1-index2-1;
                }
                index1 = index2;
            }
            int index2= -1;
            if(index1-index2-1>maxLen){
                maxLen = index1-index2-1;
            }
            return maxLen;

        }
    }
    public static void main(String[] args) {
        leetcode_32_1 solution = new leetcode_32_1();
        System.out.println(solution.longestValidParentheses(")()())"));
    }
}
