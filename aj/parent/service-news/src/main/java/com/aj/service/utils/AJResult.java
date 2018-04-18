package com.aj.service.utils;

/**
 * this is a class
 *
 * @author Administrator
 * @create 2018-03-02 22:14
 */

public class AJResult {

    private String code;
    private String msg;
    private Object data;

    public AJResult(){
        this.code = "200";
        this.msg = "SUCCESS";
        this.data = null;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }
}
