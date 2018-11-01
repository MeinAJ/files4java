package com.company;

import java.io.File;
import java.util.List;
import java.util.concurrent.Exchanger;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ForkJoinPool;

public class ForkJoinSumMain {

    private static Exchanger<List<Long>> exchanger = new Exchanger<>();

    public static void main(String[] args) throws ExecutionException, InterruptedException {


        ArraySum arraySum = new ArraySum();

        ForkJoinSum forkJoinSum = new ForkJoinSum(arraySum.getArray(), 0, arraySum.getArray().length - 1);

        ForkJoinPool forkJoinPool = new ForkJoinPool();
        long start = System.currentTimeMillis();

        Integer invoke = forkJoinPool.invoke(forkJoinSum);//同步调用
        System.out.println("sum==" + invoke);
        System.out.println("Task is Running.....");

        System.out.println("The count is " + forkJoinSum.join()
                + " spend time:" + (System.currentTimeMillis() - start) + "ms");


    }

}
