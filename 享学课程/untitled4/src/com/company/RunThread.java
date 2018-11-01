package com.company;

public class RunThread implements Runnable {


    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName());
        System.out.println(Thread.currentThread().isInterrupted());
        while (!Thread.currentThread().isInterrupted()){
            try {
                Thread.sleep(100);
                System.out.println("ExtendsThread111111" + Thread.currentThread().getName());
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                System.out.println(Thread.currentThread().isInterrupted());
                e.printStackTrace();
            } finally {
                System.out.println("finally");
            }
        }
        System.out.println("ExtendsThread" + Thread.currentThread().getName());
    }

}
