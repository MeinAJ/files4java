package com.company;

public class JoinThread extends Thread {

    @Override
    public void run(){
        try {
            System.out.println("joinThread01启动了");
            System.out.println(Thread.currentThread().getName() + ",5s等待前");
            Thread.sleep(5000);
            System.out.println(Thread.currentThread().getName() + ",5s等待后");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
