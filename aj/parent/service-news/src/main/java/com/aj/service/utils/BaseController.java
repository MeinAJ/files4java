package com.aj.service.utils;

import com.alibaba.fastjson.JSONArray;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * controller的基础类
 *
 * @author Administrator
 * @create 2018-03-02 22:18
 */

public class BaseController {

    protected JSONArray json = new JSONArray();

    protected Logger logger = LogManager.getLogger();


}
