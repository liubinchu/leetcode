package com.leetcode;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

/**
 * @author liubi
 * @date 2019-03-17 22:43
 **/
public class Shutdown {
    private static class Runner implements Runnable {
        private long i;
        private volatile boolean on = true;
        @Override
        public void run() {
            while (on && !Thread.currentThread().isInterrupted()) { i++; }
            System.out.println("Count i = " + i);
            // 可以进行清理工作
        }
        public void cancel() { on = false; }
    }
    public static void main(String[] args) throws Exception {
        Runner one = new Runner();
        Thread countThread = new Thread(one, "CountThread");
        countThread.start();
        // 通过中断 结束
        TimeUnit.SECONDS.sleep(1);
        countThread.interrupt();
        one.cancel();
        Runner two = new Runner();
        countThread = new Thread(two, "CountThread");
        countThread.start();
        // 通过On标志结束
        TimeUnit.SECONDS.sleep(1);
        two.cancel();
        ExecutorService exautorService = Executors.newCachedThreadPool();
        Future<?> f = exautorService.submit(one);
    }
}


