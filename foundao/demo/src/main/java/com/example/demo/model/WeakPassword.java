package com.example.demo.model;

import java.io.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Properties;

public class WeakPassword {

    private HashSet<String> weakPasswordSet = new HashSet<>();

    private String password;

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    //构造方法,初始化获取弱密码
    public WeakPassword(){
        parseWeakPasswordSet();
    }

    //获取弱密码类
    public HashSet<String> getWeakPasswordSet(){
        return weakPasswordSet;
    }

    //从文件中解析txt文件,一行一行获取,放入HashSet中
    private void parseWeakPasswordSet(){
        try{
            String path = this.getClass().getResource("/").getPath();
            File files = new File(path);
            String[] list = files.list();
            List<String> rightFileName =  new ArrayList<>();
            for (String s : list) {
                if (s.endsWith(".txt")){
                    System.out.println(s);
                    rightFileName.add(s);
                }
            }
            if (rightFileName.size() != 0){
                File file = new File(path + "/" + rightFileName.get(0));// Text文件
                BufferedReader br = new BufferedReader(new FileReader(file));// 构造一个BufferedReader类来读取文件
                String s;
                int count = 10;
                while ((s = br.readLine()) != null) {// 使用readLine方法，一次读一行
                    count--;
                    if (count < 0){
                        break;
                    }
                    weakPasswordSet.add(s);
                    System.out.println(s);
                }
                System.out.println(".......启动时....创建WeakPassword........" + path);
            }
        }catch(Exception e){
            e.printStackTrace();
        }
    }

}
