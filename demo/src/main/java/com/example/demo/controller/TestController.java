package com.example.demo.controller;

import com.example.demo.utils.RedisUtil;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

@RestController
@RequestMapping(value = "/test")
public class TestController {

    @Resource(name = "redisUtil")
    private RedisUtil redisUtil;

    @RequestMapping(value = "/login",headers = "accept=*/*",produces = "application/json",method = RequestMethod.POST)
    public String login(HttpServletRequest request, @RequestBody String userInfo){




        return userInfo;
    }

}
