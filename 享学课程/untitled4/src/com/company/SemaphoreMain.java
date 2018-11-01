package com.company;

import java.util.concurrent.ExecutionException;

public class SemaphoreMain {

    public static void main(String[] args) throws ExecutionException, InterruptedException {

        SemaphoreDBPool semaphoreDBPool = new SemaphoreDBPool();

        for(int i = 0;i < 100;i++){
            SemaphoreThread semaphoreThread = new SemaphoreThread(semaphoreDBPool);
            semaphoreThread.start();
        }

    }
}
