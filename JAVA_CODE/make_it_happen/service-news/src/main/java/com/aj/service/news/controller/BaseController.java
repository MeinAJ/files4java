package com.aj.service.news.controller;

import com.alibaba.fastjson.JSONObject;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class BaseController {

    //json
    protected JSONObject json = new JSONObject();

    //log4j
    Logger logger = LogManager.getLogger();

    //序列化号
    private static final long serialVersionUID = 6357869213649815391L;


}
