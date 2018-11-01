package com.company;

import java.util.concurrent.CountDownLatch;

public class CountDownLatchThread extends Thread{

    private CountDownLatch countDownLatch;

    public CountDownLatchThread(CountDownLatch countDownLatch){
        this.countDownLatch = countDownLatch;
    }

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName() + ",run()开始运行");

        countDownLatch.countDown();
        //TODO
//        try {
//            Thread.sleep(1000);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }

        System.out.println(Thread.currentThread().getName() + ",run()开始结束");
    }
}
