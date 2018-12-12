package com.foundao.password.utils;

public class Const {

    //中密码
    public static final String C_MID_REGEX = "^(?![0-9]+$)(?![a-zA-Z]+$)[0-9A-Za-z]{8,16}$";
    //强密码
    public static final String C_STRONG_REGEX = "^(?![0-9]+$)(?![^0-9]+$)(?![a-zA-Z]+$)(?![^a-zA-Z]+$)(?![a-zA-Z0-9]+$)[a-zA-Z0-9\\S]+$";
    //全是数字正则
    public static final String ALL_DIGITAL_REGEX = "[0-9]*";
    //全是字母正则
    public static final String ALL_CHAR_REGEX = "^[A-Za-z]+$";
    //返回数据的msg内容
    public static final String MSG_DETAIL = "没有接口文档;当你看到这段话时,接口正常;passwordLevel字段是枚举值,C_WEAK:弱;C_MID:中;C_STRONG:强";

    /**
     * 定义一下返回json字段字符常量
     */
    public static final String FAIL_CODE = "400";
    public static final String SUCCESS_CODE = "200";
    public static final String OPERATE_CODE = "401";
    public static final String FAIL_MSG = "FAIL";
    public static final String SUCCESS_MSG = MSG_DETAIL;
    public static final String OPERATE_MSG = "OPERATE_ERROR";
}
