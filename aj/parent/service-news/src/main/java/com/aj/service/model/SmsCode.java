package com.aj.service.model;

import com.aj.service.utils.Base;

/**
 * .
 *
 * @author Administrator
 * @create 2018-04-15 18:48
 */

public class SmsCode extends Base {

    private String smsCode;

    private Long phone;

    private String redisKey;

    private String num;

    public String getNum() {
        return num;
    }

    public void setNum(String num) {
        this.num = num;
    }

    public String getSmsCode() {
        return smsCode;
    }

    public void setSmsCode(String smsCode) {
        this.smsCode = smsCode;
    }

    public Long getPhone() {
        return phone;
    }

    public void setPhone(Long phone) {
        this.phone = phone;
    }

    public String getRedisKey() {
        return redisKey;
    }

    public void setRedisKey(String redisKey) {
        this.redisKey = redisKey;
    }
}
