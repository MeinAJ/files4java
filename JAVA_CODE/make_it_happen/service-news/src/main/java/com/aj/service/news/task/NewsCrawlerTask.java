package com.aj.service.news.task;


import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

@Component
public class NewsCrawlerTask {

    @Scheduled(cron = "0 0 1 * * ?")    //每天凌晨1点执行
    public void newsCrawlerTask() {

    }
}
