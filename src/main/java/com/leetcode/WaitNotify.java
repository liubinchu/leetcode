package com.leetcode;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

/**
 * @author liubi
 * @date 2019-03-28 09:43
 **/
public class WaitNotify {
    static boolean flag = true;
    static Object lock = new Object();

    public static void main(String[] args) throws Exception {
        Thread waitThread = new Thread(new Wait(), "WaitThread");
        waitThread.start();
        TimeUnit.SECONDS.sleep(1);
        Thread notifyThread = new Thread(new Notify(), "NotifyThread");
        notifyThread.start();
    }

    static class Wait implements Runnable {
        @Override
        public void run() {
            synchronized (lock) { // 加锁，拥有lock的Monitor
                while (flag) { // 当条件不满足时，继续wait，同时释放了lock的锁
                    System.out.println(Thread.currentThread() + " flag is true. wait@ " + new SimpleDateFormat("HH:mm:ss").format(new Date()));
                    try {
                        lock.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }// 条件满足时，完成工作
                System.out.println(Thread.currentThread() + " flag is false. running @ " + new SimpleDateFormat("HH:mm:ss").format(new Date()));
            }
        }
    }

    static class Notify implements Runnable {
        @Override
        public void run() { // 加锁，拥有lock的Monitor
            synchronized (lock) { // 获取lock的锁，然后进行通知，通知时不会释放lock的锁，直到当前线程释放了lock后，WaitThread才能从wait方法中返回
                System.out.println(Thread.currentThread() + " hold lock. notify @ " + new SimpleDateFormat("HH:mm:ss").format(new Date()));
                lock.notifyAll();
                flag = false;
            }// 再次加锁
            try {
                TimeUnit.SECONDS.sleep(5);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            synchronized (lock) {
                System.out.println(Thread.currentThread() + " hold lock again. sleep@ " + new SimpleDateFormat("HH:mm:ss").format(new Date()));
                try {
                    TimeUnit.SECONDS.sleep(5);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
/*
        Thread[WaitThread,5,main] flag is true. wait@ 10:03:36
        Thread[NotifyThread,5,main] hold lock. notify @ 10:03:37
        Thread[WaitThread,5,main] flag is false. running @ 10:03:37
        Thread[NotifyThread,5,main] hold lock again. sleep@ 10:03:42*/
