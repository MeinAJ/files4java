package com.aj.common.utils.controller;

import com.aj.common.utils.model.MBasePager;
import com.alibaba.fastjson.JSONObject;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import javax.servlet.http.HttpServletRequest;

/**
 * this is a base controller
 *
 * @author Administrator
 * @create 2018-02-15 22:58
 */

public class BaseController {

    protected Logger logger = LogManager.getLogger();

    protected JSONObject json = new JSONObject();

    /**
     *
     * 添加公共参数
     *
     * @param object
     * @param request
     * @return
     */
    public static Object loadCommonParam(Object object, HttpServletRequest request) {
        MBasePager model = (MBasePager) object;
        model.setAddAgent(request.getHeader("user-agent"));
        model.setLanguage(request.getHeader("language"));
        model.setPlatform(request.getHeader("Client-Platform"));
        model.setAddAt(System.currentTimeMillis()/1000);
        String addBy = (String) request.getAttribute("addBy");
        if (addBy != null && !addBy.equals("")) {
            model.setAddBy(Long.parseLong(addBy));
        }
//        model.setAddIp(SHJWeb.getRemoteIp(request));
//        model.setAddIP(SHJWeb.getRemoteIp(request));
        return model;
    }

}
