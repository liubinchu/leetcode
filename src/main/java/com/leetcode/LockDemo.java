package com.leetcode;

import java.util.concurrent.locks.ReentrantLock;

/**
 * @author liubi
 * @date 2019-04-02 22:31
 **/
public class LockDemo {
    private static ReentrantLock lock = new ReentrantLock();

    public static void main(String[] args) {
        for (int i = 0; i < 5; i++) {
            if(i==4){
                System.out.println(i);
            }
            Thread thread = new Thread(() -> {
                lock.lock();
                try {
                    Thread.sleep(10000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    lock.unlock();
                }
            });
            thread.start();
        }
    }
}
