package com.aj.service.utils;

import java.util.UUID;

/**
 * this is a class
 *
 * @author Administrator
 * @create 2018-03-02 22:08
 */

public class NumberUtils {

    static String getUUID32() {
        return UUID.randomUUID().toString().trim().replaceAll("-", "");
    }
}
