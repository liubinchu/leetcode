package com.leetcode;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * @author liubi
 * @date 2019-04-04 11:03
 **/
public class Cache {
    static Map<String, Object> map = new HashMap<String, Object>();
    static ReentrantReadWriteLock rwl = new ReentrantReadWriteLock();
    static Lock r = rwl.readLock();
    static Lock w = rwl.writeLock();
    // 获取一个key对应的value
    public  final Object get(String key) {
        r.lock();
        try {
            return map.get(key);
        } finally {
            r.unlock();
        }
    }// 设置key对应的value，并返回旧的value
    public  final Object put(String key, Object value) {
        boolean success  = r.tryLock();
        boolean success1 = w.tryLock();
        try {
            return map.put(key, value);
        } finally {
            w.unlock();
        }
    }// 清空所有的内容
    public  final void clear() {
        w.lock();
        try {
            map.clear();
        } finally {
            w.unlock();
        }
    }
    public static void main(String[] args){
        Cache cache = new Cache();
        cache.put("1","1");
    }
}
