package com.company;

public class WaitNotifyThread extends Thread {

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName() + ",开始运行!");

        //todo



        System.out.println(Thread.currentThread().getName() + ",结束运行!");
    }
}
