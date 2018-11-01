package com.company;

import java.util.concurrent.ForkJoinTask;
import java.util.concurrent.RecursiveTask;

public class ForkJoinSum extends RecursiveTask<Integer> {


    private Integer[] src;
    private Integer fromIndex;
    private Integer toIndex;

    public ForkJoinSum(Integer[] src,Integer fromIndex,Integer toIndex){
        this.src = src;
        this.fromIndex = fromIndex;
        this.toIndex = toIndex;
    }

    @Override
    protected Integer compute() {

        System.out.println("threadName===" + Thread.currentThread().getName());

        int mini = ArraySum.ARRAY_LENGTH / 400;
        if (toIndex - fromIndex < mini){
            int count = 0;
            for (int i = fromIndex;i <= toIndex;i++){
                SleepTools.ms(1);
                count = count + src[i];
            }
            return count;
        } else {
            Integer mid = (fromIndex + toIndex)/2;
            ForkJoinSum before = new ForkJoinSum(src,fromIndex,mid);
            ForkJoinSum after = new ForkJoinSum(src,mid + 1,toIndex);
            invokeAll(before,after);
            return before.join() + after.join();
        }
    }

}
