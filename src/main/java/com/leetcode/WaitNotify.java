package com.leetcode;


/**
 * @author liubi
 * @date 2019-09-21 20:50
 **/
public class WaitNotify {
    static class Print implements Runnable {
        private String threadName;
        private Object prev;
        private Object curr;

        public Print(String threadName, Object prev, Object curr) {
            this.threadName = threadName;
            this.prev = prev;
            this.curr = curr;
        }

        @Override
        public void run() {
            while (true) {
                synchronized (prev) {
                    synchronized (curr) {
                        System.out.println(threadName);
                        curr.notifyAll();
                    }
                    try {
                        prev.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        Object a = new Object();
        Object b = new Object();
        Object c = new Object();
        Thread A = new Thread(new Print("A", c, a));
        A.start();
        Thread.sleep(10);
        Thread B = new Thread(new Print("B", a, b));
        B.start();
        Thread.sleep(10);
        Thread C = new Thread(new Print("C", b, c));
        C.start();
        Thread.sleep(10);

    }
}
