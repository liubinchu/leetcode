package com.leetcode.Loop;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class leetcode_13 {

    public int romanCharToInt(char c) {
        switch (c) {
            case 'I':
                return 1;
            case 'V':
                return 5;
            case 'X':
                return 10;
            case 'L':
                return 50;
            case 'C':
                return 100;
            case 'D':
                return 500;
            case 'M':
                return 1000;
        }
        return -1;
    }

    public int romanToInt0(String s) {
        int result = 0;
        int current = 0;
        int prev = romanCharToInt(s.charAt(0));
        if (prev < 0) {
            return -2;// 错误的罗马数字：出现了不合法字符
        }
        for (int i = 1; i < s.length(); i++) {
            current = romanCharToInt(s.charAt(i));
            if (prev < current) {
                prev = -prev;
            }
            result += prev;
            prev = current;
        }
        result += prev;
        return result;
    }

    static Map<Character, Integer> map = new HashMap<>(7);

    static {
        map.put('I', 1);
        map.put('V', 5);
        map.put('X', 10);
        map.put('L', 50);
        map.put('C', 100);
        map.put('D', 500);
        map.put('M', 1000);
    }

    public int romanToInt(String s) {
        int res = 0;
        for (int i = 0; i < s.length(); i++) {
            if (i < s.length() - 1
                    && map.get(s.charAt(i)) < map.get(s.charAt(i + 1))) {
                res -= map.get(s.charAt(i));
            } else {
                res += map.get(s.charAt(i));
            }
        }
        return res;
    }


    public static void main(String[] args) {
        leetcode_13 solution = new leetcode_13();
        ArrayList<Integer> result = new ArrayList<Integer>(10);
        for (Integer i : result) {
            System.out.println("sad");
            System.out.println(i);
        }
    }
}
