package com.leetcode;

import java.util.*;

public class bilibili02 {
    private static int fun(int num) {
        int i = 2, res = 1;
        while (i * (i + 1) < 2 * num + 1) {
            if (num % i == ((i & 1) == 0 ?  i / 2:0 )) {
                res++;
            }
            i++;
        }
        return res;
    }

    public static void main(String[] args) {
/*        List<Integer> data = new ArrayList<>();
        Scanner sc = new Scanner(System.in);
        data.add(sc.nextInt());
        System.out.println(fun(data.get(0)));*/
        Map map = new HashMap();
        map.put("n",null);
        map.put("n","1");
        System.out.println(map.size());
    }
}
