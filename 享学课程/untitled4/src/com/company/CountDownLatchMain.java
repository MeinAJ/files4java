package com.company;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutionException;

public class CountDownLatchMain {

    private static CountDownLatch countDownLatch = new CountDownLatch(5);

    public static void main(String[] args) throws ExecutionException, InterruptedException {

        for(int i = 0;i < 3;i++){
            CountDownLatchThread countDownLatchThread = new CountDownLatchThread(countDownLatch);
            countDownLatchThread.start();
        }
        Thread.sleep(5000);
        countDownLatch.countDown();
        countDownLatch.countDown();
        System.out.println(countDownLatch.getCount() + ",多少个");
        countDownLatch.await();

        System.out.println("已经同时到达了!");

    }
}
