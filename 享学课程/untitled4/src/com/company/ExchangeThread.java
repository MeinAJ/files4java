package com.company;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Exchanger;

public class ExchangeThread extends Thread {

    public Exchanger<List<Long>> exchanger;

    public ExchangeThread(Exchanger<List<Long>> exchanger){
        this.exchanger = exchanger;
    }


    @Override
    public void run() {
        List<Long> list = new ArrayList<>();
        System.out.println(Thread.currentThread().getName() + ",run()开始运行");

        //TODO
        for (long i = 100L; i < 110L ; i++){
            list.add(i);
        }
        try {
            List<Long> exchange = exchanger.exchange(list);
            for (Long aLong : exchange) {
                System.out.println("本来是100-110数字=" + aLong + "\n");
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println(Thread.currentThread().getName() + "应该先运行完,run()结束运行");
    }
}
