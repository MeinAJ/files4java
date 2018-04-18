package com.aj.service.model;

public class MLoginRedis {

    private String  uuId;

    private String jwt;

    private Long userId;

    public String getUuId() {
        return uuId;
    }

    public void setUuId(String uuId) {
        this.uuId = uuId;
    }

    public MLoginRedis(){}

    public MLoginRedis(String uuId, String jwt) {
        this.uuId = uuId;
        this.jwt = jwt;
    }

    public String getJwt() {
        return jwt;
    }

    public void setJwt(String jwt) {
        this.jwt = jwt;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }
}
