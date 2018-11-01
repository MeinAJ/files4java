package com.company;

import java.util.List;
import java.util.concurrent.Exchanger;
import java.util.concurrent.ExecutionException;

public class ExchangeMain {

    private static Exchanger<List<Long>> exchanger = new Exchanger<>();

    public static void main(String[] args) throws ExecutionException, InterruptedException {

        ExchangeThread exchangeThread = new ExchangeThread(exchanger);
        exchangeThread.start();

        Exchange02Thread exchange02Thread = new Exchange02Thread(exchanger,exchangeThread);
        exchange02Thread.start();

    }
}
