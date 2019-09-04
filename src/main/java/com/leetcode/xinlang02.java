package com.leetcode;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @author binchu.liu
 * @date 21/08/2019 20:11
 */
public class xinlang02 {
    LinkedHashMap<Integer, Integer> map;

    public xinlang02(int capacity) {
        int mapSize = (int) Math.ceil(capacity / 0.75f) + 1;
        map = new LinkedHashMap(mapSize, 0.75f, true) {
            @Override
            protected boolean removeEldestEntry(Map.Entry eldest) {
                return size() > capacity;
            }
        };
    }

    public void put(Integer key, Integer value) {
        map.put(key, value);
    }

    public Integer get(Integer key) {
        Integer res = map.get(key);
        return res == null ? -1 : res;

    }

    public static void main(String[] args) {
        xinlang02 cache = new xinlang02(2);
        cache.put(1, 1);
        cache.put(2, 2);
        System.out.println(cache.get(1));
        cache.put(3, 3);
        System.out.println(cache.get(2));


    }


}
