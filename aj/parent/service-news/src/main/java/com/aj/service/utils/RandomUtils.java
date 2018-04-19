package com.aj.service.utils;

import java.util.Random;
import java.util.UUID;
import java.util.stream.IntStream;

/**
 * this is a class 4 random char
 *
 * @author Administrator
 * @create 2018-02-22 23:17
 */

public class RandomUtils {

    //生成唯一标识
    public static String getUUID(){
        return UUID.randomUUID().toString().trim().replaceAll("-","");
    }

    //生成4位随机数字
    public static String getRandomSMS(){
        Random random = new Random();
        StringBuilder result= new StringBuilder();
        for (int i=0;i<4;i++)
        {
            result.append(random.nextInt(10));
        }
        return result.toString();
    }
}
