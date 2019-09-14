package com.leetcode.LRU;

import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class LRUCache<K, V> extends LinkedHashMap<K, V> {
    private int cacheCap;
    private static final float LOAD_FACTOR = 0.75f;
    private final Lock lock = new ReentrantLock();

    @Override
    protected boolean removeEldestEntry(Map.Entry eldest) {
        return size() > this.cacheCap;
    }

    public LRUCache(int cacheCap) {
        super(16, LOAD_FACTOR, true);
        this.cacheCap = cacheCap;
    }

    @Override
    public boolean containsKey(Object key) {
        try {
            lock.lock();
            return super.containsKey(key);
        } finally {
            lock.unlock();
        }
    }


    @Override
    public V get(Object key) {
        try {
            lock.lock();
            return super.get(key);
        } finally {
            lock.unlock();
        }
    }

    @Override
    public V put(K key, V value) {
        try {
            lock.lock();
            return super.put(key, value);
        } finally {
            lock.unlock();
        }
    }

    @Override
    public int size() {
        try {
            lock.lock();
            return super.size();
        } finally {
            lock.unlock();
        }
    }

    @Override
    public void clear() {
        try {
            lock.lock();
            super.clear();
        } finally {
            lock.unlock();
        }
    }

    public Collection<Map.Entry<K, V>> getAll() {
        try {
            lock.lock();
            return new ArrayList<>(super.entrySet());
        } finally {
            lock.unlock();
        }
    }

    public int getUntargetedTime(int[] pages, int page_cnt, int memSize) {
        Object defaulePage = new Object();
        LRUCache<Integer, Object> cache = new LRUCache<>(memSize);
        int res = 0;
        for (int i = 0; i < pages.length; i++) {
            if(!cache.containsKey(pages[i])){
                res++;
                cache.put(pages[i],defaulePage);
            }
        }
        return res;
    }
    public static void main(String[] args) {
/*        Scanner sc = new Scanner(System.in);
        String wines = sc.nextLine();
        int cap = Integer.parseInt(sc.nextLine());
        int [] data = new int[wines.split(",").length];
        for (int i=0;i<wines.split(",").length;i++){
            data[i] = Integer.parseInt(wines.split(",")[i]);
        }*/
        int[] data = {1, 2, 1, 3, 2, 1, 4, 3, 4};
        int cap = 2;
        LRUCache<Integer,Integer> decanter = new LRUCache<>(cap);

        StringBuilder res = new StringBuilder();
        for (int wine : data) {
            res.append(decanter.get(wine));
            res.append(",");
        }
        res.deleteCharAt(res.length()-1);
        System.out.println(res);
    }
}