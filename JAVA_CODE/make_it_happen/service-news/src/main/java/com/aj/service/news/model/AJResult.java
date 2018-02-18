package com.aj.service.news.model;

public class AJResult {

    //code
    private String code;

    //msg
    private String msg;

    //data
    private Object data;

    public AJResult() {
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
