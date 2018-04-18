package com.aj.service.controller;

import com.aj.service.model.AJResult;
import com.aj.service.model.MUser;
import com.aj.service.service.IFeignRedisService;
import com.aj.service.service.UserService;
import com.aj.service.utils.AJCode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.websocket.server.PathParam;

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

    @Autowired
    private IFeignRedisService redisService;

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
            logger.error("login,登录失败,参数="+json.toJSONString(mUser)+",e="+e);
            ajResult.setCode(AJCode.FAIL);
            ajResult.setMsg("登录失败!");
            return json.toJSONString(ajResult);
        }
        return resultInfo;
    }

    //注册
    @RequestMapping(value = "/register",method = RequestMethod.POST,headers = "accept=*/*",produces = "application/json;charset=utf-8")
    public String register(HttpServletRequest request, @RequestBody MUser mUser){
        String resultInfo = "";
        AJResult ajResult = new AJResult();
        try {
            resultInfo = userService.register(json.toJSONString(mUser));
        }catch (Exception e){
            e.printStackTrace();
            logger.error("login,注册失败,参数="+json.toJSONString(mUser)+",e="+e);
            ajResult.setCode(AJCode.FAIL);
            ajResult.setMsg("注册失败");
            return json.toJSONString(ajResult);
        }
        return resultInfo;
    }

    //发送验证码
    @RequestMapping(value = "/sms",method = RequestMethod.GET,headers = "accept=*/*",produces = "application/json;charset=utf-8")
    public String register(HttpServletRequest request, @PathParam(value = "phone") Long phone){
        String resultInfo = "";
        AJResult ajResult = new AJResult();
        MUser mUser = new MUser();
        try {
            mUser.setPhone(phone);
            resultInfo = userService.sendSMS(json.toJSONString(mUser));
        }catch (Exception e){
            e.printStackTrace();
            logger.error("login,发送验证码失败,参数="+json.toJSONString(mUser)+",e="+e);
            ajResult.setCode(AJCode.FAIL);
            ajResult.setMsg("发送验证码失败");
            return json.toJSONString(ajResult);
        }
        return resultInfo;
    }

}
