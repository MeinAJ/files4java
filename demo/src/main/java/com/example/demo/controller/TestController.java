package com.example.demo.controller;

import com.example.demo.utils.RedisUtil;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.concurrent.CountDownLatch;

@RestController
@RequestMapping(value = "/test")
public class TestController {

    private Long count = 0L;

    @Resource(name = "redisUtil")
    private RedisUtil redisUtil;

    @RequestMapping(value = "/login",headers = "accept=*/*",produces = "application/json",method = RequestMethod.POST)
    public String login(HttpServletRequest request, @RequestBody String userInfo) throws InterruptedException {

        CountDownLatch countDownLatch = new CountDownLatch(10);
        for (int i = 0;i < 10;i++){
            new Thread(){
                @Override
                public void run(){
                    while(redisUtil.getNXKey("ssss", 10) != 1) {
                        try {
                            Thread.sleep(10);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }

                    try{
                        count = count + 1;
                    } catch (Exception e){
                        e.printStackTrace();
                    } finally {
                        redisUtil.releaseKey("ssss");
                        System.out.println("得到锁,并释放锁了!");
                        countDownLatch.countDown();
                    }

                }
            }.start();
        }
        countDownLatch.await();
        System.out.println("count" + count);

        count = 0L;
        return userInfo;
    }

}
