package com.company;

import java.sql.Connection;
import java.util.LinkedList;
import java.util.concurrent.Semaphore;

public class SemaphoreDBPool {

    private final LinkedList<Connection> pool = new LinkedList<>();
    private static final Integer INIT_SIZE = 10;
    private Semaphore useful,useless;


    public SemaphoreDBPool(){
        useful = new Semaphore(INIT_SIZE);
        useless = new Semaphore(0);
    }

    {
        for (int i = 0;i < INIT_SIZE ;i++){
            pool.addLast(SqlConnectImpl.fetchConnection());
        }
    }

    public Connection getConn() throws InterruptedException {
        useful.acquire();
        Connection conn;
        synchronized(pool){
            conn = pool.removeFirst();
        }
        useless.release();
        return conn;
    }

    public void returnConn(Connection conn) throws InterruptedException {
        if (conn != null){
            useless.acquire();
            synchronized(pool){
                System.out.println("当前有"+useful.getQueueLength()+"个线程等待数据库连接！！"
                        +"可用连接数:"+useful.availablePermits());
                pool.addLast(conn);
            }
        }
        useful.release();
    }

}
