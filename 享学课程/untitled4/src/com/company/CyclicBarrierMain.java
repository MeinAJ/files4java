package com.company;

import com.sun.org.apache.xml.internal.res.XMLErrorResources_tr;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.ExecutionException;

public class CyclicBarrierMain {

    private static CyclicBarrier cyclicBarrier = new CyclicBarrier(3, new Thread(() -> {
        try {
            System.out.println("开始执行同时到达后的工作!!!!!!!!!!");
            System.out.println("开始等待!!!!!!!!!!");
            Thread.sleep(5000);
            System.out.println("等待5s完成!!!!!!!!!!");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }));

    public static void main(String[] args) throws ExecutionException, InterruptedException {

        for(int i = 0;i < 3;i++){
            CyclicBarrierThread cyclicBarrierThread = new CyclicBarrierThread(cyclicBarrier);
            cyclicBarrierThread.start();
        }

    }
}
