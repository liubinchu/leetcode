package com.leetcode;

import java.util.*;

/**
 * @author liubi
 * @date 2019-09-07 10:02
 **/
public class WeiCeLue01 {


    public static boolean match(char a, char b) {
        if (a == '(' && b == ')') {
            return true;
        } else if (a == '{' && b == '}') {
            return true;
        } else if (a == '[' && b == ']') {
            return true;
        } else {
            return false;
        }
    }

    public static boolean fun(String data) {
        Stack<Character> stack = new Stack<>();
        for (char c : data.toCharArray()) {
            if (stack.empty() || !match(stack.peek(), c)) {
                stack.push(c);
            } else {
                stack.pop();
            }
        }
        return stack.empty();
    }

    static List<String> braces(List<String> values) {
        List<String> res = new ArrayList<>(values.size());
        for (String d : values) {
            String tmp = fun(d) ? "YES" : "NO";
            res.add(tmp);
        }
        return res;
    }


    public static void main(String[] args) {
        System.out.println(0x23 & 0x34);
        System.out.println(0x20);
    }
}
