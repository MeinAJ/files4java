package com.company;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Exchanger;

public class Exchange02Thread extends Thread {

    public Exchanger<List<Long>> exchanger;

    public Thread thread;

    public Exchange02Thread(Exchanger<List<Long>> exchanger,Thread thread){
        this.exchanger = exchanger;
        this.thread = thread;
    }

    @Override
    public void run() {
        List<Long> list = new ArrayList<>();
        System.out.println(Thread.currentThread().getName() + ",run()开始运行");

        //TODO
        for (long i = 0L; i < 10L ; i++){
            list.add(i);
        }
        try {
            List<Long> exchange = exchanger.exchange(list);
            thread.join();
            for (Long aLong : exchange) {
                System.out.println("本来是0-10数字=" + aLong + "\n");
            }

        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println(Thread.currentThread().getName() + ",run()结束运行");
    }
}
