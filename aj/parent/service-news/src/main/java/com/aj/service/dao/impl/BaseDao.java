package com.aj.service.dao.impl;

import org.mybatis.spring.SqlSessionTemplate;

import javax.annotation.Resource;

/**
 * this is a clas
 *
 * @author Administrator
 * @create 2018-02-17 22:42
 */

public class BaseDao {

    @Resource(name = "ajDbSqlSessionTemplate")
    protected SqlSessionTemplate ajDbSqlSessionTemplate;
}
