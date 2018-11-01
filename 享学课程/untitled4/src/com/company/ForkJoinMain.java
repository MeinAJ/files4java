package com.company;

import java.io.File;
import java.nio.file.Files;
import java.util.Date;
import java.util.List;
import java.util.concurrent.Exchanger;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.RecursiveTask;

public class ForkJoinMain {

    private static Exchanger<List<Long>> exchanger = new Exchanger<>();

    public static void main(String[] args) throws ExecutionException, InterruptedException {

        /**
         * 实现一个文件目录下的.java文件名字打印
         */
        Long beforeTime = new Date().getTime();

        File file = new File("E:\\");
        Num num = new Num();
        num = printAbsolutePathNameNormalMethod(file,num);
        System.out.println("count = " + num.toString());

        Long afterTime = new Date().getTime();
        System.out.println("总共耗时==" + (afterTime - beforeTime));





    }

    public static Num printAbsolutePathNameNormalMethod(File file,Num num){

        if (file.exists()){
            File[] files = file.listFiles();
            if (files == null){
                return num;
            }
            for (File file1 : files) {
                if (file1.isFile() && (file1.getAbsolutePath().endsWith(".java") || file1.getAbsolutePath().endsWith(".java"))){
                    //是文件
                    num.setCount((num.getCount() + 1));
                    System.out.println("路径=" + file1.getAbsolutePath());
                } else if(file1.isDirectory()){
                    num.setDicNum((num.getDicNum()) + 1);
                    num = printAbsolutePathNameNormalMethod(file1,num);
                }
            }
        }
        return num;
    }

}
