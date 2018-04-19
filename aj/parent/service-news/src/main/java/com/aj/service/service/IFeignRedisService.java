package com.aj.service.service;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * this is a class
 *
 * @author Administrator
 * @create 2018-02-25 22:31
 */

@FeignClient(value = "common-utils")
public interface IFeignRedisService {

    @RequestMapping(value = "/redis/getKey",method = RequestMethod.GET)
    String getKey(@RequestParam(value = "key") String key);

    @RequestMapping(value = "/redis/setKey",method = RequestMethod.GET)
    String setKey(
                  @RequestParam(value = "key") String key,
                  @RequestParam(value = "value") String value);

    @RequestMapping(value = "/redis/removeKey",method = RequestMethod.GET)
    void removeKey( @RequestParam(value = "key") String key);

    @RequestMapping(value = "/redis/setKeyByMinutes",method = RequestMethod.GET)
    void setKeyByMinutes(
            @RequestParam(value = "key") String key,
            @RequestParam(value = "value") String value,
            @RequestParam(value = "minutes") Integer minutes);
}
