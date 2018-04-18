package com.aj.service.service;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(value = "common-utils")
public interface IFeignJwtService {

    /**
     * 创建jwt
     * @param userName
     * @param uuid
     * @param userId
     * @param agent
     * @return
     */
    @RequestMapping(value = "/jwt/createJwt",method = RequestMethod.GET)
    public String createJwt(@RequestParam(value = "userName")String userName,
                            @RequestParam(value = "userId")Long userId,
                            @RequestParam(value = "uuid")String uuid,
                            @RequestParam(value = "agent")String agent);

    /**
     * 解析jwt
     * @param jwt
     * @return
     */
    @RequestMapping(value = "/jwt/authJwt",method = RequestMethod.GET)
    public String authJwt(@RequestParam(value = "jwt")String jwt);

}
