package com.aj.service.utils;

import com.alibaba.fastjson.JSONArray;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * this is a class
 *
 * @author Administrator
 * @create 2018-03-02 22:20
 */

public class BaseService {

    protected JSONArray json = new JSONArray();

    protected Logger logger = LogManager.getLogger();
}
