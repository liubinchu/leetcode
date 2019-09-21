package com.leetcode;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author liubi
 * @date 2019-09-17 09:25
 **/
public class Print {
    static ReentrantLock lock = new ReentrantLock();
    static Condition runA = lock.newCondition();
    static Condition runB = lock.newCondition();

    static class A extends Thread {
        static int value = 1;

        @Override
        public void run() {
            while (value < 4) {
                lock.lock();
                try {
                    if (value != 1) {
                        runA.await();
                    }
                    System.out.println(value++);
                    runB.signal();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    lock.unlock();
                }
            }

        }
    }

    static class B extends Thread {
        static int value = 1;

        @Override
        public void run() {
            while (value < 4) {
                lock.lock();
                try {
                    if (value != 1) {
                        runB.await();
                    }
                    System.out.println(value++);
                    runA.signal();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    lock.unlock();
                }
            }

        }
    }

    public static void main(String[] args) {
        Thread A = new A();
        Thread B = new B();
        A.start();
        B.start();
    }
}
