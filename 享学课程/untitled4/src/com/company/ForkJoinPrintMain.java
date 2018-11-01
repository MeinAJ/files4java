package com.company;

import javax.sound.midi.Synthesizer;
import java.io.File;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.concurrent.Exchanger;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ForkJoinPool;

public class ForkJoinPrintMain {

    private static Exchanger<List<Long>> exchanger = new Exchanger<>();

    public static void main(String[] args) throws ExecutionException, InterruptedException {

        long start = System.currentTimeMillis();
        ForkJoinPool forkJoinPool = new ForkJoinPool();
        File file = new File("E:\\");
        ForkJoinPrint forkJoinPrint = new ForkJoinPrint(file);
        forkJoinPool.invoke(forkJoinPrint);

        System.out.println("多少个:" + forkJoinPrint.join().size() + ",time=" + (System.currentTimeMillis() - start));

    }

}
