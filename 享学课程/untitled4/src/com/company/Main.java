package com.company;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

public class Main {

    public static void main(String[] args) throws ExecutionException, InterruptedException {

//        ExtendsThread extendsThread = new ExtendsThread();
//        extendsThread.start();
//
//        Thread.sleep(1000);
//        extendsThread.interrupt();
//
//        RunThread runThread = new RunThread();
//        Thread thread = new Thread(runThread);
//        thread.start();
//
//        Thread.sleep(1000);
//        thread.interrupt();
        JoinThread joinThread01 = new JoinThread();
        joinThread01.start();

        ExtendsThread extendsThread = new ExtendsThread(joinThread01);
        extendsThread.start();

    }
}
