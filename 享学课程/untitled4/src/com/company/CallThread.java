package com.company;

import java.util.concurrent.Callable;

public class CallThread implements Callable {


    @Override
    public Object call() throws Exception {
        System.out.println("CallThread" + Thread.currentThread().getName());
        return 1;
    }
}
