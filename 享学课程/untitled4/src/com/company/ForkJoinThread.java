package com.company;

public class ForkJoinThread extends Thread {


    @Override
    public void run() {

        System.out.println(Thread.currentThread().getName() + ",run()开始运行");

        //TODO


        System.out.println(Thread.currentThread().getName() + ",run()结束运行");

    }

}
