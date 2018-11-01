package com.company;

import java.util.Random;

public class ArraySum {

    public static final int ARRAY_LENGTH  = 100000;

    public Integer[] getArray(){
        Integer[] integerArr = new Integer[ARRAY_LENGTH];
        for (int i = 0;i < ARRAY_LENGTH;i++){
            integerArr[i] = i;
        }
        return integerArr;
    }

}
