package com.leetcode;

import java.util.*;

/**
 * @author liubi
 * @date 2019-09-07 10:02
 **/
public class WeiCeLueYQQ01 {
    private int a;
    private int b;
    private int c;

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        WeiCeLueYQQ01 that = (WeiCeLueYQQ01) o;
        return a == that.a &&
                b == that.b &&
                c == that.c;
    }

    @Override
    public int hashCode() {
        return Objects.hash(a, b, c);
    }

    public static void main(String[] args) {
        int n =2;
        String[] data = new String[]{"{}[]()", "{[}]}"};
        System.out.println(braces(new ArrayList<>(Arrays.asList(data))));

    }
}
