package com.leetcode;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class face02 {
    private static Map<Character, Integer> map = new HashMap<>();
    private static  int counter = 0;
    private static int fun(String s, int k) {
        int res = Integer.MIN_VALUE;
        int l = 0;
        for (int r = 0; r < s.length(); r++) {
            map.put(s.charAt(r), r);
            while (map.size() > k) {
                counter ++;
                char lc = s.charAt(l);
                if (map.get(lc) == l) {
                    counter++;
                    map.remove(lc);
                }
                l++;
            }
            res = Math.max(res, r - l + 1);
        }
        return res;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int k = Integer.parseInt(sc.nextLine());
        String sequence = sc.nextLine();
        System.out.println(fun(sequence, k));
    }
}
