package com.company;

import com.sun.org.apache.xml.internal.res.XMLErrorResources_tr;

public class ExtendsThread extends Thread {

    public static volatile Integer count = 0;

    public Thread thread;

    public ExtendsThread(Thread thread){
        this.thread = thread;
    }

    @Override
    public void run() {
        try {
            thread.join();
            System.out.println("extendsThread启动了");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
//        System.out.println(Thread.currentThread().getName());
//        System.out.println(isInterrupted());
//        while (!isInterrupted()) {
//            count++;
//            System.out.println(count);
//            count++;
//            System.out.println(count);
//            System.out.println("ExtendsThread111111" + Thread.currentThread().getName());
//            System.out.println("ExtendsThread" + Thread.currentThread().getName());
//        }
    }
}