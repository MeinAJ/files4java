package com.aj.service.utils;

import sun.font.TrueTypeFont;

/**
 * this is a class 4 string
 *
 * @author Administrator
 * @create 2018-02-23 0:07
 */

public class StringUtils {

    //验证是否是否为空
    public static String validString(String str){
        if (str == null || "".equals(str)){
            return "";
        }
        return str;
    }

    //验证是否是否为空
    public static boolean validStr(String str){
        if (str == null || "".equals(str)){
            return false;
        }
        return true;
    }
}
