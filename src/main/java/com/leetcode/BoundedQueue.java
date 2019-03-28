package com.leetcode;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author liubi
 * @date 2019-03-28 14:52
 **/
public class BoundedQueue<T> {
    private Object[] items;
    private int addIndex, removeIndex, count; // 添加的下标，删除的下标和数组当前数量
    private Lock lock = new ReentrantLock();
    private Condition notEmpty = lock.newCondition();
    private Condition notFull = lock.newCondition();
    public BoundedQueue(int size) {
        items = new Object[size];
    }
    // 添加一个元素，如果数组满，则添加线程进入等待状态，直到有"空位"
    public void add(T t) throws InterruptedException {
        lock.lock(); // 1. 获取锁
        try {
            while (count == items.length) { //while循环内 检查条件1
                notFull.await(); // 不满足条件1等待
            }
            // 满足条件1，执行逻辑操作
            items[addIndex] = t;
            if (++addIndex == items.length) {
                addIndex = 0;
            }
            ++count;
            //条件2得到满足，通知等待条件2的线程
            notEmpty.signal();
        } finally {
            lock.unlock(); // 释放锁
        }
    }
    // 由头部删除一个元素，如果数组空，则删除线程进入等待状态，直到有新添加元素
    @SuppressWarnings("unchecked")
    public T remove() throws InterruptedException {
        lock.lock(); // 1. 获取锁
        try {
            while (count == 0) { //while循环内 检查条件2
                notEmpty.await(); // 不满足条件2等待
            }
            // 满足条件2，执行逻辑操作
            Object x = items[removeIndex];
            if (++removeIndex == items.length) {
                removeIndex = 0;
            }
            --count;
            //条件1得到满足，通知等待条件2的线程
            notFull.signal();
            return (T) x;
        } finally {
            lock.unlock(); // 释放锁
        }
    }
}
