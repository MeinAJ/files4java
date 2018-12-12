package com.foundao.password.model;

import com.foundao.password.utils.Const;

public class FoundaoResult {

    //默认是200
    private String code = Const.SUCCESS_CODE;

    //默认成功
    private String msg = Const.MSG_DETAIL;

    private Object data;

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
