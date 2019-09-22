package com.leetcode;

public class WeiCeLue04 implements Runnable {
    private Thread t;
    private String threadName;

    public WeiCeLue04(String threadName) {
        this.threadName = threadName;
    }

    @Override
    public void run() {
        while (true) {
            System.out.println(threadName);
        }
    }

    public void start() {
        if(t==null){
            t = new Thread(this,threadName);
            t.start();
        }
    }
}
