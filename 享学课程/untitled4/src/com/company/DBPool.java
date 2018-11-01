package com.company;

import java.sql.Connection;
import java.util.LinkedList;

public class DBPool {

    private final LinkedList<Connection> pool = new LinkedList<>();

    {
        for (int i = 0;i < 10;i++){
            pool.addLast(SqlConnectImpl.fetchConnection());
        }
    }

    public synchronized Connection getConn(Integer minis) throws InterruptedException {
        if (minis <= 0){
            while(pool.isEmpty()){
                wait();
            }
            return pool.removeFirst();
        } else{
            Connection conn = null;
            long overtime = System.currentTimeMillis()/1000 + minis;
            long remain = minis;
            while (pool.isEmpty() && remain > 0){
                wait(remain);
                remain = overtime - System.currentTimeMillis()/1000;
            }
            if (!pool.isEmpty()){
                conn = pool.removeFirst();
            }
            return conn;
        }
    }


    public synchronized void returnConn(Connection conn){
        if (conn == null){
            return;
        }
        pool.addLast(conn);
        notify();
    }

}
