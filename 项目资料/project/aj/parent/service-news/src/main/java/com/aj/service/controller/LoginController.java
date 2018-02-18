package com.aj.service.controller;

import com.aj.service.model.AJResult;
import com.aj.service.model.MUser;
import com.aj.service.service.UserService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

/**
 * this is a login controller
 *
 * @author Administrator
 * @create 2018-02-17 21:59
 */

@SuppressWarnings("static-access")
@RestController
@RequestMapping("/user")
public class LoginController extends BaseController {

    //user服务
    @Resource(name = "userService")
    private UserService userService;

    //登录
    @RequestMapping(value = "/login",method = RequestMethod.POST,headers = "accept=*/*",produces = "application/json;charset=utf-8")
    public String login(HttpServletRequest request, @RequestBody MUser mUser){
        String resultInfo = "";
        AJResult ajResult = new AJResult();
        try {
            resultInfo = userService.login(json.toJSONString(mUser));
        }catch (Exception e){
            e.printStackTrace();
            logger.error("登录失败");
            ajResult.setCode("400");
            ajResult.setMsg("登录失败");
            return json.toJSONString(ajResult);
        }
        return resultInfo;
    }

    //注册
    @RequestMapping(value = "/register",method = RequestMethod.POST,headers = "accept=*/*",produces = "application/json;charset=utf-8")
    public String register(){
        String resultInfo = "";
        AJResult ajResult = new AJResult();
        try {

        }catch (Exception e){
            e.printStackTrace();
            logger.error("注册失败");
            ajResult.setCode("400");
            ajResult.setMsg("注册失败");
            return json.toJSONString(ajResult);
        }
        return null;
    }
}
