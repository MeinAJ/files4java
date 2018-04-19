package com.aj.service.utils;

import com.alibaba.fastjson.JSONArray;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.UUID;

/**
 * this is a base class 4 everyclass
 *
 * @author Administrator
 * @create 2018-03-02 21:58
 */

@SuppressWarnings("static-access")
public class Base {

    protected JSONArray json = new JSONArray();

    protected Logger logger = LogManager.getLogger();

    //得到32位的uuid
    public String get32UUID() {
        return NumberUtils.getUUID32();
    }

}
