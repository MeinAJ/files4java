package com.company;

import java.sql.Connection;

public class SemaphoreThread extends Thread {

    private SemaphoreDBPool semaphoreDBPool;

    public SemaphoreThread(SemaphoreDBPool semaphoreDBPool){
        this.semaphoreDBPool = semaphoreDBPool;
    }

    @Override
    public void run() {
        //TODO
        try {
            Connection conn = semaphoreDBPool.getConn();
            System.out.println(Thread.currentThread().getName() + ",拿到连接!!!!!!!!!!");
            Thread.sleep(1000);
            semaphoreDBPool.returnConn(conn);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }


        System.out.println(Thread.currentThread().getName() + ",run()结束运行");
    }
}
