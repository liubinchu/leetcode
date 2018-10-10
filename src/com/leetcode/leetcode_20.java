package com.leetcode;

import java.util.Stack;

public class leetcode_20 {
    public boolean isValid(String s) {
        Stack<Character> checkStack = new Stack<>();
        for(int i=0;i<s.length();i++){
            char curr = s.charAt(i);
            if(curr=='(' ||curr=='[' ||curr=='{')
                checkStack.push(curr);
            else if(checkStack.empty())
                return false; // 对于)]}三个 如果空栈 取不到栈顶元素 且不是合法括号对
            else if(curr == ')'){
                char peek = checkStack.peek();
                if(peek == '(') checkStack.pop();
                else return false;
            }
            else if(curr == ']'){
                char peek = checkStack.peek();
                if(peek == '[') checkStack.pop();
                else return false;
            }
            else if(curr == '}'){
                char peek = checkStack.peek();
                if(peek == '{') checkStack.pop();
                else return false;
            }
            else return false;// appear illegal char
        }
        if(checkStack.empty()) return true;
        else return false;
    }

    public static void main(String[] args) {
        int n1= 10;
        Integer n2 = Integer.valueOf(10);
        System.out.println(n1 == n2);
        String s = new String("sad");
        Character c = Character.valueOf('s');
        System.out.println(s.charAt(0)== c);
        leetcode_20 solution = new leetcode_20();

    }
}
