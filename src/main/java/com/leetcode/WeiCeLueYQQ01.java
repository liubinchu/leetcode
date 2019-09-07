package com.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

/**
 * @author liubi
 * @date 2019-09-07 10:02
 **/
public class WeiCeLueYQQ01 {
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
        int n = 2;
        String[] data = new String[]{"{}[]()", "{[}]}"};
        System.out.println(braces(new ArrayList<>(Arrays.asList(data))));
    }
}
