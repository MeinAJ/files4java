package com.aj.service.news.dao;

import org.mybatis.spring.SqlSessionTemplate;
import javax.annotation.Resource;

public abstract class BaseDao {

    @Resource(name = "ajDbSqlSessionTemplate")
    protected SqlSessionTemplate ajDbSqlSessionTemplate;

}
