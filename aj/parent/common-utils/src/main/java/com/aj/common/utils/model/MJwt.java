package com.aj.common.utils.model;

/**
 * this is a class 4 jwt
 *
 * @author Administrator
 * @create 2018-02-22 22:41
 */

public class MJwt {

    //jti--jwt的唯一身份标识,作为一次性token,避免重放攻击
    private String jti;

    //sub--jwt面向的用户
    private String sub;

    //iss--jwt签发者
    private String iss;

    public String getJti() {
        return jti;
    }

    public void setJti(String jti) {
        this.jti = jti;
    }

    public String getSub() {
        return sub;
    }

    public void setSub(String sub) {
        this.sub = sub;
    }

    public String getIss() {
        return iss;
    }

    public void setIss(String iss) {
        this.iss = iss;
    }
}
