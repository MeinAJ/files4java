package com.aj.common.utils.controller;

import com.aj.common.utils.Jwt.JwtService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import javax.annotation.Resource;

/**
 * this is a class
 *
 * @author Administrator
 * @create 2018-03-01 13:06
 */

@RestController
public class JwtController extends BaseController {

    @Resource(name = "jwtService")
    private JwtService jwtService;

    @RequestMapping(value = "/jwt/authJwt",method = RequestMethod.GET)
    public String authJwt(@RequestParam(value = "jwt")String jwt){
        return jwtService.authJwt(jwt);
    }

    @RequestMapping(value = "/jwt/createJwt",method = RequestMethod.GET)
    public String ceateJwt(@RequestParam(value = "userName")String userName,
                           @RequestParam(value = "uuid")String uuid,
                           @RequestParam(value = "userId")Long userId,
                           @RequestParam(value = "agent")String agent){
        return jwtService.createJwt(userName,userId,uuid,agent);
    }
}
