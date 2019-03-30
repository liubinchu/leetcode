package com.leetcode;

import java.io.IOException;
import java.io.PipedReader;
import java.io.PipedWriter;
import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * @author liubi
 * @date 2019-03-28 22:29
 **/
public class PipedIO {
    static class Sender implements Runnable {
        private Random rand = new Random(47);
        private PipedWriter out = new PipedWriter();
        public PipedWriter getPipedWriter() {
            return out;
        }
        @Override
        public void run() {
            try {
                while (true) {
                    for (char c = 'A'; c <= 'z'; c++) {
                        out.write(c);
                        TimeUnit.MILLISECONDS.sleep(rand.nextInt(500));
                    }
                }
            } catch (IOException e) {
                System.out.println(e + ": sender write exception");
            } catch (InterruptedException e) {
                System.out.println(e + ": sender sleep exception");
            }
        }
    }
    static class Receiver implements Runnable {
        private PipedReader in;
        public Receiver (Sender sender ) throws IOException{
            in = new PipedReader(sender.getPipedWriter());
        }
        @Override
        public void run() {
            try {
                System.out.println("read: "+(char)in.read()+". ");
            }catch (IOException e){
                System.out.println(e + ": receiver read exception");
            }
        }
    }
    public static void main(String[] args) throws Exception {
        Sender sender =  new Sender();
        Receiver receiver = new Receiver(sender);
        ExecutorService exec = Executors.newCachedThreadPool();
        exec.execute(sender);
        exec.execute(receiver);
        TimeUnit.SECONDS.sleep(4);
        exec.shutdownNow();
    }
}
