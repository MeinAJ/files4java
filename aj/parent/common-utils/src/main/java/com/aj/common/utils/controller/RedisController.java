package com.aj.common.utils.controller;

import com.aj.common.utils.redis.RedisService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.websocket.server.PathParam;

/**
 * this is a redis controller
 *
 * @author Administrator
 * @create 2018-03-01 11:39
 */

@SuppressWarnings("static-access")
@RestController
public class RedisController extends BaseController{

    @Resource(name = "redisService")
    private RedisService redisService;

    /**
     * 通过key,获取value
     */
    @RequestMapping(value = "/redis/getKey",method = RequestMethod.GET)
    public String getKey(@RequestParam(value = "key")String key){
        Object value = redisService.getKey(key);
        return json.toJSONString(value);
    }

    /**
     * 设置key
     */
    @RequestMapping(value = "/redis/setKey",method = RequestMethod.GET)
    public void setKey(@RequestParam(value = "key")String key,
                         @RequestParam(value = "value")Object value){
        redisService.setKey(key,value,30);
    }

    /**
     * 清除缓存
     */
    @RequestMapping(value = "/redis/removeKey",method = RequestMethod.GET)
    public void removeKey(@RequestParam(value = "key")String key){
        redisService.removeKey(key);
    }

    /**
     * 设置key
     */
    @RequestMapping(value = "/redis/setKey",method = RequestMethod.GET)
    public void setKeyByMinutes(@RequestParam(value = "key")String key,
                                @RequestParam(value = "value")Object value,
                                @RequestParam(value = "minutes")Integer minutes){
        redisService.setKeyByMinutes(key,value,minutes);
    }
}
