package com.aj.service.model;

/**
 * this is a user model
 *
 * @author Administrator
 * @create 2018-02-17 22:32
 */

public class MUser{

    private Long id;

    private String name;

    private Long phone;

    private String password;

    private Long addAt;

    private String jwt;

    //发送短信时的key值
    private String redisKey;

    //验证码
    private String smsCode;

    public String getSmsCode() {
        return smsCode;
    }

    public void setSmsCode(String smsCode) {
        this.smsCode = smsCode;
    }

    public String getRedisKey() {
        return redisKey;
    }

    public void setRedisKey(String redisKey) {
        this.redisKey = redisKey;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getPhone() {
        return phone;
    }

    public void setPhone(Long phone) {
        this.phone = phone;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Long getAddAt() {
        return addAt;
    }

    public void setAddAt(Long addAt) {
        this.addAt = addAt;
    }

    public String getJwt() {
        return jwt;
    }

    public void setJwt(String jwt) {
        this.jwt = jwt;
    }
}
