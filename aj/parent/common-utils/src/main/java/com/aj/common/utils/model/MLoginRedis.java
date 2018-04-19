package com.aj.common.utils.model;

public class MLoginRedis {

    private String  uuId;

    private String jwt;

    public String getUuId() {
        return uuId;
    }

    public void setUuId(String uuId) {
        this.uuId = uuId;
    }

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
}
