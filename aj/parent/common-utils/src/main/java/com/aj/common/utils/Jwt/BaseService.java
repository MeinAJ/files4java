package com.aj.common.utils.Jwt;

import com.alibaba.fastjson.JSONObject;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * this is a base service
 *
 * @author Administrator
 * @create 2018-02-17 22:35
 */

public class BaseService {

    protected Logger logger = LogManager.getLogger();

    protected JSONObject json = new JSONObject();

}
